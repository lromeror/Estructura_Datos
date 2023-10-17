/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ec.edu.espol.recursividad;

/**
 *
 * @author Jonanyu 11.1
 */
public class Recursividad {

    public static void main(String[] args) {
        int[] arreglo = { 1, 2, 3, 4, 5 };
        reverseArray(arreglo, 0, arreglo.length - 1);
        for (int num : arreglo) {
            System.out.print(num + " ");
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
}
