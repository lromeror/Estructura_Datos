package tda;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class GraphAL<V, E> implements Graph<V, E> {

    private List<Vertex> vertices;
    private boolean isDirected;
    private Comparator<V> cmpVertices;
    private Comparator<E> cmpEdges;

    public GraphAL(boolean isDirected, Comparator<V> cmpVertices, Comparator<E> cmpEdges) {
        this.isDirected = isDirected;
        this.cmpVertices = cmpVertices;
        this.cmpEdges = cmpEdges;
        this.vertices = new LinkedList<>();
    }

    @Override
    public boolean addVertex(V content) {
        Vertex<V, E> newVertex = new Vertex<>(content);
        return (content == null || this.hasVertex(content)) ? false : vertices.add(newVertex);
    }

    @Override
    public boolean hasVertex(V content) {
        for (Vertex<V, E> v : vertices) {
            if (v != null && content != null) {
                if (this.cmpVertices.compare(content, v.getContent()) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private Vertex<V, E> findVertex(V content) {
        for (Vertex<V, E> v : vertices) {
            if (this.cmpVertices.compare(content, v.getContent()) == 0) {
                return v;
            }
        }
        return null;
    }

    @Override
    public boolean removeVertex(V content) {
        if (content == null) {
            return false;
        }
        Vertex<V, E> v = findVertex(content);
        if (v == null) {
            return false;
        }
        for (Vertex<V, E> vertex : vertices) {
            Iterator<Edge<E, V>> edgesIterator = vertex.getEdges().iterator();
            while (edgesIterator.hasNext()) {
                Edge<E, V> currentEdge = edgesIterator.next();
                Vertex<V, E> currentSource = currentEdge.getSource();
                Vertex<V, E> currentTarget = currentEdge.getTarget();
                if (this.cmpVertices.compare(currentSource.getContent(), v.getContent()) == 0
                        || this.cmpVertices.compare(currentTarget.getContent(), v.getContent()) == 0) {
                    edgesIterator.remove();
                }
            }
        }

        v.setContent(null);
        v.setEdges(null);
        vertices.remove(v);
        return true;

    }

    @Override
    public boolean connect(V source, V target) {
        return connect(source, target, 1, null);
    }

    @Override
    public boolean connect(V source, V target, int weight) {
        return connect(source, target, weight, null);
    }

    @Override
    public boolean connect(V source, V target, int weight, E metadata) {
        if (source == null || target == null) {
            return false;
        }

        Vertex<V, E> vSource = findVertex(source);
        Vertex<V, E> vTarget = findVertex(target);

        if (vSource == null || vTarget == null) {
            return false;
        }

        Edge<E, V> e = new Edge<>(vSource, vTarget, weight, metadata);

        vSource.getEdges().add(e);
        if (!this.isDirected) {
            Edge<E, V> e1 = new Edge<>(vTarget, vSource, weight, metadata);
            vTarget.getEdges().add(e1);
        }
        return true;
    }

    @Override
    public boolean removeEdge(V source, V target) {
        if (source == null || target == null) {
            return false;
        }
        Vertex<V, E> vSource = findVertex(source);
        Vertex<V, E> vTarget = findVertex(target);
        if (vSource == null || vTarget == null) {
            return false;
        }
        List<Edge<E, V>> edges = vSource.getEdges();
        Iterator<Edge<E, V>> edgesIterator = edges.iterator();
        while (edgesIterator.hasNext()) {
            Edge<E, V> e = edgesIterator.next();
            if (this.cmpVertices.compare(e.getTarget().getContent(), vTarget.getContent()) == 0) {
                edgesIterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder v = new StringBuilder();
        v.append(" vertices = {");

        StringBuilder a = new StringBuilder();
        a.append(" edges = {");

        for (Vertex<V, E> vertex : vertices) {
            v.append(vertex.getContent());
            v.append(", ");
            for (Edge<E, V> e : vertex.getEdges()) {
                a.append(e.toString());
                a.append(", ");
            }
        }
        if (!vertices.isEmpty()) {
            v.delete(v.length() - 2, v.length());
        }
        if (a.length() > 4) {
            a.delete(a.length() - 2, a.length());
        }

        v.append("}");
        a.append("}");
        return v.toString() + "\n" + a.toString();
    }

    @Override
    public List<V> breadthTraversal(V start) { // ancho
        if (start == null || !this.hasVertex(start)) {
            return null;
        }
        LinkedList<V> anchura = new LinkedList<>();
        Queue<Vertex<V, E>> cola = new ArrayDeque<>();
        Vertex<V, E> initialVertex = this.findVertex(start);
        cola.offer(initialVertex);
        while (!cola.isEmpty()) {
            Vertex<V, E> v = cola.poll();
            v.setVisited(true);
            anchura.add(v.getContent());
            for (Edge<E, V> edge : v.getEdges()) {
                Vertex<V, E> newVertex = edge.getTarget();
                if (!newVertex.isVisited()) {
                    newVertex.setVisited(true);
                    cola.offer(edge.getTarget());
                }
            }
        }

        return anchura;
    }

    @Override
    public List<V> depthTraversal(V start) { // profundidad
        if (start == null || !this.hasVertex(start)) {
            return null;
        }
        LinkedList<V> profundidad = new LinkedList<>();
        Stack<Vertex<V, E>> remmember = new Stack<>();
        Vertex<V, E> initialVertex = this.findVertex(start);
        remmember.push(initialVertex);
        while (!remmember.isEmpty()) {
            Vertex<V, E> v = remmember.pop();
            profundidad.add(v.getContent());
            for (Edge<E, V> edge : v.getEdges()) {
                Vertex<V, E> newVertex = edge.getTarget();
                if (!newVertex.isVisited()) {
                    newVertex.setVisited(true);
                    remmember.push(newVertex);
                }
            }
            v.setVisited(true);
        }
        return profundidad;
    }

    public void refreshVisited() {
        for (Vertex<V, E> v : this.vertices) {
            v.setVisited(false);
            v.setBefore(null);
            v.setDistance(Integer.MAX_VALUE);
        }
    }

    public boolean getConnectedComponents(LinkedList<List<V>> componentes) { // lista vacía que se va a llenar de elementos
        if (!this.isDirected) {
            V node;
            List<V> recorrido;
            while (!this.isGraphVisited()) {
                node = this.buscarVerticeNoVisitado();
                recorrido = this.breadthTraversal(node);
                componentes.add(recorrido);
            }
            return componentes.size() == 1;
        } else {
            System.out.println("Es un grafo dirigido");
        }
        this.refreshVisited();
        return false;
    }

    public boolean getStrongConnectedComponents(LinkedList<List<V>> componentes) {
        if (this.isDirected) {
            GraphAL<V, E> inverted = this.generateGraphInverse();
            LinkedList<V> visitedVertex = new LinkedList<>();

            while (!this.isGraphVisited()) {
                for (Vertex<V, E> vertex : this.vertices) {
                    List<V> tempComponent = new LinkedList<>(); // componente del grafo que se formaba a partir de los recorridos
                    if (!vertex.isVisited()) {
                        Set<V> descendente = new LinkedHashSet<>(this.breadthTraversal(vertex.getContent()));
                        Set<V> ascendente = new LinkedHashSet<>(inverted.breadthTraversal(vertex.getContent()));
                        descendente.retainAll(ascendente); // D interseccion A
                        Set<V> tmpComponent = descendente;
                        for (V v : tmpComponent) {
                            Vertex<V, E> originalVertex = this.findVertex(v);
                            Vertex<V, E> invertedVertex = inverted.findVertex(v);
                            tempComponent.add(v);
                            originalVertex.setVisited(true);
                            invertedVertex.setVisited(true);
                            visitedVertex.add(originalVertex.getContent());
                        }
                        componentes.add(tempComponent);
                    }
                }
            }

            this.refreshVisited();
            for (V vertex : visitedVertex) {
                inverted.findVertex(vertex).setVisited(false);
            }
            return componentes.size() == 1;
        } else {
            System.out.println("Es un grafo no dirigido");
        }
        return false;
    }

    private boolean isGraphVisited() {
        for (Vertex<V, E> vertex : this.vertices) {
            if (!vertex.isVisited()) {
                return false;
            }
        }
        return true;
    }

    private GraphAL<V, E> generateGraphInverse() {
        GraphAL<V, E> inverted = new GraphAL<>(this.isDirected, this.cmpVertices, this.cmpEdges); // boolean isDirected, Comparator<V> cmpVertices, Comparator<E> cmpEdges
        for (Vertex<V, E> vertex : this.vertices) {
            inverted.addVertex(vertex.getContent());
        }
        for (Vertex<V, E> vertex : this.vertices) {
            inverted.addVertex(vertex.getContent());
            List<Edge<E, V>> originalEdges = vertex.getEdges();
            for (Edge<E, V> edge : originalEdges) {
                inverted.connect(edge.getTarget().getContent(), edge.getSource().getContent(), edge.getWeight(), edge.getMetadata());
            }
        }
        return inverted;
    }

    private V buscarVerticeNoVisitado() {
        for (Vertex<V, E> vertex : this.vertices) {
            if (!vertex.isVisited()) {
                return vertex.getContent();
            }
        }
        return null;
    }

    public LinkedList<V> dijkstra(V initial) {
        this.refreshVisited();
        if (!this.isDirected || !this.hasVertex(initial) || initial == null) {
            return null;
        }
        LinkedList<V> listDijkstra = new LinkedList<>();

        Vertex<V, E> v_initial = this.findVertex(initial);
        v_initial.setDistance(0);
        Queue<Vertex<V, E>> priority = new PriorityQueue<>((v1, v2) -> {
            return v1.getDistance() - v2.getDistance(); 
        });
        priority.offer(v_initial);
        while (!priority.isEmpty()) {
            Vertex<V, E> vertex = priority.poll();
            vertex.setVisited(true);
            if (!listDijkstra.contains(vertex.getContent())) {
                listDijkstra.add(vertex.getContent());
            }
            for (Edge<E, V> e : vertex.getEdges()) {
                Vertex<V, E> adjacent = e.getTarget();
                if (!adjacent.isVisited() && vertex.getDistance() + e.getWeight() < adjacent.getDistance()) {
                    adjacent.setDistance(vertex.getDistance() + e.getWeight());
                    adjacent.setBefore(vertex);
                    priority.offer(adjacent);
                }
            }
        }
        this.refreshVisited();
        return listDijkstra;
    }

    public int[][] getAdjacentMatrix() {
        if (this.vertices == null || this.vertices.isEmpty()) {
            return null;
        }
        int size = this.vertices.size();
        int[][] adjacentMatrix = new int[size][size];

        // Inicializar la matriz con valores infinitos
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    adjacentMatrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        // Llenar la matriz con los pesos de las aristas
        for (int i = 0; i < size; i++) {
            Vertex<V, E> vertex = this.vertices.get(i);
            List<Edge<E, V>> edges = vertex.getEdges();

            for (Edge<E, V> edge : edges) {
                Vertex<V, E> targetVertex = edge.getTarget();
                int targetIndex = this.vertices.indexOf(targetVertex);

                // Actualizar el peso en la matriz si es menor
                if (edge.getWeight() < adjacentMatrix[i][targetIndex]) {
                    adjacentMatrix[i][targetIndex] = edge.getWeight();
                }

            }
        }
        return adjacentMatrix;
    }

    public int[][] getIsAdjacentMatrix() {
        if (this.vertices == null || this.vertices.isEmpty()) {
            return null;
        }
        int size = this.vertices.size();
        int[][] adjacentMatrix = new int[size][size];

        // Llenar la matriz con los pesos de las aristas
        for (int i = 0; i < size; i++) {
            Vertex<V, E> vertex = this.vertices.get(i);
            List<Edge<E, V>> edges = vertex.getEdges();

            for (Edge<E, V> edge : edges) {
                Vertex<V, E> targetVertex = edge.getTarget();
                int targetIndex = this.vertices.indexOf(targetVertex);
                if (edge.getWeight() > 0) {
                    adjacentMatrix[i][targetIndex] = 1;
                }
            }
        }
        return adjacentMatrix;
    }

    public int[][] floyd_Warshall() {
        if (this.vertices == null || this.vertices.isEmpty()) {
            return null;
        }

        int size = this.vertices.size();
        int[][] distMatrix = getAdjacentMatrix();

        // Algoritmo de Floyd-Warshall
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (distMatrix[i][k] != Integer.MAX_VALUE && distMatrix[k][j] != Integer.MAX_VALUE) {
                        int sum = Math.addExact(distMatrix[i][k], distMatrix[k][j]);
                        if (sum < distMatrix[i][j]) {
                            distMatrix[i][j] = sum;
                        }
                    }
                }
            }
        }

        return distMatrix;
    }

    public int[][] warshall() {
        if (this.vertices == null || this.vertices.isEmpty()) {
            return null;
        }

        int size = this.vertices.size();
        int[][] isAdjacentMatrix = getIsAdjacentMatrix();
        int[][] transitiveClosure = new int[size][size];

        // Inicializar la matriz de cierre transitivo con los valores de la matriz de adyacencia
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                transitiveClosure[i][j] = isAdjacentMatrix[i][j];
            }
        }

        // Algoritmo de Warshall
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (transitiveClosure[i][k] == 1 && transitiveClosure[k][j] == 1) {
                        transitiveClosure[i][j] = 1;
                    }
                }
            }
        }

        return transitiveClosure;
    }

}
