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
public class Tree<E> {

    private NodeTree<E> root;

    public Tree() {
        this.root = null;
    }

    public Tree(E element) {
        this.root = new NodeTree(element);
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public E getRoot() {
        return root.getElement();
    }

    private NodeTree getRootNode() {
        return this.root;
    }

    private void setRootNode(NodeTree<E> root) {
        this.root = root;
    }

    public void setRoot(E content) {
        if (this.root == null) {
            this.root = new NodeTree<>(content);
        } else {
            this.root.setElement(content);
        }
    }

    public boolean isLeaf() {
        return this.root.getChildren().isEmpty();
    }

    public boolean addChildren(E element) {
        if (element == null) {
            return false;
        }
        Tree<E> newTree = new Tree(element);
        this.root.getChildren().add(newTree);
        return false;
    }

}
