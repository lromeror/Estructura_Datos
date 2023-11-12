/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tdas;

/**
 *
 * @author Jonanyu 11.1
 */
public class NodeList<E> {
    private E content;//Contener un generico
    private NodeList<E> next;//Esto es lo que apunta al siguiente entonces por eso usamos una nodo, POR QUE ES LO QUE APUNTA
    //NOdeList necesita un parametro de tipo
    //SI no es especifica es de tipo object

    public NodeList(E content) {
        this.content = content;
        this.next=null;
    }
    
     
    
    
    
}
