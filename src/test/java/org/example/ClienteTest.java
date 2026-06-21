package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void deveFazerPedido() {
        Cliente cliente = new Cliente();
        Pedido pedido = new PedidoBuilder()
                .setHamburguer(FabricaArtesanal.getInstance().createHamburguerBase(CarneFactory.getCarne("200g")))
                .setValorAPagar(50.0f)
                .build();
        assertEquals("O App agradece seu contato.\n" +
                        "O Recepcionista respondeu sua demanda conforme mensagem a seguir.\n" +
                        ">>Recepcionista aceitou o pedido",
                cliente.fazerPedido(pedido));
    }

    @Test
    void deveArmazenarPedidos() {
        Cliente cliente = new Cliente();
        ClienteProxy proxy = new ClienteProxy(cliente, true);
        Pedido pedido1 = new PedidoBuilder()
                .setHamburguer(FabricaArtesanal.getInstance().createHamburguerBase(CarneFactory.getCarne("200g")))
                .setValorAPagar(50.0f)
                .build();
        Pedido pedido2 = new PedidoBuilder()
                .setHamburguer(FabricaSmash.getInstance().createHamburguerBase(CarneFactory.getCarne("100g")))
                .setValorAPagar(40.0f)
                .build();
        cliente.fazerPedido(pedido1);
        cliente.fazerPedido(pedido2);
        assertEquals(2, proxy.getHistoricoPedidos().size());
    }

    @Test
    void deveRetornarPrimeiroPedido() {
        Cliente cliente = new Cliente();
        ClienteProxy proxy = new ClienteProxy(cliente, true);
        Pedido pedido1 = new PedidoBuilder()
                .setHamburguer(FabricaArtesanal.getInstance().createHamburguerBase(CarneFactory.getCarne("200g")))
                .setValorAPagar(50.0f)
                .build();
        Pedido pedido2 = new PedidoBuilder()
                .setHamburguer(FabricaSmash.getInstance().createHamburguerBase(CarneFactory.getCarne("100g")))
                .setValorAPagar(40.0f)
                .build();
        cliente.fazerPedido(pedido1);
        cliente.fazerPedido(pedido2);
        assertEquals(pedido1, proxy.restaurarPedido(0));
    }

    @Test
    void deveRetornarPedidoAnterior() {
        Cliente cliente = new Cliente();
        ClienteProxy proxy = new ClienteProxy(cliente, true);
        Pedido pedido1 = new PedidoBuilder()
                .setHamburguer(FabricaArtesanal.getInstance().createHamburguerBase(CarneFactory.getCarne("200g")))
                .setValorAPagar(50.0f)
                .build();
        Pedido pedido2 = new PedidoBuilder()
                .setHamburguer(FabricaSmash.getInstance().createHamburguerBase(CarneFactory.getCarne("100g")))
                .setValorAPagar(40.0f)
                .build();
        Pedido pedido3 = new PedidoBuilder()
                .setHamburguer(FabricaArtesanal.getInstance().createHamburguerBase(CarneFactory.getCarne("200g")))
                .setValorAPagar(50.0f)
                .build();
        cliente.fazerPedido(pedido1);
        cliente.fazerPedido(pedido2);
        cliente.fazerPedido(pedido3);
        assertEquals(pedido2, proxy.restaurarPedido(1));
    }

    @Test
    void deveRetornarExcecaoIndiceInvalido() {
        try {
            Cliente cliente = new Cliente();
            ClienteProxy proxy = new ClienteProxy(cliente, true);
            proxy.restaurarPedido(0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Índice inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarPedidoClonado() throws CloneNotSupportedException {
        Cliente cliente = new Cliente();
        ClienteProxy proxy = new ClienteProxy(cliente, true);
        Pedido pedido = new PedidoBuilder()
                .setHamburguer(FabricaArtesanal.getInstance().createHamburguerBase(CarneFactory.getCarne("200g")))
                .setValorAPagar(50.0f)
                .build();
        pedido.preparar();
        pedido.pronto();
        cliente.fazerPedido(pedido);
        Pedido pedidoClone = proxy.repetirPedido(0);

        assertEquals(PedidoEstadoPronto.getInstance(), pedido.getEstado());
        assertEquals(PedidoEstadoAceito.getInstance(), pedidoClone.getEstado());
        assertEquals(pedido.getHamburguer(), pedidoClone.getHamburguer());
        assertEquals(pedido.getValorAPagar(), pedidoClone.getValorAPagar());
    }

    @Test
    void deveRetornarExcecaoClienteNaoAutenticadoConsultarHistorico() {
        try {
            Cliente cliente = new Cliente();
            ClienteProxy proxy = new ClienteProxy(cliente, false);
            proxy.getHistoricoPedidos();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Cliente não autenticado", e.getMessage());
        }
    }
}