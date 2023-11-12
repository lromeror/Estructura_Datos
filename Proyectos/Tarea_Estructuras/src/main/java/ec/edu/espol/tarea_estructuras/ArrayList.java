/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tarea_estructuras;

import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author Luis Romero
 * @param <E>
 */
public class ArrayList<E> implements List<E> {

    private E[] elements;
    private int MAX_SIZE = 100;
    private int effectiveSize;

    public ArrayList() {
        // elements = new E[100]; // NO vale
        elements = (E[]) new Object[MAX_SIZE];
        effectiveSize = 0;
    }

    @Override
    public int size() {
        return effectiveSize;
    }

    @Override
    public boolean isEmpty() {
        return this.effectiveSize == this.MAX_SIZE;
    }

    @Override
    public void clear() {

    }

    @Override
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

    @Override
    public boolean addLast(E element) {
        if (element == null) {
            return false;
        }
        if (isFull()) {
            addCapacity();
        }
        elements[effectiveSize++] = element;
        return true;
    }

    @Override
    public E removeLast() {
        E[] elementos = (E[]) new Object[MAX_SIZE];
        for (int i = 0; i < this.effectiveSize - 1; i++) {
            elementos[i] = this.elements[i];
        }
        this.effectiveSize--;
        E elem = this.elements[this.effectiveSize - 1];
        this.elements = elementos;
        return elem;
    }

    @Override
    public boolean add(int index, E element) {
        if (index < 0 || index > effectiveSize) {

            return false;
        }
        if (isFull()) {
            addCapacity();
        }
        for (int i = effectiveSize; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        effectiveSize++;
        return true;
    }

    @Override
    public E remove(int index) {
        int cont = 0;
        E[] elementsNuevo = (E[]) new Object[this.MAX_SIZE];
        for (int i = 0; i <= this.effectiveSize - 1; i++) {
            if (i != index) {
                elementsNuevo[cont++] = this.elements[i];
            }
        }
        E elementoRemovido = this.elements[index];
        this.effectiveSize--;
        this.elements = elementsNuevo;
        return elementoRemovido;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= effectiveSize) {
            return null;
        }
        return elements[index];
    }

    private void addCapacity() {
        MAX_SIZE = MAX_SIZE * 2;
        E[] newElements = (E[]) new Object[MAX_SIZE];
        for (int i = 0; i < effectiveSize; i++) {
            newElements[i] = elements[i];
        }
        this.elements = newElements;
    }

    private boolean isFull() {
        return effectiveSize == MAX_SIZE;
    }

    @Override
    public void removeDuplicates(Comparator<E> comparator) {
        for (int i = 0; i < this.effectiveSize - 1; i++) {
            for (int j = i + 1; j < this.effectiveSize; j++) {
                if (comparator.compare(elements[i], elements[j]) == 0) {
                    this.remove(j);
                    j--;
                }
            }
        }
    }

    @Override
    public boolean removeElement(E element, Comparator<E> comparator) {
        if (element == null) {
            return false;
        }
        for (int i = 0; i < this.effectiveSize - 1; i++) {
            if (comparator.compare(elements[i], element) == 0) {
                this.remove(i);
            }
        }
        return true;
    }

    @Override
    public int binarySearch(E element, Comparator<E> comparator) {
        if (element == null) {
            return -1;
        }
        int extremoI = 0;
        int extremoD = this.size() - 1;
        while (extremoI <= extremoD) {
            int mitad = extremoI + (extremoD - extremoI) / 2;
            E e = this.get(mitad);
            if (comparator.compare(e, element) == 0) {
                return mitad;
            } else if (comparator.compare(e, element) < 0) {
                extremoI = mitad + 1;
            } else if (comparator.compare(e, element) > 0) {
                extremoD = mitad - 1;
            }
        }
        return -(extremoI + 1);
    }

    @Override
    public int getIndexOf(E element, Comparator<E> comparator) {
        if (element == null) {
            return -1;
        }
        for (int i = 0; i <= this.effectiveSize - 1; i++) {
            if (comparator.compare(this.elements[i], element) == 0) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<Integer> getAllIndicesOf(E element, Comparator<E> comparator) {
        List<Integer> indices = new ArrayList<>();
        if (element == null) {
            return indices;
        }

        for (int i = 0; i <= this.effectiveSize - 1; i++) {
            if (comparator.compare(this.elements[i], element) == 0) {
                indices.addLast(i);
            }
        }
        return indices;
    }

    @Override
    public void sort(Comparator<E> comparator) {
        if (comparator == null) {
            throw new IllegalArgumentException("El comparador es nulo");
        }

        boolean cambio;
        do {
            cambio = false;
            for (int i = 0; i < effectiveSize - 1; i++) {
                if (comparator.compare(elements[i], elements[i + 1]) > 0) {
                    E elemento = elements[i];
                    elements[i] = elements[i + 1];
                    elements[i + 1] = elemento;
                    cambio = true;
                }
            }
        } while (cambio);
    }

    @Override
    public boolean insertSorted(E element, Comparator<E> comparator) {
        if (element == null || comparator == null) {
            return false;
        }
        for (int i = 0; i <= this.effectiveSize - 1; i++) {
            if (comparator.compare(this.elements[i], element) < 0) {
                this.add(i + 1, element);
            }
        }
        return false;
    }

    @Override
    public List<E> mergeSorted(List<E> otherList, Comparator<E> comparator) {
        List<E> mergeList = new ArrayList<>();
        for (E element : this.elements) {
            mergeList.addLast(element);
        }

        for (E element : otherList) {
            mergeList.addLast(element);
        }
        mergeList.removeDuplicates(comparator);
        mergeList.sort(comparator);

        return mergeList;
    }

    @Override
    public List<E> findUnion(List<E> otherList, Comparator<E> comparator) {
        List<E> listaUnida = new ArrayList<>();
        if (otherList == null || comparator == null) {
            return listaUnida;
        }
        for (E element : this.elements) {
            listaUnida.addLast(element);
        }

        for (E element : otherList) {
            listaUnida.addLast(element);
        }

        listaUnida.removeDuplicates(comparator);
        return listaUnida;
    }

    @Override
    public boolean containsAll(List<E> elements, Comparator<E> comparator) {
        if (elements == null) {
            return false;
        }
        for (E element : elements) {
            boolean estado = false;
            int i = 0;
            while (i <= this.effectiveSize - 1 && estado != true) {
                if (comparator.compare(element, this.elements[i]) == 0) {
                    estado = true;
                }
                i++;
            }
            if (estado == false) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return this.cursor < effectiveSize;
            }

            @Override
            public E next() {
                E element = elements[this.cursor];
                this.cursor++;
                return element;
            }
        };
        return it;
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

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int indexOf(E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean remove(E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E getFirst() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E getLast() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addAll(List<E> l) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean contains(E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
