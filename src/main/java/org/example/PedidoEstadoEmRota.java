package org.example;

public class PedidoEstadoEmRota extends PedidoEstado{

    private PedidoEstadoEmRota() {};
    private static PedidoEstadoEmRota instance = new PedidoEstadoEmRota();
    public static PedidoEstadoEmRota getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Pedido saiu para a rota de entrega!!";
    }

    public boolean entregar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        return true;
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}
