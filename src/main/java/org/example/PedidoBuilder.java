package org.example;

public class PedidoBuilder {

    private Pedido pedido;

    public PedidoBuilder() {
        pedido = new Pedido();
    }

    public Pedido build() {
        if (pedido.getHamburguer() == null) {
            throw new IllegalArgumentException("Hamburguer inválido");
        }
        if (pedido.getValorAPagar() == 0) {
            throw new IllegalArgumentException("Valor inválido");
        }
        return pedido;
    }

    public PedidoBuilder setHamburguer(Hamburguer hamburguer) {
        pedido.setHamburguer(hamburguer);
        return this;
    }

    public PedidoBuilder setValorAPagar(float valorAPagar) {
        pedido.setValorAPagar(valorAPagar);
        return this;
    }
}