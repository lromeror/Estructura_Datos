/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tda_grafo;

import java.util.Comparator;

/**
 *
 * @author Luis Romero Implementacion estatica de grafo con Matriz de adyacencia
 * @param <V>
 * @param <E>
 */
public class GrafoAM<V, E> {

    private V[] vertices;// un arreglo que representa a los vertices
    private int[][] matrizAdyancencia;
    private boolean isDirect;
    private E[][] metadataMatrix;// Esto es para que en los arcos no solo haiga los pesos sino informacion de tipo E
    private int effectiveSize;
    private int capacity = 100;
    private Comparator<V> cmp;

    public GrafoAM() {// Aqui se invoca para que se llene la matriz por defecto
        this.vertices = (V[]) new Object[capacity];
        this.matrizAdyancencia = new int[capacity][capacity];// comprado memoria para la matriz
        this.isDirect = true;
        this.metadataMatrix = (E[][]) new Object[capacity][capacity];
        this.inicializarMatrix(matrizAdyancencia, metadataMatrix);
    }

    public GrafoAM(boolean isDirect, Comparator cmp) {
        this.vertices = (V[]) new Object[capacity];
        this.matrizAdyancencia = new int[capacity][capacity];// comprado memoria para la matriz
        this.isDirect = isDirect;
        this.metadataMatrix = (E[][]) new Object[capacity][capacity];
        inicializarMatrix(matrizAdyancencia, metadataMatrix);
        this.cmp = cmp;
    }

    private void inicializarMatrix(int[][] matrix, E[][] matrix2) {
        for (int i = 0; i < capacity; i++) {
            for (int j = 0; j < capacity; j++) {
                matrix[i][j] = -1;
                matrix2[i][j] = null;
            }
        }
    }

    // Esta validado para un grafo que tenga lazo
    public boolean toConnect(V v1, V v2) {
        int index1 = findIndexVertex(v1);
        int index2 = findIndexVertex(v2);
        int actuMatr;
        if (index1 == -1 || index2 == -1) {
            return false;
        }
        if (this.isDirect == true) {// Aqui cuando es dirigido el orden no es conmutativo es decir el orden que
            // pones los vertices es importante, v1 a v2
            if (this.matrizAdyancencia[index1][index2] == -1) {
                this.matrizAdyancencia[index1][index2] += 2;
            } else {
                this.matrizAdyancencia[index1][index2]++;
            }
            return true;
        }
        if ((this.matrizAdyancencia[index1][index2] == -1 && this.matrizAdyancencia[index2][index1] == -1
                && index1 == index2)) {
            actuMatr = this.matrizAdyancencia[index1][index2] + 3;
        } else if ((this.matrizAdyancencia[index1][index2] == -1 && this.matrizAdyancencia[index2][index1] == -1)
                || (index1 == index2)) {
            actuMatr = this.matrizAdyancencia[index1][index2] + 2;
        } else {
            actuMatr = this.matrizAdyancencia[index1][index2] + 1;
        }
        this.matrizAdyancencia[index1][index2] = actuMatr;
        this.matrizAdyancencia[index2][index1] = actuMatr;
        return true;
    }

    private boolean isFull() {
        return this.effectiveSize == this.capacity;
    }

    private void addCapacity() {
        this.capacity = this.capacity * 2;
        V[] newVertex = (V[]) new Object[this.capacity];
        int[][] newMatriz = this.copyMatrix();
        for (int i = 0; i < effectiveSize; i++) {
            newVertex[i] = this.vertices[i];
        }
        this.matrizAdyancencia = newMatriz;
        this.vertices = newVertex;
    }

    public boolean addVertex(V content) {
        if (content == null) {
            return false;
        }
        if (!this.isEmpty()) {
            if (this.findIndexVertex(content) != -1) {
                return false;
            }
        }
        if (this.isFull()) {
            this.addCapacity();
        }
        this.vertices[this.effectiveSize] = content;
        this.effectiveSize++;
        return true;
    }

    private int findIndexVertex(V vertice) {
        for (int i = 0; i < this.effectiveSize; i++) {
            if (this.cmp.compare(vertice, this.vertices[i]) == 0) {
                return i;
            }
        }
        return -1;
    }

    private int[][] copyMatrix() {
        int[][] newMatriz = new int[this.capacity][this.capacity];
        E[][] matrixMe = (E[][]) new Object[capacity][capacity];
        for (int i = 0; i < this.effectiveSize; i++) {
            for (int j = 0; j < this.effectiveSize; j++) {
                newMatriz[i][j] = this.matrizAdyancencia[i][j];
                matrixMe[i][j] = this.metadataMatrix[i][j];
            }
        }
        return newMatriz;
    }

    public void showMatrixAd() {
        for (int i = 0; i < this.effectiveSize; i++) {
            for (int j = 0; j < this.effectiveSize; j++) {
                System.out.print(this.matrizAdyancencia[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean isEmpty() {
        return this.effectiveSize == 0;
    }

    public V removeVertex(V vertice) {
        int cont = 0;
        V[] newVert = (V[]) new Object[capacity];
        if (vertice == null || this.isEmpty()) {
            return null;
        }
        int posVer = this.findIndexVertex(vertice);
        if (posVer == -1) {
            return null;
        }
        V verticeRemove = this.vertices[posVer];
        for (int i = 0; i < this.effectiveSize; i++) {
            if (i != posVer) {
                newVert[cont++] = this.vertices[i];
            }
        }
        updateMatrix(posVer);
        this.vertices = newVert;
        this.effectiveSize--;
        return verticeRemove;
    }

    private void updateMatrix(int posEle) {
        int[][] newMatrix = new int[capacity][capacity];
        E[][] matrixMe = (E[][]) new Object[capacity][capacity];
        inicializarMatrix(newMatrix, matrixMe);
        int newFil = 0;
        for (int i = 0; i < this.effectiveSize; i++) {
            if (i != posEle) {
                int newCol = 0;
                for (int j = 0; j < this.effectiveSize; j++) {
                    if (j != posEle) {
                        newMatrix[newFil][newCol] = this.matrizAdyancencia[i][j];
                        matrixMe[newFil][newCol] = this.metadataMatrix[i][j];
                        newCol++;
                    }
                }
                newFil++;
            }
        }
        this.matrizAdyancencia = newMatrix;
    }

    public boolean toConnect(V v1, V v2, int peso) {
        int index1 = findIndexVertex(v1);
        int index2 = findIndexVertex(v2);
        if (index1 == -1 || index2 == -1) {
            return false;
        }
        if (this.isDirect) {// Aqui cuando es dirigido el orden no es conmutativo es decir el orden que
            // pones los vertices es importante, v1 a v2
            this.matrizAdyancencia[index1][index2] = peso;
            return true;
        }
        this.matrizAdyancencia[index1][index2] = peso;
        this.matrizAdyancencia[index2][index1] = peso;
        return true;
    }

    public boolean toConectMet(V source, V target, int w, E metadata) {
        if (source == null || target == null) {
            return false;
        }
        int i1 = findIndexVertex(source);
        int i2 = findIndexVertex(target);
        if (i1 == -1 || i2 == -1) {
            return false;
        }
        this.matrizAdyancencia[i1][i2] = w;
        this.metadataMatrix[i1][i2] = metadata;
        if (!this.isDirect) {
            this.matrizAdyancencia[i2][i1] = w;
            this.metadataMatrix[i2][i1] = metadata;
        }
        return true;
    }

    public void showMatrixMe() {
        for (int i = 0; i < this.effectiveSize; i++) {
            for (int j = 0; j < this.effectiveSize; j++) {
                System.out.print(this.metadataMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
