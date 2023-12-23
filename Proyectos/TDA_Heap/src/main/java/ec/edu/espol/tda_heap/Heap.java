/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tda_heap;

import java.util.Comparator;

/**
 *
 * @author Jonanyu 11.1
 */
public class Heap<E> {//Es una arreglo con mascara de binario
    //Es un arbol con propiedad de orden por eso es necesario comparar

    private E[] elements;
    private int MAX_SIZE = 100;
    private int effectiveSize;
    private Comparator<E> cmp;//esto define si es ascendente o descendete

    public Heap() {
        this.elements = (E[]) new Object[MAX_SIZE];
        this.effectiveSize = 0;
    }

}
