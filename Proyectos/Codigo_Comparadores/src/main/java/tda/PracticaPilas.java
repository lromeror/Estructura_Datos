/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda;

import java.util.Stack;

/**
 *
 * @author Jonanyu 11.1
 */
public class PracticaPilas {
    public static Stack<Integer>  stackCopyto(Stack<Integer> stack,Stack<Integer> stack2){
        Stack<Integer> stackinter=new Stack<Integer>();
        while(!stack.isEmpty()){
           stackinter.push(stack.pop());
        }
        while(!stackinter.isEmpty()){
           stack2.push(stack.pop());
        }
        return stack2;
    }
}
