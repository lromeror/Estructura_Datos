package tda;

import java.util.Comparator;
import java.util.Iterator;

public interface List<E> extends Iterable<E> {
//Para que pueda usar los iteradores tiene que implementar la interface Iterable
    //Esto hara aprecer el uso de una FOr-each
    //TOda las clases que implementan deben proveer el metodo Iterator

    boolean addFirst(E element);

    boolean addLast(E element);

    boolean removeFirst();

    boolean removeLast();

    E getFirst();

    E getLast();

    boolean insert(int index, E element);

    boolean contains(E element);

    E get(int index);

    int indexOf(E element);

    boolean isEmpty();

    E remove(int index);

    boolean remove(E element);

    E set(int index, E element);

    int size();

    public boolean addAll(List<E> l);

    public List<E> findIntersection(List<E> anotherList, Comparator<E> cmp);


}
