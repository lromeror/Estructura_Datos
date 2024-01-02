/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tda_grafo;

/**
 *
 * @author Luis Romero
 * @param <E>
 * @param <V>
 */
public class Edge<E, V> {

    private int weight;
    private Vertex<V, E> start;
    private Vertex<V, E> end;
    private E data;

    public Edge(Vertex<V, E> start, Vertex<V, E> end, E data, int weight) {
        this.weight = weight;
        this.start = start;
        this.end = end;
        this.data = data;
    }

    public Edge(Vertex<V, E> start, Vertex<V, E> end, int weight) {
        this(start, end, null, weight);
    }

    public Edge(Vertex<V, E> start, Vertex<V, E> end, E data) {
        this(start, end, data, -1);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vertex<V, E> getStart() {
        return start;
    }

    public void setStart(Vertex<V, E> start) {
        this.start = start;
    }

    public Vertex<V, E> getEnd() {
        return end;
    }

    public void setEnd(Vertex<V, E> end) {
        this.end = end;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
