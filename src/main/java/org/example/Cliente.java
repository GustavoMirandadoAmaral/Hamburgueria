package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private List<Pedido> historicoPedidos = new ArrayList<>();

    public String fazerPedido(Pedido pedido) {
        historicoPedidos.add(pedido);
        return App.getInstance().receberPedidoRecepcionista(pedido);
    }

    public Pedido restaurarPedido(int indice) {
        if (indice < 0 || indice > historicoPedidos.size() - 1) {
            throw new IllegalArgumentException("Índice inválido");
        }
        return historicoPedidos.get(indice);
    }

    public List<Pedido> getHistoricoPedidos() {
        return historicoPedidos;
    }

    public Pedido repetirPedido(int indice) throws CloneNotSupportedException {
        Pedido pedidoAntigo = restaurarPedido(indice);
        return (Pedido) pedidoAntigo.clone();
    }
}