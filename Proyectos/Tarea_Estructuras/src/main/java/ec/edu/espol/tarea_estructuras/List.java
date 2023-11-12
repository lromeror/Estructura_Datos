/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tarea_estructuras;

import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author Jonanyu 11.1
 */
public interface List<E> extends Iterable<E> {

    public int size();

    public boolean isEmpty();

    public void clear();

    public boolean addFirst(E element);

    public boolean addLast(E element);

    public E removeLast();

    public boolean remove(E element);

    public E set(int index, E element);

    public E get(int index);

    public E getFirst();

    public E getLast();
    public boolean removeFirst();

    public boolean addAll(List<E> l);

    public int indexOf(E element);

    public boolean insert(int index, E element);

    public boolean contains(E element);

    public boolean add(int index, E element);

    public E remove(int index);

    public void removeDuplicates(Comparator<E> comparator);

    public int binarySearch(E element, Comparator<E> comparator);

    public boolean removeElement(E element, Comparator<E> comparator);

    public int getIndexOf(E element, Comparator<E> comparator);

    public List<Integer> getAllIndicesOf(E element, Comparator<E> comparator);

    public void sort(Comparator<E> comparator);

    public boolean insertSorted(E element, Comparator<E> comparator);

    public List<E> mergeSorted(List<E> otherList, Comparator<E> comparator);

    public List<E> findUnion(List<E> otherList, Comparator<E> comparator);

    public boolean containsAll(List<E> elements, Comparator<E> comparator);
}
