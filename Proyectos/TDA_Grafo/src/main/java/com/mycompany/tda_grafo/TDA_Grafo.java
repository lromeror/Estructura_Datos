/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.tda_grafo;

import java.util.Comparator;

/**
 *
 * @author Luis Romero
 */
public class TDA_Grafo {

    public static void main(String[] args) {
        Comparator<String> cmp = (String o1, String o2) -> o1.compareTo(o2);

        //Grafo no dirigido
        GrafoAM<String> grafo = new GrafoAM<>(false, cmp);
        grafo.addVertex("A");
        grafo.addVertex("B");
        grafo.addVertex("C");

        //grafo.toConnect("A", "A",10);
        grafo.toConnect("A", "C");
        grafo.toConnect("A", "B");
        grafo.toConnect("B", "B");
        grafo.toConnect("C", "B");

        grafo.removeVertex("C");
        grafo.showMatrix();

        System.out.println();

        //Grafo dirigido
        GrafoAM<String> grafoDi = new GrafoAM<>(true, cmp);
        grafoDi.addVertex("A");
        grafoDi.addVertex("B");
        grafoDi.addVertex("C");

        //grafoDi.toConnect("A", "B",10);
        grafoDi.toConnect("A", "C");
        grafoDi.toConnect("A", "A");
        
        grafoDi.removeVertex("B");
        grafoDi.showMatrix();
    }
}
