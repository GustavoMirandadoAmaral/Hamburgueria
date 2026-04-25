package org.example;

public class PedidoLocal extends Pedido {
    public PedidoLocal(double valor) { super(valor); }

    public String realizarPedido() {
        return "Pedido local: " + plataformaPagamento.processarPagamento(valor);
    }
}
