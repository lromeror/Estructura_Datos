/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tda_heap;

import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author Luis Romero
 * @param <E>
 */
public class Heap<E> {

    private E[] elements;
    private int MAX_SIZE = 100;
    private int effectiveSize;
    private final Comparator<E> cmp;

    public Heap(Comparator<E> cmp) {
        this.elements = (E[]) new Object[MAX_SIZE];
        this.effectiveSize = 0;
        this.cmp = cmp;
    }

    public int getLeft(int posRoot) {
        int posLeft = 2 * posRoot + 1;
        if (posRoot > effectiveSize - 1 || posRoot < 0 || posLeft > this.effectiveSize) {
            return -1;
        }
        return posLeft;
    }

    public int getRight(int posRoot) {
        int posRight = 2 * posRoot + 2;
        if (posRoot > effectiveSize - 1 || posRoot < 0 || posRight > this.effectiveSize) {
            return -1;
        }
        return posRight;
    }

    public int getParent(int posRoot) {
        if (posRoot == 0 || posRoot > effectiveSize - 1 || posRoot < 0) {
            return -1;
        }
        return (posRoot - 1) / 2;
    }

    public boolean isLeaf(int posRoot) {
        return this.getLeft(posRoot) < 0 && this.getRight(posRoot) < 0;
    }

    private boolean isFull() {
        return effectiveSize == MAX_SIZE;
    }

    private void addCapacity() {
        MAX_SIZE = MAX_SIZE * 2;
        E[] newElements = (E[]) new Object[MAX_SIZE];
        for (int i = 0; i < effectiveSize; i++) {
            newElements[i] = elements[i];
        }
        this.elements = newElements;
    }

    public boolean addFirst(E element) {
        if (element == null) {
            return false;
        }
        if (isFull()) {
            addCapacity();
        }
        for (int i = this.effectiveSize - 1; i >= 0; i--) {
            elements[i + 1] = elements[i];
        }

        this.elements[0] = element;
        this.effectiveSize++;
        return true;
    }

    public void ajustar(int posRoot) {
        if (posRoot >= 0 && posRoot < effectiveSize - 1 && !this.isLeaf(posRoot)) {
            E Left = this.elements[this.getLeft(posRoot)];
            E Right = this.elements[this.getRight(posRoot)];
            E Root = this.elements[posRoot];
            if (cmp.compare(Root, Left) < 0) {
                swap(this.getLeft(posRoot), Root, Left);
                this.ajustar(this.getLeft(posRoot));
            }
            if (cmp.compare(Root, Right) < 0) {
                swap(this.getRight(posRoot), Root, Right);
                this.ajustar(this.getRight(posRoot));
            }
        }
    }

    public void swap(int posRoot, E eleRoot, E mayorEle) {
        this.elements[posRoot] = eleRoot;
        this.elements[this.getParent(posRoot)] = mayorEle;
    }

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        cadena.append("[");
        for (int i = 0; i <= this.effectiveSize - 1; i++) {
            if (i == this.effectiveSize - 1) {
                cadena.append(this.elements[i]);
            } else {
                cadena.append(this.elements[i]);
                cadena.append(",");
            }
        }
        cadena.append("]");
        return cadena.toString();
    }
}
