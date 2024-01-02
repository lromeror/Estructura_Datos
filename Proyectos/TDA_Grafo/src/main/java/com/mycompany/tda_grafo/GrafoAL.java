/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tda_grafo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Luis Romero
 * @param <V>
 * @param <E>
 *
 */
public class GrafoAL<V, E> {//V es para el tipo de datos de los vetices y E para el tipo de dato de los arcos

    private LinkedList<Vertex<V, E>> listVertex;   //El orden es bien importante
    private boolean isDirict = false;
    private Comparator<V> cmp;

    public GrafoAL(boolean isDirict, Comparator<V> cmp) {
        this.listVertex = new LinkedList<>();
        this.isDirict = isDirict;
        this.cmp = cmp;
    }

    public boolean addVertex(V content) {
        if (content == null || this.findVertex(content) != null) {
            return false;
        }
        this.findVertex(content);
        Vertex<V, E> vertice = new Vertex<>(content);
        this.listVertex.add(vertice);
        return false;
    }

    private Vertex<V, E> findVertex(V content) {
        for (Vertex<V, E> ver : this.listVertex) {
            V conte = ver.getContent();
            if (cmp.compare(conte, content) == 0) {
                return ver;
            }
        }
        return null;
    }

    public boolean toConect(V start, V end, int weight, E data) {
        if (start == null || end == null) {
            return false;
        }
        Vertex<V, E> vertStart = this.findVertex(start);
        Vertex<V, E> vertEnd = this.findVertex(end);

        if (vertStart == null || vertEnd == null) {
            return false;
        }
        Edge<E, V> arcoIda = new Edge<>(vertStart, vertEnd, weight);
        if (this.isDirict) {
            vertStart.getListEdge().add(arcoIda);
            return true;
        }
        vertStart.getListEdge().add(arcoIda);
        Edge<E, V> arcoVuel = new Edge<>(vertEnd, vertStart, weight);
        vertEnd.getListEdge().add(arcoVuel);
        return true;
    }

    public boolean isAdyancent(V conten1, V conten2) {
        if (conten1 == null || conten2 == null) {
            return false;
        }

        Vertex<V, E> v1 = this.findVertex(conten1);
        Vertex<V, E> v2 = this.findVertex(conten2);

        if (v1 == null || v2 == null) {
            return false;
        }
        for (Edge<E, V> edge : v1.getListEdge()) {
            V contDes = edge.getEnd().getContent();
            if (cmp.compare(contDes, conten2) == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GrafoDM:\n");
        sb.append("Directed: ").append(isDirict).append("\n");
        sb.append("Comparator: ").append(cmp.getClass().getSimpleName()).append("\n");
        sb.append("Vertices:\n");
        for (Vertex<V, E> vertex : listVertex) {
            sb.append(vertex.getContent()).append(" -> Edges: ");
            for (Edge<E, V> edge : vertex.getListEdge()) {
                sb.append("(").append(edge.getStart().getContent()).append(" -> ")
                        .append(edge.getEnd().getContent()).append(", Weight: ")
                        .append(edge.getWeight()).append(") ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public LinkedList<Vertex<V, E>> recoAnchura(V content) {
        LinkedList<Vertex<V, E>> reAn = new LinkedList<>();
        if (content == null) {
            return null;
        }
        Vertex<V, E> vertice = this.findVertex(content);
        if (vertice == null) {
            return null;
        }
        Queue<Vertex<V, E>> cola = new LinkedList<>();
        cola.offer(vertice);
        vertice.setVisited(true);

        while (!cola.isEmpty()) {
            Vertex<V, E> vert = cola.poll();
            reAn.add(vert);
            for (Edge<E, V> ari : vert.getListEdge()) {
                if (!ari.getEnd().isVisited()) {
                    cola.offer(ari.getEnd());
                    ari.getEnd().setVisited(true);
                }
            }
        }
        this.changeVisit(reAn, false);
        return reAn;
    }

    public LinkedList<Vertex<V, E>> recoProfun(V content) {
        LinkedList<Vertex<V, E>> rePro = new LinkedList<>();
        if (content == null) {
            return null;
        }
        Vertex<V, E> vertice = this.findVertex(content);
        if (vertice == null) {
            return null;
        }
        Stack<Vertex<V, E>> pila = new Stack<>();
        pila.push(vertice);
        vertice.setVisited(true);

        while (!pila.isEmpty()) {
            Vertex<V, E> vert = pila.pop();
            rePro.add(vert);
            for (Edge<E, V> ari : vert.getListEdge()) {
                if (!ari.getEnd().isVisited()) {
                    pila.push(ari.getEnd());
                    ari.getEnd().setVisited(true);
                }
            }
        }
        this.changeVisit(rePro, false);
        return rePro;
    }

    private void changeVisit(LinkedList<Vertex<V, E>> vertices, boolean bool) {
        for (Vertex<V, E> vert : vertices) {
            vert.setVisited(bool);
        }
    }

    public boolean isConexo() {
        //Esto es si no es Dirigido
        LinkedList<Vertex<V, E>> vertiVisited = this.recoAnchura(this.listVertex.get(0).getContent());
        return this.listVertex.size() <= vertiVisited.size();
    }

    public int compConexas() {
    int contador = 1; // Inicializar el contador en 0

    if (!this.isConexo()) {
        LinkedList<Vertex<V, E>> vertiVisited = this.recoAnchura(this.listVertex.get(0).getContent());
        this.changeVisit(vertiVisited, true);
        
        for (Vertex<V,E> vert:this.listVertex) {
            if (!vert.isVisited()) {
                LinkedList<Vertex<V, E>> componenteConexa = this.recoAnchura(vert.getContent());
                this.changeVisit(componenteConexa, true);
                contador++;
            }
        }
    }
    return contador;
}

}
