package org.example;

import java.util.Iterator;

public class RelatorioPedidos {

    public static Integer contarPedidosEntregues(FilaPedidos fila) {
        int quantidade = 0;
        for (Pedido pedido : fila) {
            if (pedido.getEstado() == PedidoEstadoEntregue.getInstance()) {
                quantidade++;
            }
        }
        return quantidade;
    }

    public static Integer contarTotalPedidos(FilaPedidos fila) {
        int quantidade = 0;
        for (Iterator<Pedido> p = fila.iterator(); p.hasNext(); ) {
            quantidade++;
            p.next();
        }
        return quantidade;
    }
}