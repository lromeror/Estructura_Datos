/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ec.edu.espol.recursividad;

import java.util.Stack;

/**
 *
 * @author Jonanyu 11.1
 */
public class Recursividad {

    public static void main(String[] args) {
//        int[] arreglo = { 1, 2, 3, 4, 5 };
//        reverseArray(arreglo, 0, arreglo.length - 1);
//        for (int num : arreglo) {
//            System.out.print(num + " ");
//        }

        Stack<Integer> stack = new Stack<>();
//
//        // Llenar la pila con 5 números
//        stack.push(10); // Agregar el número 10 a la pila
//        stack.push(20); // Agregar el número 20 a la pila
//        stack.push(30); // Agregar el número 30 a la pila
//        stack.push(40); // Agregar el número 40 a la pila
//        stack.push(50); // Agregar el número 50 a la pila
//        Stack<Integer> stack2 = new Stack<>();
//        while (!stackCopyto(stack, stack2).empty()) {
//            System.out.println(stackCopyto(stack, stack2).pop());
//        }
//        stackCopyto(stack, stack2);
        int[] arr = {20, 10, 25, 30, 40};
        int k = 2;
        Stack<Integer> result = eliminarPrimerosK(arr, k);
        while (!result.empty()) {
            System.out.println(result.pop());
        }
    }

    public static void reverseArray(int[] arreglo, int inicio, int fin) {
        if (inicio < fin) {
            int temp = arreglo[inicio];
            arreglo[inicio] = arreglo[fin];
            arreglo[fin] = temp;
            reverseArray(arreglo, inicio + 1, fin - 1);
        }
    }

    public static Stack<Integer> stackCopyto(Stack<Integer> stack, Stack<Integer> stack2) {
        Stack<Integer> stackinter = new Stack<>();
        while (!stack.empty()) {
            stackinter.push(stack.pop());
        }
        while (!stackinter.empty()) {
            stack2.push(stackinter.pop());
        }
        return stack2;
    }

    public static Stack<Integer> eliminarPrimerosK(int[] array, int k) {
        Stack<Integer> stack = new Stack<>();
        int count = 0; // Contador para las eliminaciones

        for (int j : array) {
            // Verificar si la pila no está vacía y si el tope de la pila es menor que el elemento actual
            while (!stack.isEmpty() && stack.peek() < j && count < k) {
                stack.pop(); // Eliminar el tope de la pila
                count++; // Incrementar el contador de eliminaciones
            }
            // Solo se añade el elemento actual a la pila si aún no se han eliminado k elementos
            // O si después de las eliminaciones, no hay más elementos que eliminar
            stack.push(j);
        }

        // Ahora necesitamos asegurarnos de no retornar más elementos de los que están en el array original
        while (stack.size() > array.length - k) {
            stack.pop();
        }

        // Retornar la pila con los elementos restantes en el orden correcto
        Stack<Integer> result = new Stack<>();
        while (!stack.isEmpty()) {
            result.push(stack.pop());
        }

        return result;
    }

}
