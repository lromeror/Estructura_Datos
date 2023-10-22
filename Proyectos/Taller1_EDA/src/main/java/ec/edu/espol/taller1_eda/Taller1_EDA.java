/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ec.edu.espol.taller1_eda;

/**
 *
 * @author Jonanyu 11.1
 */
public class Taller1_EDA {

    public static void main(String[] args) {
        ArrayList<Integer> arreglo = new ArrayList<>();
        arreglo.addLast(1);
        arreglo.addLast(2);
        arreglo.addLast(3);
        arreglo.addLast(4);
        arreglo.addLast(5);
        arreglo.addLast(6);

        System.out.println(arreglo);
        //List<Integer> nuevoArray = ;
        System.out.println(arreglo.subList(2, 4));
        System.out.println(arreglo.removeFirstNElements(3));
        arreglo.rotate(2);
        System.out.println(arreglo);

        // crear un ArrayList de enteros aquí
        // anañadir elementos al ArrayList creado
        // llamar al método toString aquí
        // probar los otros métodos solicitados e imprmir resultados
        // crear un ArrayList de Strings aquí
        // anañadir elementos al ArrayList creado
        // llamar al método toString aquí
        // probar los otros métodos solicitados e imprmir resultados
        ArrayList<String> arreglo2 = new ArrayList<>();
        arreglo2.addLast("Luis");
        arreglo2.addLast("Yuri");
        arreglo2.addLast("Jose");
        arreglo2.addLast("Pepe");
        arreglo2.addLast("pitusa");
        arreglo2.addLast("Romero");

        System.out.println(arreglo2);
        System.out.println(arreglo2.subList(2, 4));
        System.out.println(arreglo2.removeFirstNElements(3));
        arreglo2.rotate(2);
        System.out.println(arreglo2);

    }
}
