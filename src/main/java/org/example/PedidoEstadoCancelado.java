package org.example;

public class PedidoEstadoCancelado extends PedidoEstado implements TipoAcao{

    private PedidoEstadoCancelado() {};
    private static PedidoEstadoCancelado instance = new PedidoEstadoCancelado();
    public static PedidoEstadoCancelado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Pedido cancelado!!";
    }

}