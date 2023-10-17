package tdas;

public interface List<E> {
    
    public int size();
    
    public boolean isEmpty ();
    
    public void clear();
    
    public boolean addFirst (E element);
    
    public boolean addLast (E element);
    
    // inserta todos los elementos recibidos al final de lista
    public boolean addAll (List<E> l);
    
}
