package tdas;

public class ArrayList<E> implements List<E> {
    
    private E[] elements;
    private int CAPACITY = 100;
    private int effectiveSize;
    
    public ArrayList () {
        elements = (E[]) new Object[CAPACITY];
        effectiveSize = 0;
    }

    @Override
    public int size() {
        return effectiveSize;
    }

    @Override
    public boolean isEmpty() {
        return effectiveSize == 0;
    }

    @Override
    public void clear() {
        // faltan otras cosas, pero eventualmente esto:
        effectiveSize = 0;
    }

    @Override
    public boolean addFirst(E element) {
        if (element == null) {
            return false;
        } else if (this.isEmpty()) {
            elements[0] = element;
            effectiveSize++;
            return true;
        } else if (this.isFull()) { // si el array list está lleno
            addCapacity();
        }
        // moveiendo los elementos 
        for (int i = effectiveSize - 1; i >= 0; i--) {
            elements[i+1] = elements[i];
        }
        elements[0] = element;
        effectiveSize++;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addAll(List<E> l) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ArrayList (E[] elements) {
        
    }

    private boolean isFull() {
        return effectiveSize == CAPACITY;
    }

    private void addCapacity() {
        CAPACITY *= 2;
        E[] newElements = (E[]) new Object[CAPACITY];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

}
