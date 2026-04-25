package org.example;

public class FabricaDeliveryDinheiro implements FabricaAbstrata {
    public Pedido createPedido(double valor) {
        return new PedidoDelivery(valor);
    }
    public PlataformaPagamento createPagamento() {
        return new Dinheiro();
    }
}