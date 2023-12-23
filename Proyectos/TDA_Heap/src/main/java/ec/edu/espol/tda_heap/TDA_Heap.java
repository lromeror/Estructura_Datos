/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ec.edu.espol.tda_heap;

import java.util.Comparator;

/**
 *
 * @author Jonanyu 11.1
 */
public class TDA_Heap {

    public static void main(String[] args) {
        Comparator<Integer> cmp = (Integer o1, Integer o2) -> o1 - o2;

        Heap<Integer> nums = new Heap<>(cmp);
        nums.addFirst(28);
        nums.addFirst(70);
        nums.addFirst(20);
        nums.addFirst(72);
        nums.addFirst(25);
        nums.addFirst(30);
        nums.addFirst(80);
        nums.addFirst(75);
        nums.addFirst(60);
        nums.addFirst(150);
        
        System.out.println(nums);
        System.out.println(nums.getLeft(5));
        System.out.println(nums.isLeaf(5));
        System.out.println(nums.getParent(3));
        nums.ajustar(1);
        System.out.println(nums);
    }
}
