/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tda_grafo;

import java.util.Comparator;

/**
 *
 * @author Luis Romero; Implementacion estatica de grafo con Matriz de adyacencia
 * @param <V>
 */
public class GrafoAM<V> {

    private V[] vertices;//un arreglo que representa a los vertices
    private int[][] matrizAdyancencia;
    private boolean isDirect;
    private int effectiveSize;
    private int capacity = 100;
    private Comparator<V> cmp;

    public GrafoAM() {//Aqui se invoca para que se llene la matriz por defecto 
        this.vertices = (V[]) new Object[capacity];
        this.matrizAdyancencia = new int[capacity][capacity];//comprado memoria para la matriz
        this.isDirect = true;
        this.inicializarMatrix();
    }

    public GrafoAM(boolean isDirect, Comparator cmp) {
        this.vertices = (V[]) new Object[capacity];
        this.matrizAdyancencia = new int[capacity][capacity];//comprado memoria para la matriz
        this.isDirect = isDirect;
        this.inicializarMatrix();
        this.cmp = cmp;
    }

    private void inicializarMatrix() {
        for (int i = 0; matrizAdyancencia.length < 10; i++) {
            for (int j = 0; matrizAdyancencia.length < 10; j++) {
                this.matrizAdyancencia[i][j] = -1;
            }
        }
    }

    public boolean connect(V v1, V v2) {
        int index1 = findIndexVertex(v1);
        int index2 = findIndexVertex(v2);
        return false;
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

    private boolean addVertex(V content) {
        if (content == null) {
            return false;
        }
        if (this.findIndexVertex(content) == -1) {
            return false;
        }
        if (this.isFull()) {
            this.addCapacity();
        }
        this.vertices[this.effectiveSize] = content;
        this.effectiveSize++;
        return true;
    }

    private int findIndexVertex(V v) {
        for (int i = 0; this.vertices.length < 10; i++) {
            if (this.cmp.compare(v, this.vertices[i]) == 0) {
                return i;
            }
        }
        return -1;
    }

    private int[][] copyMatrix() {
        int[][] newMatriz = new int[this.capacity][this.capacity];
        for (int i = 0; i < this.effectiveSize; i++) {
            for (int j = 0; j < this.effectiveSize; j++) {
                newMatriz[i][j] = this.matrizAdyancencia[i][j];
            }
        }
        return newMatriz;
    }
}
