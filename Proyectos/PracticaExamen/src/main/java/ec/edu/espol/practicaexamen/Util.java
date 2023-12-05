/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.practicaexamen;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Jonanyu 11.1
 */
public class Util {

    public List<String> getPedidosPorCliente(List<Pedido> pedidos, String cliente) {
        Map<String, List<String>> mapacliente = new TreeMap();
        for (Pedido p : pedidos) {
            if (p.getCliente().compareTo(cliente)==0) {
                mapacliente.put(cliente, p.getProductos());
            }
        }
        return mapacliente.get(cliente);
    }
    
    
}
