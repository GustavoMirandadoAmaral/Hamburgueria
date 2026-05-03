package org.example;

public class PedidoEstadoAceito extends PedidoEstado implements TipoAcao{

    private PedidoEstadoAceito() {};
    private static PedidoEstadoAceito instance = new PedidoEstadoAceito();
    public static PedidoEstadoAceito getInstance() {
        return instance;
    }
    
    public String getEstado() {
        return "Pedido aceito com sucesso!!";
    }

    public boolean preparar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoPreparando.getInstance());
        return true;
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}
