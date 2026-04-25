package org.example;

public class FabricaLocalPix implements FabricaAbstrata {
    public Pedido createPedido(double valor) {
        return new PedidoLocal(valor);
    }
    public PlataformaPagamento createPagamento() {
        return new Pix();
    }
}