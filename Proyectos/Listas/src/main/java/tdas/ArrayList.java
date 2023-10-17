package tdas;

public class ArrayList<E> implements List<E> {

    private E[] elements;
    private int CAPACITY = 100;
    private int effectiveSize;

    public ArrayList() {
        this.elements = (E[]) new Object[CAPACITY]; // Haciendo downcasting
        this.effectiveSize = 0;// llenado de una arreglo
        this.CAPACITY = 0;// cantidad de un arreglo
    }

    @Override
    public int size() {
        return this.effectiveSize;
    }

    @Override
    public boolean isEmpty() {
        return this.effectiveSize == 0;
    }

    @Override
    public void clear() {
        E[] elements3 = (E[]) new Object[this.CAPACITY];
        this.elements = elements3;
    }

    @Override
    public boolean addFirst(E element) {
        if (isEmpty()) {
            this.elements[0] = element;
            this.effectiveSize++;
            return true;
        } else if (isFull()) {
            addCapacity();
            this.effectiveSize++;
            for (int i = this.effectiveSize - 1; i >= 0; i--) {
                elements[i + 1] = elements[i];
            }
            return true;
        } else if (element == null) {
            return false;
        }
        return false;
    }

    @Override
    public boolean addLast(E element) {
        if (element == null) {
            return false;
        } else if (isFull()) {
            addCapacity();
            this.elements[this.effectiveSize] = element;
            this.effectiveSize++;
            return true;
        } else if (isEmpty()) {
            this.elements[0] = element;
            this.effectiveSize++;
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(List<E> l) {
        if(l==null){
            return false;
        }
        while(isEmpty() || l.size()>this.CAPACITY){
            addCapacity();
        }
        
        for(int i=0;i<=l.size();i++){
            this.elements[this.effectiveSize-1]=l.get(i);
        }
        this.effectiveSize=this.effectiveSize+l.size();
        return true;
    }

    private boolean isFull() {
        return effectiveSize == CAPACITY;
    }

    private void addCapacity() {
        this.CAPACITY = this.CAPACITY * 2;
        E[] elementos2 = (E[]) new Object[this.CAPACITY];
        for (int i = 0; i <= this.effectiveSize - 1; i++) {
            elementos2[i] = this.elements[i];
        }
        this.elements = elementos2;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= this.effectiveSize) {
            throw new IndexOutOfBoundsException("Índice fuera de los límites válidos.");
        }
        return this.elements[index];
    }
}
