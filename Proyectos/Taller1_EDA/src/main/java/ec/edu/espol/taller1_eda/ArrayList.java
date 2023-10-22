package ec.edu.espol.taller1_eda;

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
    public E removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        E element = null;
        E[] elementos = (E[]) new Object[MAX_SIZE];
        for (int i = 0; i <= this.effectiveSize - 1; i++) {
            if (index != i) {
                elementos[i] = this.elements[i];
            } else {
                element = this.elements[index];
            }
        }
        this.effectiveSize--;
        this.elements = elementos;
        return element;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= effectiveSize) {
            return null;
        }
        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public void reverse() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<E> subList(int from, int to) {

        ArrayList<E> array = new ArrayList();
        for (int i = 0; i <= this.effectiveSize - 1; i++) {
            if (i >= from && i <= to && to <= this.effectiveSize - 1) {
                array.addLast(get(i));
            }
        }
        return array;
    }

    @Override
    public List<E> removeFirstNElements(int n) {
        ArrayList<E> array = new ArrayList();
        for (int i = 0; i <= this.effectiveSize - 1; i++) {
            if (i >= n) {
                array.addLast(get(i));
            }
        }
        return array;
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

    public void rotate(int k) {
        List<E> array = this.subList(0, (this.effectiveSize - k) - 1);
        List<E> array2 = this.subList((this.effectiveSize - k), this.effectiveSize - 1);
        for (int i = array2.size() - 1; i >= 0; i--) {
            array.addFirst(array2.get(i));
        }
        for (int i = 0; i < array.size(); i++) {
            this.elements[i] = array.get(i);
        }
    }

}
