/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Luis Romero
 * @param <E>
 */
public class BinaryTree<E> {

    private NodeBinary<E> root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(E content) {
        this.root = new NodeBinary<>(content);
    }

    public E getRoot() {
        return this.root.getContent();
    }

    public BinaryTree<E> getLeft() {
        return this.root.getLeft();
    }

    public BinaryTree<E> getRight() {
        return this.root.getRight();
    }

    public void setRight(BinaryTree<E> content) {
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

    public int contHojas() {
        if (this.isEmpty()) {
            return 0;
        } else if (this.isLeaf()) {
            return 1;
        } else {
            int HojasIz = 0;
            int HojasDer = 0;
            if (this.root.getLeft() != null) {
                HojasIz = this.root.getLeft().contHojas();
            }
            if (this.root.getRight() != null) {
                HojasDer = this.root.getRight().contHojas();
            }
            return HojasIz + HojasDer;
        }
    }

    public int countHojasIterative() {
        int leaves = 0;
        Stack<BinaryTree<E>> s = new Stack();
        if (this.isEmpty()) {
            return 0;
        } else {
            s.push(this);
            while (!s.empty()) {
                BinaryTree<E> tree = s.pop();
                if (tree.isLeaf()) {
                    leaves++;
                }
                if (tree.root.getLeft() != null) {
                    s.push(tree.root.getLeft());
                }
                if (tree.root.getRight() != null) {
                    s.push(tree.root.getRight());
                }
            }
        }
        return leaves;
    }

    public int countDescendantsRecursive() {
        if (this.isEmpty()) {
            return 0;
        } else if (this.isLeaf()) {
            return 0;
        } else {
            int cantDesLeft = 0;
            int cantDesRight = 0;

            if (this.root.getLeft() != null) {
                cantDesLeft = this.root.getLeft().countDescendantsRecursive() + 1;
            }
            if (this.root.getRight() != null) {
                cantDesRight = this.root.getRight().countDescendantsRecursive() + 1;
            }
            return cantDesLeft + cantDesRight;
        }
    }

    public int countDescentsIterative() {
        int countDescend = 0;
        Stack<BinaryTree<E>> stack = new Stack<>();
        if (!this.isEmpty()) {
            stack.push(this);
        }

        while (!stack.isEmpty()) {
            BinaryTree<E> subtree = stack.pop();

            if (subtree.root.getRight() != null) {
                stack.push(subtree.root.getRight());
                countDescend++;
            }

            if (subtree.root.getLeft() != null) {
                stack.push(subtree.root.getLeft());
                countDescend++;
            }
        }

        return countDescend;
    }

    public E findParentRecursive(Comparator<E> cmp, E element) {
        if (this.isEmpty()) {
            return null;
        }
        BinaryTree<E> treeLeft = this.root.getLeft();
        BinaryTree<E> treeRight = this.root.getRight();

        if (treeLeft != null && cmp.compare(treeLeft.getRoot(), element) == 0) {
            return this.root.getContent();
        }

        if (treeRight != null && cmp.compare(treeRight.getRoot(), element) == 0) {
            return this.root.getContent();
        }

        E result = null;

        if (this.root.getLeft() != null) {
            result = this.root.getLeft().findParentRecursive(cmp, element);
        }

        if (result == null && this.root.getRight() != null) {
            result = this.root.getRight().findParentRecursive(cmp, element);
        }
        return result;
    }

    public E findParentIterative(Comparator<E> cmp, E element) {
        E result = null;

        Stack<BinaryTree<E>> pila = new Stack<>();
        if (this.isEmpty()) {
            return null;
        }
        pila.push(this);

        while (!pila.empty()) {
            BinaryTree<E> subtree = pila.pop();
            if (subtree != null) {
                BinaryTree<E> treeLeft = subtree.getLeft();
                BinaryTree<E> treeRight = subtree.getRight();

                if (treeLeft != null && cmp.compare(treeLeft.getRoot(), element) == 0) {
                    result = subtree.root.getContent();
                } else {
                    pila.push(subtree.getLeft());
                }

                if (treeRight != null && cmp.compare(treeRight.getRoot(), element) == 0) {
                    result = subtree.root.getContent();
                } else {
                    pila.push(subtree.getRight());
                }
            }
        }
        return result;
    }

    public int countLevelsRecursives() {
        if (this.isEmpty()) {
            return 0;
        }
        if (this.isLeaf()) {
            return 1;
        }
        int contLevelsRight = 0;
        int contLevelsLeft = 0;
        if (this.root.getLeft() != null) {
            contLevelsLeft = this.getLeft().countLevelsRecursives();
        }
        if (this.root.getRight() != null) {
            contLevelsRight = this.getRight().countLevelsRecursives();
        }

        if (contLevelsRight > contLevelsLeft) {
            return contLevelsRight + 1;
        } else {
            return contLevelsLeft + 1;
        }
    }

    public int countLevelsIterative() {
        if (isEmpty()) {
            return 0;
        }
        int levels = 0;
        Queue<BinaryTree<E>> q = new LinkedList<>();
        if (!isLeaf()) {
            q.offer(this);
            while (!q.isEmpty()) {
                int levelSize = q.size();
                for (int i = 0; i < levelSize; i++) {
                    BinaryTree<E> arb = q.poll();
                    if (arb.getLeft() != null) {
                        q.offer(arb.getLeft());
                    }
                    if (arb.getRight() != null) {
                        q.offer(arb.getRight());
                    }
                }
                levels++;
            }
        }
        return levels;
    }

    public boolean isLeftyRecursive() {
        if (this.isEmpty()) {
            return true;
        }
        if (this.isLeaf()) {
            return true;
        }
        if (this.getLeft().getLeft() == null) {
            return false;
        }
        int descendHIz = this.getLeft().countDescendantsRecursive();
        int descendientes = this.countDescendantsRecursive();
        int comparator = descendientes / 2;
        return comparator < descendHIz;
    }

    public boolean isLeftyIterative() {
        if (this.isEmpty()) {
            return true;
        }
        if (this.isLeaf()) {
            return true;
        }
        if (this.getLeft().getLeft() == null) {
            return false;
        }
        int descendHIz = this.getLeft().countDescentsIterative();
        int descendientes = this.countDescentsIterative();
        int comparator = descendientes / 2;
        return comparator < descendHIz;
    }

    public boolean isIdenticalRecursive(Comparator<E> cmp, BinaryTree<E> bt) {

        if (isEmpty() && bt.isEmpty()) {
            return true;
        }

        if (!isEmpty() && !bt.isEmpty() && cmp.compare(getRoot(), bt.getRoot()) == 0) {
            boolean leftIdentical = (getLeft() == null && bt.getLeft() == null)
                    || (getLeft() != null && bt.getLeft() != null && getLeft().isIdenticalRecursive(cmp, bt.getLeft()));

            boolean rightIdentical = (getRight() == null && bt.getRight() == null)
                    || (getRight() != null && bt.getRight() != null && getRight().isIdenticalRecursive(cmp, bt.getRight()));

            return leftIdentical && rightIdentical;
        }

        return false;
    }

    public boolean isIdenticalIterative(Comparator<E> cmp, BinaryTree<E> bt) {
        if (isEmpty() && bt.isEmpty()) {
            return true;
        }
        if (!isEmpty() && !bt.isEmpty() && cmp.compare(getRoot(), bt.getRoot()) == 0) {
            Stack<BinaryTree<E>> stackThis = new Stack<>();
            Stack<BinaryTree<E>> stackBt = new Stack<>();

            stackThis.push(this);
            stackBt.push(bt);

            while (!stackThis.isEmpty() && !stackBt.isEmpty()) {
                BinaryTree<E> currentThis = stackThis.pop();
                BinaryTree<E> currentBt = stackBt.pop();

                if (cmp.compare(currentThis.getRoot(), currentBt.getRoot()) != 0) {
                    return false;
                }

                if (currentThis.getRight() != null && currentBt.getRight() != null) {
                    stackThis.push(currentThis.getRight());
                    stackBt.push(currentBt.getRight());
                } else if (!(currentThis.getRight() == null && currentBt.getRight() == null)) {
                    return false;
                }

                if (currentThis.getLeft() != null && currentBt.getLeft() != null) {
                    stackThis.push(currentThis.getLeft());
                    stackBt.push(currentBt.getLeft());
                } else if (!(currentThis.getLeft() == null && currentBt.getLeft() == null)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void largestValueOfEachLevelRecursive(BinaryTree<Integer> arbol) {
        if (!arbol.isEmpty()) {
            Map<Integer, Integer> maxValue = new HashMap<>();
            largestValueOfEachLevel(arbol, 0, maxValue);
            Set<Integer> keys = maxValue.keySet();
            Iterator<Integer> it = keys.iterator();
            StringBuilder sb = new StringBuilder();
            int cont = 0;
            while (it.hasNext()) {
                if (cont < keys.size()) {
                    sb.append(maxValue.get(it.next()));
                    sb.append(" ");
                } else {
                    sb.append(maxValue.get(it.next()));
                }
            }
            System.out.println(sb.toString());
        }
    }

    private static void largestValueOfEachLevel(BinaryTree<Integer> arbol, int level, Map<Integer, Integer> map) {
        if (!map.containsKey(level) || arbol.getRoot() > map.get(level)) {
            map.put(level, arbol.getRoot());
        }
        if (arbol.getLeft() != null) {
            largestValueOfEachLevel(arbol.getLeft(), level + 1, map);
        }
        if (arbol.getRight() != null) {
            largestValueOfEachLevel(arbol.getRight(), level + 1, map);
        }
    }

    public static void largestValueOfEachLevelIterative(BinaryTree<Integer> arbol) {
        if (!arbol.isEmpty()) {
            Map<Integer, Integer> maxValue = new HashMap<>();
            Queue<BinaryTree<Integer>> q = new LinkedList<>();
            q.offer(arbol);
            int level = 0;
            while (!q.isEmpty()) {
                int levelSize = q.size();
                int maxVal = 0;
                for (int i = 0; i < levelSize; i++) {
                    BinaryTree<Integer> arb = q.poll();
                    if (arb.getRoot() > maxVal) {
                        maxVal = arb.getRoot();
                    }
                    if (arb.getLeft() != null) {
                        q.offer(arb.getLeft());
                    }
                    if (arb.getRight() != null) {
                        q.offer(arb.getRight());
                    }
                }
                level++;
                maxValue.put(level, maxVal);
            }
            Set<Integer> keys = maxValue.keySet();
            Iterator<Integer> it = keys.iterator();
            StringBuilder sb = new StringBuilder();
            int cont = 0;
            while (it.hasNext()) {
                if (cont < keys.size()) {
                    sb.append(maxValue.get(it.next()));
                    sb.append(" ");
                } else {
                    sb.append(maxValue.get(it.next()));
                }
            }
            System.out.println(sb.toString());
        }
    }

    public boolean isHeightBalancedRecursive() {
        if (this.isEmpty()) {
            return true;
        }
        int levelLeft = 0;
        int levelRight = 0;

        if (this.getLeft() != null && !this.getLeft().isEmpty()) {
            levelLeft = this.getLeft().countLevelsRecursives();
        }
        if (this.getRight() != null && !this.getRight().isEmpty()) {
            levelLeft = this.getRight().countLevelsRecursives();
        }

        if (Math.abs(levelLeft - levelRight) > 1) {
            return false;
        }

        boolean left = (this.getLeft() == null) || this.getLeft().isHeightBalancedRecursive();
        boolean right = (this.getRight() == null) || this.getRight().isHeightBalancedRecursive();

        return left && right;
    }

    public boolean isHeightBalancedIterative() {
        if (isEmpty() || isLeaf()) {
            return true;
        }

        Queue<BinaryTree<E>> queue = new LinkedList<>();
        queue.offer(this);

        while (!queue.isEmpty()) {
            BinaryTree<E> tree = queue.poll();

            int heightLeft = 0;
            int heightRight = 0;

            if (tree.getLeft() != null) {
                heightLeft = tree.getLeft().countLevelsIterative();
                queue.offer(tree.getLeft());
            }

            if (tree.getRight() != null) {
                heightRight = tree.getRight().countLevelsIterative();
                queue.offer(tree.getRight());
            }

            int heightDifference = Math.abs(heightLeft - heightRight);
            if (heightDifference > 1) {
                return false;
            }
        }
        return true;
    }

    public int countNodeWithOnlyChildIterative() {
        int cantNode = 0;
        if (!this.isEmpty()) {
            Queue<BinaryTree<E>> pila = new ArrayDeque<>();
            pila.offer(this);
            while (!pila.isEmpty()) {
                BinaryTree<E> tree = pila.poll();
                int chi = 0;
                if (tree.getLeft() != null && !tree.getLeft().isEmpty()) {
                    chi++;
                    pila.offer(tree.getLeft());
                }
                if (tree.getRight() != null && !tree.getRight().isEmpty()) {
                    chi++;
                    pila.offer(tree.getRight());
                }
                if (chi == 1) {
                    cantNode++;
                }
            }
        }
        return cantNode;
    }

    public int countNodeWithOnlyChildRecursive() {
        if (this.isEmpty()) {
            return 0;
        }

        int nodeLeft = 0;
        int nodeRight = 0;

        if (this.getLeft() != null && !this.getLeft().isEmpty()) {
            nodeLeft = this.getLeft().countNodeWithOnlyChildRecursive();
        }

        if (this.getRight() != null && !this.getRight().isEmpty()) {
            nodeRight = this.getRight().countNodeWithOnlyChildRecursive();
        }

        if ((this.getLeft() != null && !this.getLeft().isEmpty()) && (this.getRight() != null && !this.getRight().isEmpty())) {
            return 1 + nodeLeft + nodeRight;
        }

        return nodeLeft + nodeRight;
    }

}
