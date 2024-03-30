package tda;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class GraphAM<V, E> implements Graph<V, E> {

    private V[] vertices;
    private int[][] adjacencyMatrix;
    private E[][] edgesData;
    private int capacity = 100;
    private int effectiveSize;
    private boolean isDirected;
    private Comparator<V> cmpVertices;
    private Comparator<E> cmpEdges;

    public GraphAM(boolean isDirected, Comparator<V> cmpVertices, Comparator<E> cmpEdges) {
        this.isDirected = isDirected;
        this.cmpVertices = cmpVertices;
        this.cmpEdges = cmpEdges;
        this.vertices = (V[]) new Object[this.capacity];
        this.adjacencyMatrix = new int[this.capacity][this.capacity];
        this.edgesData = (E[][]) new Object[this.capacity][this.capacity];
    }

    @Override
    public boolean connect(V source, V target) {
        return connect(source, target, 1);
    }

    @Override
    public boolean connect(V source, V target, int weight) {
        return connect(source, target, weight, null);
    }

    private int findVertex(V v) {
        for (int i = 0; i < effectiveSize; i++) {
            if (this.cmpVertices.compare(v, vertices[i]) == 0) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean connect(V source, V target, int weight, E connectionData) {
        if (source == null || target == null) {
            return false;
        }
        int i1 = findVertex(source);
        int i2 = findVertex(target);
        if (i1 != -1 && i2 != -1) {
            this.adjacencyMatrix[i1][i2] = weight;
            this.edgesData[i1][i2] = connectionData;
            if (!this.isDirected) {
                this.adjacencyMatrix[i2][i1] = weight;
                this.edgesData[i2][i1] = connectionData;
            }
            return true;
        }
        return false;
    }

    @Override
    public List<V> breadthTraversal(V start) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<V> depthTraversal(V start) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addVertex(V content) {
        if (content == null || this.hasVertex(content)) {
            return false;
        }
        // chequear tamaño y hacer crecer si fuera necesario
        if (this.isFull()) {
            // llamar a addCapacity
            this.addCapacity();
        }
        this.vertices[effectiveSize++] = content;
        System.out.println("check");
        return true;
    }

    private boolean isFull() {
        return this.effectiveSize == this.capacity;
    }

    private void addCapacity() {
        int newValue = capacity * 2;
        int[][] adjMatrixNEW = new int[newValue][newValue];
        E[][] metadataMatrixNEW = (E[][]) new Object[newValue][newValue];
        for (int i = 0; i < capacity; i++) {
            for (int j = 0; j < capacity; j++) {
                adjMatrixNEW[i][j] = this.adjacencyMatrix[i][j];
                metadataMatrixNEW[i][j] = this.edgesData[i][j];
            }
        }
        V[] newElements = (V[]) new Object[newValue];
        for (int i = 0; i < this.vertices.length; i++) {
            newElements[i] = this.vertices[i];
        }
        this.vertices = newElements;
        this.adjacencyMatrix = adjMatrixNEW;
        this.edgesData = metadataMatrixNEW;
        this.capacity = newValue;
    }

    @Override
    public boolean hasVertex(V content) {

        for (V vertex : vertices) {
            if (vertex != null && content != null) {
                if (this.cmpVertices.compare(content, vertex) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean removeVertex(V content) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean removeEdge(V source, V target) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public LinkedList<V> dijkstra(V initial) {
        if (this.vertices.length == 0 || !this.hasVertex(initial) || initial == null || !this.isDirected) {
            return null;
        }
        LinkedList<V> listDijkstra = new LinkedList<>();
        int startIndex = findVertex(initial);

        int[] distances = new int[effectiveSize];
        int[] predecessors = new int[effectiveSize];
        boolean[] visited = new boolean[effectiveSize];

        // Inicializar distancias y predecesores
        for (int i = 0; i < effectiveSize; i++) {
            distances[i] = Integer.MAX_VALUE;
            predecessors[i] = -1;
        }

        distances[startIndex] = 0; // La distancia al mismo vértice es 0

        // Cola de prioridad para almacenar los vértices ordenados por distancia
        Queue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(i -> distances[i]));

        priorityQueue.offer(startIndex);

        while (!priorityQueue.isEmpty()) {
            int current = priorityQueue.poll();

            if (visited[current]) {
                continue;
            }

            visited[current] = true;
            listDijkstra.add(vertices[current]);

            for (int neighbor = 0; neighbor < effectiveSize; neighbor++) {
                if (!visited[neighbor] && adjacencyMatrix[current][neighbor] > 0) {
                    int newDistance = distances[current] + adjacencyMatrix[current][neighbor];

                    if (newDistance < distances[neighbor]) {
                        distances[neighbor] = newDistance;
                        predecessors[neighbor] = current;
                        priorityQueue.offer(neighbor);
                    }
                }
            }
        }

        return listDijkstra;
    }

    public int[][] getIsAdjacentMatrix() {
        if (this.vertices == null || this.vertices.length == 0) {
            return null;
        }
        int[][] isAdjMatrix = new int[this.effectiveSize][this.effectiveSize];
        for (int i = 0; i < effectiveSize; i++) {
            for (int j = 0; j < effectiveSize; j++) {
                if (i != j && this.adjacencyMatrix[i][j] > 0) {
                    isAdjMatrix[i][j] = 1;
                }
            }
        }

        return isAdjMatrix;
    }

    public V[] getVertices() {
        return vertices;
    }

    public int[][] getAdjacencyMatrix() {
        int[][] adjM = new int[this.effectiveSize][this.effectiveSize];
        for (int i = 0; i < effectiveSize; i++) {
            for (int j = 0; j < effectiveSize; j++) {
                adjM[i][j] = adjacencyMatrix[i][j];
                if(i!=j && adjM[i][j] == 0){
                    adjM[i][j] = Integer.MAX_VALUE;
                }
            }
        }       
        return adjM;
    }

    public int[][] floyd_Warshall(){
        if (this.vertices == null || this.vertices.length == 0) {
            return null;
        }
        int[][] distMatrix = this.getAdjacencyMatrix();
        for (int k = 0; k < this.effectiveSize; k++) {
            for (int i = 0; i < this.effectiveSize; i++) {
                for (int j = 0; j < this.effectiveSize; j++) {
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
        if (this.vertices == null || this.vertices.length == 0) {
            return null;
        }
        int[][] isAdjacentMatrix = getIsAdjacentMatrix();
        int[][] transitiveClosure = new int[this.effectiveSize][this.effectiveSize];

        // Inicializar la matriz de cierre transitivo con los valores de la matriz de adyacencia
        for (int i = 0; i < this.effectiveSize; i++) {
            for (int j = 0; j < this.effectiveSize; j++) {
                transitiveClosure[i][j] = isAdjacentMatrix[i][j];
            }
        }

        // Algoritmo de Warshall
        for (int k = 0; k < this.effectiveSize; k++) {
            for (int i = 0; i < this.effectiveSize; i++) {
                for (int j = 0; j < this.effectiveSize; j++) {
                    if (transitiveClosure[i][k] == 1 && transitiveClosure[k][j] == 1) {
                        transitiveClosure[i][j] = 1;
                    }
                }
            }
        }

        return transitiveClosure;
    }

}
