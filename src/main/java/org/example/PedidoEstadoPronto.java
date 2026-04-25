package org.example;

public class PedidoEstadoPronto extends PedidoEstado {

    private PedidoEstadoPronto() {};
    private static PedidoEstadoPronto instance = new PedidoEstadoPronto();
    public static PedidoEstadoPronto getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Pedido está pronto!!";
    }

    public boolean entregar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        return true;
    }

    public boolean enviarParaRota(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEmRota.getInstance());
        return true;
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }

}
