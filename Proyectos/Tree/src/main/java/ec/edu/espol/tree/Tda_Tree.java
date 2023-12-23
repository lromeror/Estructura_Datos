/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ec.edu.espol.tree;

import java.util.Comparator;

/**
 *
 * @author Luis Romero
 */
public class Tda_Tree {
    public static void main(String[] args) {
        BinaryTree<Integer> arbolNum = new BinaryTree<>();
        arbolNum.setRoot(0);
        arbolNum.setLeft(new BinaryTree<>(1));
        arbolNum.setRight(new BinaryTree<>(2));

        arbolNum.getLeft().setLeft(new BinaryTree<>(3));
        arbolNum.getRight().setRight(new BinaryTree<>(4));
        arbolNum.getRight().setLeft(new BinaryTree<>(5));
        arbolNum.getRight().getLeft().setLeft(new BinaryTree<>(6));
        arbolNum.getRight().getLeft().setRight(new BinaryTree<>(7));
        arbolNum.getLeft().getLeft().setLeft(new BinaryTree<>(8));
        arbolNum.getLeft().getLeft().setRight(new BinaryTree<>(9));
        
        BinaryTree<Integer> arbolZurdo = new BinaryTree<>(1);
        arbolZurdo.setLeft(new BinaryTree<>(2));
        arbolZurdo.setRight(new BinaryTree<>(3));

        arbolZurdo.getLeft().setLeft(new BinaryTree<>(4));
        arbolZurdo.getLeft().setRight(new BinaryTree<>(5));

        arbolZurdo.getLeft().getLeft().setLeft(new BinaryTree<>(6));
        arbolZurdo.getLeft().getLeft().setRight(new BinaryTree<>(7));

        arbolZurdo.getLeft().getRight().setLeft(new BinaryTree<>(8));
        arbolZurdo.getLeft().getRight().setRight(new BinaryTree<>(9));

        BinaryTree<Integer> tree = new BinaryTree(0);
        tree.setLeft(new BinaryTree(1));
        tree.setRight(new BinaryTree(2));
        tree.getLeft().setLeft(new BinaryTree(3));
        tree.getLeft().setRight(new BinaryTree(4));
        tree.getRight().setLeft(new BinaryTree(5));
        tree.getRight().setRight(new BinaryTree(6));
        tree.getRight().getRight().setRight(new BinaryTree(7));

        BinaryTree<Integer> tree2 = new BinaryTree(0);
        tree2.setLeft(new BinaryTree(1));
        tree2.setRight(new BinaryTree(2));
        tree2.getLeft().setLeft(new BinaryTree(3));
        tree2.getLeft().setRight(new BinaryTree(4));
        tree2.getRight().setLeft(new BinaryTree(5));
        tree2.getRight().setRight(new BinaryTree(6));
        tree2.getRight().getRight().setRight(new BinaryTree(7));

        System.out.println(arbolNum.contHojas());
        System.out.println(arbolNum.countDescentsIterative());
        Comparator<Integer> cmp = (Integer o1, Integer o2) -> o1 - o2;
        System.out.println(arbolNum.findParentIterative(cmp, 0));
        System.out.println(arbolNum.countLevelsRecursives());
        System.out.println(arbolZurdo.isLeftyIterative());
        System.out.println(tree2.isIdenticalIterative(cmp, tree));
        System.out.println(tree2.isIdenticalRecursive(cmp, arbolNum));
        System.out.println(tree.isHeightBalancedIterative());
        System.out.println(tree.isHeightBalancedRecursive());
        System.out.println(tree.countNodeWithOnlyChildIterative());
        System.out.println(tree.countNodeWithOnlyChildRecursive());

    }
}
