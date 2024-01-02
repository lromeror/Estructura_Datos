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
//
//        //Grafo no dirigido
//        GrafoAM<String,String> grafo = new GrafoAM<>(false, cmp);
//        grafo.addVertex("A");
//        grafo.addVertex("B");
//        grafo.addVertex("C");
//
//        //grafo.toConnect("A", "A",10);
//        grafo.toConectMet("A", "C",10,"Pitusa");
//        grafo.toConectMet("A", "B",20,"Pitbull");
//        grafo.toConectMet("B", "B",30,"Pepe");
//        grafo.toConectMet("C", "B",100,"Toprack");
//
//        grafo.removeVertex("C");
//        grafo.showMatrixAd();
//        grafo.showMatrixMe();
//
//        System.out.println();
//
//        //Grafo dirigido
//        GrafoAM<String,Integer> grafoDi = new GrafoAM<>(true, cmp);
//        grafoDi.addVertex("A");
//        grafoDi.addVertex("B");
//        grafoDi.addVertex("C");
//
//        //grafoDi.toConnect("A", "B",10);
//        grafoDi.toConnect("A", "C");
//        grafoDi.toConnect("A", "A");
//        
//        grafoDi.removeVertex("B");
//        grafoDi.showMatrixAd();
        GrafoAL<String, Integer> grafo = new GrafoAL<>(false, cmp);
        grafo.addVertex("D");
        grafo.addVertex("B");
        grafo.addVertex("C");
        grafo.addVertex("R");
        grafo.addVertex("H");
        grafo.addVertex("T");
        grafo.addVertex("A");
        grafo.addVertex("J");
        grafo.addVertex("Z");
        
        grafo.toConect("D", "C", 1, 10);
        grafo.toConect("D", "B", 1, 10);
        grafo.toConect("C", "R", 1, 10);
        grafo.toConect("B", "H", 1, 10);
        grafo.toConect("R", "H", 1, 10);
        grafo.toConect("H", "D", 1, 10);
        grafo.toConect("H", "A", 1, 10);
        grafo.toConect("H", "T", 1, 10);
        grafo.toConect("J", "Z", 1, 10);

        System.out.println(grafo);
        // System.out.println(grafo.recoAnchura("T"));
        //System.out.println(grafo.recoProfun("D"));

        System.out.println(grafo.isConexo());
        System.out.println(grafo.compConexas());
    }
}
