/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Luis Romero
 * @param <E>
 */
public class BinaryTree<E> {

    private NodeBinary<E> root;

    public BinaryTree() {
        this.root = null;//Arbol binario vacio
    }

    public BinaryTree(E content) {
        this.root = new NodeBinary<>(content);
    }

    public E getRoot() {
        return this.root.getContent();
    }

    public BinaryTree<E> getLeft() {//Devuelve el nodoLeft pero como puede ser un subarbol
        return this.root.getLeft();
    }

    public BinaryTree<E> getRight() {
        return this.root.getRight();
    }

    public void setRight(BinaryTree<E> content) {//Como lo definimos un hijo puede ser un subarbol
        this.root.setRight(content);
    }

    public void setLeft(BinaryTree<E> content) {
        this.root.setLeft(content);
    }

    public void setRoot(E element) {
        if (this.root == null) {
            NodeBinary<E> newNode = new NodeBinary<>(element);
            this.root = newNode;
        } else {
            this.root.setContent(element);
        }
    }

    public boolean isEmpty() {
        return (this.root == null);
    }

    public boolean isLeaf() {
        return this.root.getLeft() == null && this.root.getRight() == null;
    }

    public List<E> preOrden() {
        List<E> listPre = new LinkedList<>();
        if (this.isEmpty()) {
            return listPre;
        }
        listPre.add(this.root.getContent());
        if (this.root.getLeft() != null) {
            List<E> lis = this.root.getLeft().preOrden();
            listPre.addAll(lis);
        }
        if (this.root.getRight() != null) {
            List<E> lis = this.root.getRight().preOrden();
            listPre.addAll(lis);
        }
        return listPre;
    }

    public ArrayList<E> preOrden2() {
        ArrayList<E> lista = new ArrayList<>();
        if (!this.isEmpty()) {
            lista.add(this.root.getContent());
            System.out.print(this.root.getContent());
            if (this.root.getLeft() != null) {
                lista.addAll(this.root.getLeft().preOrden2());
            }
            if (this.root.getRight() != null) {

                lista.addAll(this.root.getRight().preOrden2());
            }
        }
        return lista;
    }

    public List<E> postOrden() {
        List<E> listPost = new LinkedList<>();

        return listPost;
    }

    public void postOrden2() {
        if (!this.isEmpty()) {
            System.out.println(this.root.getLeft());

        }
    }

    public int countDescendants() {
        int cantDes = 0;
        if (!this.isEmpty() || this.isLeaf()) {//caso base 1
            return 0;
        } else {
            if (this.root.getLeft() != null) {
                cantDes++;
            }
            if (this.root.getRight() != null) {

            }
        }
        return -1;
    }

    public int countNodesRecursive() {
        if (this.isEmpty()) {
            return 0;
        }
        if (this.isLeaf()) {
            return 1;
        }
        int totalLeft = 0;
        if (this.getLeft() != null) {
            totalLeft = this.getLeft().countNodesRecursive();
        }
        int totalRight = 0;
        if (this.getRight() != null) {
            totalRight = this.getRight().countNodesRecursive();
        }
        return 1 + totalLeft + totalRight;
    }

    public int countNodesIterative() {
        int nNodes = 0;
        Stack<BinaryTree<E>> s = new Stack<>();
        if (!this.isEmpty()) {
            s.push(this);
        }
        while (!s.isEmpty()) {
            BinaryTree<E> tree = s.pop();
            nNodes++;
            if (tree.getLeft() != null) {
                s.push(tree.getLeft());
            }
            if (tree.getRight() != null) {
                s.push(tree.getRight());
            }
        }
        return nNodes;
    }

    public int countLeavesRecursive() {
        if (this.isEmpty()) {
            return 0;
        }
        if (this.isLeaf()) {
            return 1;
        }
        int leavesLeft = 0;
        int leavesRight = 0;
        if (this.getLeft() != null) {
            leavesLeft = this.getLeft().countLeavesRecursive();
        }
        if (this.getRight() != null) {
            leavesRight = this.getRight().countLeavesRecursive();
        }
        return leavesLeft + leavesRight;
    }

    public int countLeavesIterative() {
        int totalLeaves = 0;
        Stack<BinaryTree<E>> s = new Stack<>();
        if (!this.isEmpty()) {
            s.push(this);
        }
        while (!s.isEmpty()) {
            BinaryTree<E> tree = s.pop();
            if (tree.isLeaf()) {
                totalLeaves++;
            } else {
                if (tree.getLeft() != null) {
                    s.push(tree.getLeft());
                }
                if (tree.getRight() != null) {
                    s.push(tree.getRight());
                }
            }
        }
        return totalLeaves;
    }
}
