/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ec.edu.espol.tree;

/**
 *
 * @author Luis Romero
 */
public class Tda_Tree {

    public static void main(String[] args) {
//
//        Tree<Integer> arbolNum = new Tree<>();
//        arbolNum.setRoot(3);//este es el nodo raiz
//        arbolNum.addChildren(28);//dos hijos
//        arbolNum.addChildren(10);

        BinaryTree<Integer> arbolNum = new BinaryTree<>();
        arbolNum.setRoot(0);
        arbolNum.setLeft(new BinaryTree<>(1));//Aqui estamos llenando a los hijos del principal que son subarboles
        arbolNum.setRight(new BinaryTree<>(2));
        //Aqui le daremsos hijos a los hijos de los arboles
        arbolNum.getLeft().setLeft(new BinaryTree<>(3));//Aqui estamos consultado del root al hijoiz y seteamos a un nuevo hijo set
        arbolNum.getRight().setRight(new BinaryTree<>(4));
        arbolNum.getRight().setLeft(new BinaryTree<>(5));
        //Otra escala
        arbolNum.getRight().getLeft().setLeft(new BinaryTree<>(6));
        arbolNum.getRight().getLeft().setRight(new BinaryTree<>(7));
        arbolNum.getLeft().getLeft().setLeft(new BinaryTree<>(8));
        arbolNum.getLeft().getLeft().setRight(new BinaryTree<>(9));

        arbolNum.preOrden2();

    }
}
