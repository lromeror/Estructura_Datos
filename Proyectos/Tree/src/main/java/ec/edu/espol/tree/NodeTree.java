/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tree;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Jonanyu 11.1
 * @param <E>
 */
public class NodeTree<E> {

    private E element;
    private List<Tree<E>> children;

    public NodeTree(E element) {
        this.element = element;
        this.children = new LinkedList<>();
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public List<Tree<E>> getChildren() {
        return children;
    }

    public void setChildren(List<Tree<E>> children) {
        this.children = children;
    }
}
