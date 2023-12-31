/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tda_grafo;

import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * @author Luis Romero
 * @param <V>
 * @param <E>
 *
 */
public class GrafoDM<V, E> {//V es para el tipo de datos de los vetices y E para el tipo de dato de los arcos

    private LinkedList<Vertex<V, E>> listVertex;   //El orden es bien importante
    private boolean isDirict = false;
    private Comparator<V> cmp;

    public GrafoDM(boolean isDirict, Comparator<V> cmp) {
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

    public Vertex<V, E> findVertex(V content) {
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
        Edge<E, V> arco = new Edge<>(vertStart, vertEnd, weight);
        if (this.isDirict) {
            vertStart.getListEdge().add(arco);
            return true;
        }
        vertStart.getListEdge().add(arco);
        vertEnd.getListEdge().add(arco);
        return true;
    }

}
