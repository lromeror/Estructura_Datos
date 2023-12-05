/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ec.edu.espol.practicaexamen;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;
import java.util.Random;

/**
 *
 * @author Jonanyu 11.1
 */
public class PracticaExamen {

    public static void main(String[] args) {
        ArrayList<Integer> numerdispo = new ArrayList<>();
        numerdispo.add(3);
        numerdispo.add(2);
        numerdispo.add(5);
        numerdispo.add(1);
        numerdispo.add(4);
        simularAplilamiento(numerdispo);

//        List<String> purbeList = new ArrayList<>();
//        purbeList.add("123");
//        purbeList.add("12");
//        purbeList.add("1234");
//        purbeList.add("1");
//
//        System.out.println(getStringsShorterThan(purbeList, 2));
    }

    public static List<String> getStringsShorterThan(List<String> inputList, int k) {
        List<String> nuevaList = new ArrayList<>();
        for (String cara : inputList) {
            if (cara.length() < k) {
                nuevaList.add(cara);
            }
        }
        return nuevaList;
    }

    public static Stack<Integer> combineOrderStacks(Stack<Integer> s1, Stack<Integer> s2) {
        Stack<Integer> nuevaPilas = new Stack<>();
        Stack<Integer> pilaAux = new Stack<>();
        while (!s1.empty() && !s2.empty()) {
            pilaAux.push(s1.pop());
            pilaAux.push(s2.pop());
        }
        while (!pilaAux.empty()) {
            nuevaPilas.push(pilaAux.pop());
        }
        return nuevaPilas;
    }

    public static String metoString(Deque<Integer> pila, int nvez, ArrayList<Integer> lisori, int bloquese) {
        ArrayList<Integer> Almacenado = new ArrayList<>();

        while (!pila.isEmpty()) {
            Almacenado.add(pila.pop());
        }

        StringBuilder cadena = new StringBuilder();

        String turno = "Turno " + nvez + "\n";
        cadena.append(turno);
        String lista = lisori + "\n";
        String bloque = "Bloque disponible\n";

        cadena.append(bloque);
        cadena.append(lista);
        String torreActual = "TorreActual\n";
        cadena.append(torreActual);
        cadena.append("[");
        for (int i = Almacenado.size() - 1; i >= 0; i--) {
            if (i == 0) {
                cadena.append(Almacenado.get(i));
            } else {
                cadena.append(Almacenado.get(i));
                cadena.append(",");
            }
        }
        cadena.append("]");
        String bloqueSel = "Bloque seleccionado" + bloquese;
        cadena.append(bloqueSel);
        cadena.append("\n");
        return cadena.toString();
    }

    public static void simularAplilamiento(ArrayList<Integer> listaBloques) {
        int nvez = 1;
        int elemento = 0;
        Deque<Integer> pilaTorre = new ArrayDeque<>();
        boolean estado = false;
        do {
            Random rand = new Random();
            int indiceAleat = rand.nextInt(listaBloques.size());
            if (pilaTorre.isEmpty() == true) {
                pilaTorre.push(listaBloques.get(indiceAleat));
                elemento = listaBloques.get(indiceAleat);
                listaBloques.remove(indiceAleat);
            } else {
                if (listaBloques.get(indiceAleat) <= pilaTorre.peek()) {
                    pilaTorre.push(listaBloques.get(indiceAleat));
                    elemento = listaBloques.get(indiceAleat);
                    listaBloques.remove(indiceAleat);
                } else {
                    estado = true;
                }
            }

            String turno = metoString(pilaTorre, nvez, listaBloques, elemento);
            System.out.println(turno);
            nvez++;
        } while (estado == false && !listaBloques.isEmpty());

//        while (!pilaTorre.isEmpty()) {
//            System.out.println(pilaTorre.pop());
//        }
        //System.out.println(puntaje);
    }

}
