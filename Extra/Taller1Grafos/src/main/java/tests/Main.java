package tests;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import tda.Graph;
import tda.GraphAL;
import tda.GraphAM;

public class Main {

    public static void main(String[] args) {

        Comparator<String> cmpVertices = (s1, s2) -> {
            return s1.compareTo(s2);
        };

        Comparator<String> cmpEdges = (s1, s2) -> {
            return s1.compareTo(s2);
        };

        Graph<String, String> grafo = new GraphAL<>(true, cmpVertices, cmpEdges);

        grafo.addVertex("V1");
        grafo.addVertex("V2");
        grafo.addVertex("V3");
        grafo.addVertex("V4");
        grafo.addVertex("V5");
        grafo.addVertex("V6");

        grafo.connect("V1", "V2", 3, null);
        grafo.connect("V1", "V3", 4, null);
        grafo.connect("V1", "V5", 8, null);
        grafo.connect("V2", "V5", 5, null);
        grafo.connect("V3", "V5", 3, null);
        grafo.connect("V5", "V4", 7, null);
        grafo.connect("V5", "V6", 3, null);
        grafo.connect("V6", "V4", 2, null);

        System.out.println(grafo);
        System.out.println(grafo.depthTraversal("V1"));

        System.out.println("---------------GRAFOS NO DIRIGIDOS---------------");
        System.out.println("Conexo:");
        GraphAL<String, String> grafoND_1 = new GraphAL<>(false, cmpVertices, cmpEdges);
        grafoND_1.addVertex("A");
        grafoND_1.addVertex("B");
        grafoND_1.addVertex("C");
        grafoND_1.addVertex("D");
        grafoND_1.addVertex("E");

        grafoND_1.connect("A", "B");
        grafoND_1.connect("A", "D");
        grafoND_1.connect("C", "D");
        grafoND_1.connect("C", "E");

        System.out.println(grafoND_1.breadthTraversal("E"));
        grafoND_1.refreshVisited();

        System.out.println(grafoND_1.depthTraversal("E"));
        grafoND_1.refreshVisited();

        LinkedList<List<String>> componentes = new LinkedList<>();
        grafoND_1.getConnectedComponents(componentes);
        System.out.println(componentes);

        System.out.println("No conexo:");
        GraphAL<String, String> grafoND_2 = new GraphAL<>(false, cmpVertices, cmpEdges);
        grafoND_2.addVertex("A");
        grafoND_2.addVertex("B");
        grafoND_2.addVertex("C");
        grafoND_2.addVertex("D");
        grafoND_2.addVertex("E");

        grafoND_2.connect("A", "B");
        grafoND_2.connect("C", "D");
        grafoND_2.connect("C", "E");

        System.out.println(grafoND_2.breadthTraversal("E"));
        grafoND_2.refreshVisited();

        System.out.println(grafoND_2.breadthTraversal("A"));
        grafoND_2.refreshVisited();

        System.out.println(grafoND_2.depthTraversal("E"));
        grafoND_2.refreshVisited();

        System.out.println(grafoND_2.depthTraversal("A"));
        grafoND_2.refreshVisited();

        LinkedList<List<String>> componentes2 = new LinkedList<>();
        grafoND_2.getConnectedComponents(componentes2);
        System.out.println(componentes2);

        Comparator<Integer> cmpVertices_2 = (s1, s2) -> {
            return s1.compareTo(s2);
        };

        Comparator<Integer> cmpEdges_2 = (s1, s2) -> {
            return s1.compareTo(s2);
        };
        System.out.println("\n---------------GRAFOS DIRIGIDOS---------------");
        System.out.println("Fuertemente conexo:");
        GraphAL<Integer, Integer> grafoD_1 = new GraphAL<>(true, cmpVertices_2, cmpEdges_2);
        grafoD_1.addVertex(4);
        grafoD_1.addVertex(5);
        grafoD_1.addVertex(6);
        grafoD_1.addVertex(8);

        grafoD_1.connect(4, 5);
        grafoD_1.connect(5, 4);
        grafoD_1.connect(5, 6);
        grafoD_1.connect(6, 5);
        grafoD_1.connect(6, 8);
        grafoD_1.connect(8, 6);
        grafoD_1.connect(4, 8);
        grafoD_1.connect(8, 4);

        System.out.println(grafoD_1.breadthTraversal(4));
        grafoD_1.refreshVisited();

        System.out.println(grafoD_1.depthTraversal(4));
        grafoD_1.refreshVisited();

        LinkedList<List<Integer>> componentes3 = new LinkedList<>();
        grafoD_1.getStrongConnectedComponents(componentes3);
        System.out.println(componentes3);

        System.out.println("Componentes fuertemente conexas:");
        GraphAL<String, String> grafoD_2 = new GraphAL<>(true, cmpVertices, cmpEdges);

        grafoD_2.addVertex("C");
        grafoD_2.addVertex("B");
        grafoD_2.addVertex("H");
        grafoD_2.addVertex("F");
        grafoD_2.addVertex("S");

        grafoD_2.connect("C", "B");
        grafoD_2.connect("B", "S");
        grafoD_2.connect("H", "B");
        grafoD_2.connect("H", "F");
        grafoD_2.connect("F", "C");
        grafoD_2.connect("F", "S");
        grafoD_2.connect("S", "C");

        System.out.println(grafoD_2.breadthTraversal("B"));
        grafoD_2.refreshVisited();

        System.out.println(grafoD_2.depthTraversal("B"));
        grafoD_2.refreshVisited();

        LinkedList<List<String>> componentes4 = new LinkedList<>();
        grafoD_2.getStrongConnectedComponents(componentes4);
        System.out.println(componentes4);

        GraphAL<String, String> g = new GraphAL<>(true, cmpVertices, cmpEdges);
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");
        g.addVertex("F");

        g.connect("A", "B", 3);
        g.connect("A", "C", 4);
        g.connect("A", "E", 8);
        g.connect("B", "E", 5);
        g.connect("C", "E", 3);
        g.connect("E", "F", 3);
        g.connect("E", "D", 7);
        g.connect("F", "D", 2);

        System.out.println(g.dijkstra("A"));
        printMatrix(g.floyd_Warshall());
        
        System.out.println("");
        GraphAL<Integer, Integer> g1 = new GraphAL<>(true, cmpVertices_2, cmpEdges_2);
        g1.addVertex(1);
        g1.addVertex(2);
        g1.addVertex(3);
        g1.addVertex(4);
        
        g1.connect(1, 2, 3);
        g1.connect(2, 1, 8);
        g1.connect(3, 1, 5);
        g1.connect(4, 1, 2);
        g1.connect(1, 4, 7);
        g1.connect(3, 4, 1);
        g1.connect(2, 3, 2);
        
        printMatrix(g1.floyd_Warshall());
        printMatrix(g1.warshall());
        
        System.out.println("");
        GraphAL<Integer, Integer> g2 = new GraphAL<>(true, cmpVertices_2, cmpEdges_2);
        g2.addVertex(1);
        g2.addVertex(2);
        g2.addVertex(3);
        g2.addVertex(4);
        
        g2.connect(2, 1, 8);
        g2.connect(2, 3, 2);
        g2.connect(2, 4, 5);
        g2.connect(1, 4, 7);
        g2.connect(3, 4, 1);
        g2.connect(3, 1, 1);
        g2.connect(4, 3, 1);
        printMatrix(g2.warshall());
        
        
        
        
        GraphAM<String, String> gM_1 = new GraphAM<>(true, cmpVertices, cmpEdges);
        gM_1.addVertex("A");
        gM_1.addVertex("B");
        gM_1.addVertex("C");
        gM_1.addVertex("D");
        gM_1.addVertex("E");
        gM_1.addVertex("F");

        gM_1.connect("A", "B", 3);
        gM_1.connect("A", "C", 4);
        gM_1.connect("A", "E", 8);
        gM_1.connect("B", "E", 5);
        gM_1.connect("C", "E", 3);
        gM_1.connect("E", "F", 3);
        gM_1.connect("E", "D", 7);
        gM_1.connect("F", "D", 2);

        System.out.println(gM_1.dijkstra("A"));
        
        
        System.out.println("\n\n");
        
        GraphAM<Integer, Integer> gM_2 = new GraphAM<>(true, cmpVertices_2, cmpEdges_2);
        gM_2.addVertex(1);
        gM_2.addVertex(2);
        gM_2.addVertex(3);
        gM_2.addVertex(4);
        
        gM_2.connect(1, 2, 3);
        gM_2.connect(2, 1, 8);
        gM_2.connect(3, 1, 5);
        gM_2.connect(4, 1, 2);
        gM_2.connect(1, 4, 7);
        gM_2.connect(3, 4, 1);
        gM_2.connect(2, 3, 2);
        
        printMatrix(gM_2.floyd_Warshall());
        
        System.out.println("\n\n");
        GraphAM<Integer, Integer> gM_3 = new GraphAM<>(true, cmpVertices_2, cmpEdges_2);
        gM_3.addVertex(1);
        gM_3.addVertex(2);
        gM_3.addVertex(3);
        gM_3.addVertex(4);
        
        gM_3.connect(2, 1, 8);
        gM_3.connect(2, 3, 2);
        gM_3.connect(2, 4, 5);
        gM_3.connect(1, 4, 7);
        gM_3.connect(3, 4, 1);
        gM_3.connect(3, 1, 1);
        gM_3.connect(4, 3, 1);
        printMatrix(gM_3.warshall());
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] matrix1 : matrix) {
            for (int j = 0; j < matrix1.length; j++) {
                System.out.print(matrix1[j] + " ");
            }
            System.out.println(); // Salto de línea después de cada fila
        }
    }
}
