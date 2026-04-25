package org.example;

public interface FabricaAbstrata {
    Pedido createPedido(double valor);
    PlataformaPagamento createPagamento();
}