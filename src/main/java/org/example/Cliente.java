package org.example;

public class Cliente {

    public String fazerPedido(Pedido pedido) {
        return App.getInstance().receberPedidoRecepcionista(pedido);
    }
}
