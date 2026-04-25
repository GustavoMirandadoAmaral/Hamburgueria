package org.example;

public class PedidoEstadoDevolvido extends PedidoEstado {

    private PedidoEstadoDevolvido() {};
    private static PedidoEstadoDevolvido instance = new PedidoEstadoDevolvido();
    public static PedidoEstadoDevolvido getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Pedido devolvido com sucesso!!";
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}
