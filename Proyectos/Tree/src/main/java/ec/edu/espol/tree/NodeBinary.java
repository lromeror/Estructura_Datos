/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tree;

/**
 *
 * @author Luis Romero
 * @param <E>
 */
public class NodeBinary<E> {

    private E content;
    private BinaryTree<E> left;//porque asi porque estos pueden ser otros subarboles
    private BinaryTree<E> right;

    public NodeBinary(E content) {
        this.content = content;
        this.left = null;
        this.right = null;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public BinaryTree<E> getLeft() {
        return left;
    }

    public void setLeft(BinaryTree<E> left) {
        this.left = left;
    }

    public BinaryTree<E> getRight() {
        return right;
    }

    public void setRight(BinaryTree<E> right) {
        this.right = right;
    }

}
