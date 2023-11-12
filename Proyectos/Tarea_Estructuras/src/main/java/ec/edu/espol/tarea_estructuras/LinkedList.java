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
public class LinkedList<E> implements List<E> {

    private Node<E> first, last;

    public LinkedList() {
        first = last = null;
    }

    public List<E> findIntersection(List<E> anotherList, Comparator<E> cmp) {
        List<E> results = new LinkedList<>();
        for (E e1 : this) {
            for (E e2 : anotherList) {
                if (cmp.compare(e1, e2) == 0) { // e1 es igual a e2
                    results.addLast(e2);
                }
            }
        }
        return results;
    }

    public List<E> findIntersection2(List<E> anotherList, Comparator<E> cmp) {
        List<E> results = new LinkedList<>();
        Iterator<E> it1 = results.iterator();
        while (it1.hasNext()) {
            E e1 = it1.next();
            Iterator<E> it2 = results.iterator();
            while (it2.hasNext()) {
                E e2 = it2.next();
                if (cmp.compare(e1, e2) == 0) { // e1 es igual a e2
                    results.addLast(e2);
                }
            }
        }
        return results;
    }

    public boolean contains(E element, Comparator<E> cmp) {
        for (E e1 : this) {
            if (cmp.compare(e1, element) == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addFirst(E element) {
        Node<E> nodo = new Node<>(element);
        if (element == null) {
            return false;
        } else if (isEmpty()) {
            first = last = nodo;
        } else {
            nodo.setNext(first);
            first = nodo;
        }
        return true;
    }

    @Override
    public boolean addLast(E element) {
        Node<E> nodo = new Node<>(element);
        if (element == null) {
            return false;
        } else if (isEmpty()) {
            first = last = nodo;
        } else {
            last.setNext(nodo);
            last = nodo;
        }
        return true;
    }

    @Override
    public E getFirst() {
        return first.getContent();
    }

    @Override
    public E getLast() {
        return last.getContent();
    }

    @Override
    public boolean removeFirst() {
        if (isEmpty()) {
            return false;
        } else if (first == last) {
            first = last = null;
        } else {
            Node<E> tmp = first;
            first = first.getNext();
            tmp.setNext(null);
        }
        return true;
    }

    private Node<E> getPrevious(Node<E> nodo) {
        if (nodo == first) {
            return null;
        }
        for (Node<E> i = first; i != null; i = i.getNext()) {
            if (i.getNext() == nodo) {
                return i;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return (first == null && last == null);
    }

    @Override
    public boolean contains(E element) {
        if (element == null || isEmpty()) {
            return false;
        }
        for (Node<E> i = first; i != null; i = i.getNext()) {
            if (i.getContent().equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean insert(int index, E element) {
        if (element == null || index < 0 || index > this.size()) {
            return false;
        } else if (index == 0) {
            addFirst(element);
            return true;
        } else if (index == this.size() - 1) {
            addLast(element);
            return true;
        }

        int i = 0;
        Node<E> nodo = new Node<>(element);
        for (Node<E> j = first; j != null; j = j.getNext()) {
            if (index - 1 == i) {
                nodo.setNext(j.getNext());
                j.setNext(nodo);
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= this.size()) {
            return null;
        }
        int j = 0;
        for (Node<E> i = first; i != null; i = i.getNext()) {
            if (j == index) {
                return i.getContent();
            }
            j++;
        }
        return null;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            return -1;
        }

        int j = 0;
        for (Node<E> i = first; i != null; i = i.getNext()) {
            if (i.getContent().equals(element)) {
                return j;
            }
            j++;
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= this.size()) {
            return null;
        } else if (index == 0) {
            E tmp = getFirst();
            removeFirst();
            return tmp;
        } else if (index == this.size() - 1) {
            E tmp = getLast();
            removeLast();
            return tmp;
        }

        Node<E> j = first;
        for (int i = 0; i < index; i++) {
            j = j.getNext();
        }

        Node<E> previus = getPrevious(j);
        previus.setNext(j.getNext());
        j.setNext(null);
        return j.getContent();

    }

    @Override
    public boolean remove(E element) {
        if (element == null) {
            return false;
        } else if (first.getContent().equals(element)) {
            removeFirst();
            return true;
        } else if (last.getContent().equals(element)) {
            removeLast();
            return true;
        }

        for (Node<E> i = first; i != null; i = i.getNext()) {
            if (i.getContent().equals(element)) {
                Node<E> previo = getPrevious(i);
                previo.setNext(i.getNext());
                i.setNext(null);
                return true;
            }
        }
        return false;
    }

    @Override
    public E set(int index, E element) {
        if (element == null || index < 0 || index >= this.size()) {
            return null;
        }

        int j = 0;
        for (Node<E> i = first; i != null; i = i.getNext()) {
            if (j == index) {
                E tmp = i.getContent();
                i.setContent(element);
                return tmp;
            }
        }
        return null;
    }

    @Override
    public int size() {
        int cont = 0;
        Node n;
        for (n = this.first; n != null; n = n.getNext()) {
            cont++;
        }
        return cont;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        if (isEmpty()) {
            return "[]";
        }
        s.append("[");

        for (Node<E> p = this.first; p != null; p = p.getNext()) {
            if (p != this.last) {
                s.append(p.getContent() + ",");
            } else {
                s.append(p.getContent() + "]");
            }
        }
        return s.toString();
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {
            private Node<E> cursor = first;

            @Override
            public boolean hasNext() {
                return cursor != null;
            }

            @Override
            public E next() {
                E tmp = cursor.getContent();
                cursor = cursor.getNext();
                return tmp;
            }
        };

        return it;
    }

    @Override
    public boolean addAll(List<E> l) {
        if (l == null) {
            return false;
        }
        for (int i = 0; i < l.size(); i++) {
            this.addLast(l.get(i));
        }
        return true;
    }

    @Override
    public void removeDuplicates(Comparator<E> comparator) {
        LinkedList<E> sinrepetir = new LinkedList<>();
        for (int i = 0; i < this.size(); i++) {
            if (!sinrepetir.contains(this.get(i))) {
                sinrepetir.addLast(this.get(i));
            }
        }
        this.clear();
        this.addAll(sinrepetir);
    }

    @Override
    public int binarySearch(E element, Comparator<E> cmp) {
        if (element == null || cmp == null) {
            throw new IllegalArgumentException("El elemento y comparador no pueden ser nulos");
        }
        int extremoI = 0;
        int extremoD = this.size() - 1;
        while (extremoI <= extremoD) {
            int mitad = extremoI + (extremoD - extremoI) / 2;
            E e = this.get(mitad);
            if (cmp.compare(e, element) == 0) {
                return mitad;
            } else if (cmp.compare(e, element) < 0) {
                extremoI = mitad + 1;
            } else if (cmp.compare(e, element) > 0) {
                extremoD = mitad - 1;
            }
        }
        return -(extremoI + 1);
    }

    @Override
    public boolean removeElement(E element, Comparator<E> comparator) {
        if (element == null) {
            return false;
        }
        ArrayList<Integer> all_indices = getAllIndicesOf(element, comparator);
        for (int i = all_indices.size() - 1; i >= 0; i--) {
            int indice = all_indices.get(i);
            this.remove(i);
        }
        return true;
    }

    @Override
    public int getIndexOf(E element, Comparator<E> comparator) {
        if (element == null) {
            return -1;
        }
        for (int i = 0; i < this.size(); i++) {
            if (comparator.compare(element, this.get(i)) == 0) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ArrayList<Integer> getAllIndicesOf(E element, Comparator<E> comparator) {
        ArrayList<Integer> all_indices = new ArrayList<>();
        if (element == null) {
            return all_indices;
        }
        for (int i = 0; i < this.size(); i++) {
            if (comparator.compare(element, this.get(i)) == 0) {
                all_indices.addLast(i);
            }
        }
        return all_indices;

    }

    public void replace_one(int pos_reemplazar, E element) {
        this.remove(pos_reemplazar);
        this.insert(pos_reemplazar, element);

    }

    @Override
    public void sort(Comparator<E> comparator) {
        for (int i = 0; i < this.size(); i++) {
            E actual = this.get(i);
            if (i != 0) {
                int y = i - 1;
                while (y >= 0 && comparator.compare(actual, this.get(y)) < 0) {
                    this.replace_one(y + 1, this.get(y));
                    y--;
                }
                this.replace_one(y + 1, actual);
            }
        }
    }

    @Override
    public boolean insertSorted(E element, Comparator<E> comparator) {
        for (int i = 0; i < this.size(); i++) {
            if (comparator.compare(element, this.get(i)) == 0) {
                this.insert(i, element);
                return true;
            }
        }
        return false;
    }

    @Override
    public LinkedList<E> mergeSorted(List<E> otherList, Comparator<E> comparator) {
        LinkedList<E> nueva = new LinkedList<>();
        for (E ele : this) {
            nueva.addLast(ele);
        }
        for (E ele : otherList) {
            nueva.addLast(ele);
        }
        nueva.sort(comparator);
        return nueva;
    }

    @Override
    public LinkedList<E> findUnion(List<E> otherList, Comparator<E> comparator) {
        LinkedList<E> nueva = new LinkedList<>();
        for (E ele : this) {
            nueva.addLast(ele);
        }
        for (E ele : otherList) {
            nueva.addLast(ele);
        }
        nueva.removeDuplicates(comparator);
        return nueva;
    }

    @Override
    public boolean containsAll(List<E> elements, Comparator<E> comparator) {
        int total = 0;
        for (E elem : elements) {
            for (E o_elem : this) {
                if (comparator.compare(elem, o_elem) == 0) {
                    total++;
                    break;
                }
            }
        }
        return total == elements.size();
    }

    private LinkedList<E> slicing(int start, int end) {
        LinkedList<E> nueva = new LinkedList<>();
        for (int i = start; i < end; i++) {
            nueva.addLast(this.get(i));
        }
        return nueva;
    }

    @Override
    public void clear() {
        first = last = null;
    }

    @Override
    public boolean add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        } else if (first == last) {
            E removedElement = first.getContent();
            first = last = null;
            return removedElement;
        } else {
            Node<E> current = first;
            while (current.getNext() != last) {
                current = current.getNext();
            }

            E removedElement = last.getContent();
            last = current;
            last.setNext(null);
            return removedElement;
        }
    }
}
