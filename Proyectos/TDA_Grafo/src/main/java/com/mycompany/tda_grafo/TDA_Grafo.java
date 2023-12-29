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
        Comparator<String> cmp=(String o1, String o2) -> o1.compareTo(o2);
        
        //Grafo no dirigido
        GrafoAM<String> grafo=new GrafoAM<>(false,cmp);
        grafo.addVertex("A");
        grafo.addVertex("B");
        grafo.addVertex("C");
        
        grafo.toConnect("A", "B");
        grafo.toConnect("A", "C");
        grafo.toConnect("A", "B");
        grafo.toConnect("A", "C");
        
        grafo.showMatrix();
        System.out.println();
        
        //Grafo dirigido
        GrafoAM<String> grafoDi=new GrafoAM<>(true,cmp);
        grafoDi.addVertex("A");
        grafoDi.addVertex("B");
        grafoDi.addVertex("C");

        grafoDi.toConnect("A", "B");
        grafoDi.toConnect("A", "C");
        grafoDi.toConnect("C", "A");

        grafoDi.showMatrix();
    }
}
