/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tda_grafo;

import java.util.LinkedList;

/**
 *
 * @author Luis Romero
 * @param <V>
 * @param <E>
 */
public class Vertex<V,E> {
    private V content;
    private boolean visited;
    private LinkedList<Edge<E,V>> listEdge;

    public Vertex(V content) {
        this.content = content;
        this.listEdge = new LinkedList<>();
        this.visited=false;
    }

    public V getContent() {
        return content;
    }

    public void setContent(V content) {
        this.content = content;
    }

    public LinkedList<Edge<E, V>> getListEdge() {
        return listEdge;
    }

    public void setListEdge(LinkedList<Edge<E, V>> listEdge) {
        this.listEdge = listEdge;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    
    public String toString(){
        return this.content.toString();
    }
    
}
