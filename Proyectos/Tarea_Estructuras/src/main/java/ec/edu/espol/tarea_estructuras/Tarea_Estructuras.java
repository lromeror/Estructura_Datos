/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ec.edu.espol.tarea_estructuras;

import java.util.Comparator;

/**
 *
 * @author Jonanyu 11.1
 */
public class Tarea_Estructuras {

    public static void main(String[] args) {
        //ArrayList
        ArrayList<Integer> lista = new ArrayList<>();
        lista.addLast(1);
        lista.addLast(3);
        lista.addLast(9);
        lista.addLast(10);
        lista.addLast(5);
        lista.addLast(8);
        lista.addLast(12);
        lista.addLast(2);

        ArrayList<Integer> lista2 = new ArrayList<>();
        lista2.addLast(10);
        lista2.addLast(2);
        lista2.addLast(8);

        Comparator<Integer> cmp = (Integer n, Integer n2) -> {
            return n - n2;
        };

        System.out.println(lista);
        
        lista.removeDuplicates(cmp);
        
        System.out.println(lista.binarySearch(10, cmp));

        System.out.println(lista);
        //Cabe recalcar que solamente me da la posicion del primer elemento de izquierda a derecha
        
        System.out.println(lista.getIndexOf(1, cmp));
        
        System.out.println(lista.getAllIndicesOf(1, cmp));
        
        lista.sort(cmp);
        
        System.out.println(lista);
        
        lista.insertSorted(4, cmp);
        
        System.out.println(lista);
        
        System.out.println(lista.mergeSorted(lista2, cmp));
        
        System.out.println(lista.findUnion(lista2, cmp));
        
        System.out.println(lista.containsAll(lista2, cmp));
        
        
        //LinkedList
        LinkedList<Integer> listaL=new LinkedList<>();
        listaL.addLast(1);
        listaL.addLast(3);
        listaL.addLast(9);
        listaL.addLast(10);
        listaL.addLast(5);
        listaL.addLast(8);
        listaL.addLast(12);
        listaL.addLast(2);
        
        LinkedList<Integer> listaL2=new LinkedList<>();
        listaL.addLast(1);
        listaL.addLast(3);
        listaL.addLast(9);
        listaL.addLast(10);
        
        
        System.out.println(listaL);
        
        listaL.removeDuplicates(cmp);
        
        System.out.println(listaL.binarySearch(10, cmp));

        System.out.println(listaL);
        //Cabe recalcar que solamente me da la posicion del primer elemento de izquierda a derecha
        
        System.out.println(listaL.getIndexOf(1, cmp));
        
        System.out.println(listaL.getAllIndicesOf(1, cmp));
        
        listaL.sort(cmp);
        
        System.out.println(listaL);
        
        listaL.insertSorted(4, cmp);
        
        System.out.println(listaL);
        
        System.out.println(listaL.mergeSorted(listaL2, cmp));
        
        System.out.println(listaL.findUnion(listaL2, cmp));
        
        System.out.println(listaL.containsAll(listaL2, cmp));
      
        
    }
}
