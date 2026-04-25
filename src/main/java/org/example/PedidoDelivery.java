package org.example;

public class PedidoDelivery extends Pedido {
    public PedidoDelivery(double valor) { super(valor); }

    public String realizarPedido() {
        return "Pedido delivery: " + plataformaPagamento.processarPagamento(valor);
    }
}
