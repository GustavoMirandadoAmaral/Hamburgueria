package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void deveFazerPedido() {
        Cliente cliente = new Cliente();
        Pedido pedido = new PedidoBuilder()
                .setHamburguer(FabricaArtesanal.getInstance().createHamburguerBase(new Carne200g()))
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
        Pedido pedido1 = new PedidoBuilder()
                .setHamburguer(FabricaArtesanal.getInstance().createHamburguerBase(new Carne200g()))
                .setValorAPagar(50.0f)
                .build();
        Pedido pedido2 = new PedidoBuilder()
                .setHamburguer(FabricaSmash.getInstance().createHamburguerBase(new Carne100g()))
                .setValorAPagar(40.0f)
                .build();
        cliente.fazerPedido(pedido1);
        cliente.fazerPedido(pedido2);
        assertEquals(2, cliente.getHistoricoPedidos().size());
    }

    @Test
    void deveRetornarPrimeiroPedido() {
        Cliente cliente = new Cliente();
        Pedido pedido1 = new PedidoBuilder()
                .setHamburguer(FabricaArtesanal.getInstance().createHamburguerBase(new Carne200g()))
                .setValorAPagar(50.0f)
                .build();
        Pedido pedido2 = new PedidoBuilder()
                .setHamburguer(FabricaSmash.getInstance().createHamburguerBase(new Carne100g()))
                .setValorAPagar(40.0f)
                .build();
        cliente.fazerPedido(pedido1);
        cliente.fazerPedido(pedido2);
        assertEquals(pedido1, cliente.restaurarPedido(0));
    }

    @Test
    void deveRetornarPedidoAnterior() {
        Cliente cliente = new Cliente();
        Pedido pedido1 = new PedidoBuilder()
                .setHamburguer(FabricaArtesanal.getInstance().createHamburguerBase(new Carne200g()))
                .setValorAPagar(50.0f)
                .build();
        Pedido pedido2 = new PedidoBuilder()
                .setHamburguer(FabricaSmash.getInstance().createHamburguerBase(new Carne100g()))
                .setValorAPagar(40.0f)
                .build();
        Pedido pedido3 = new PedidoBuilder()
                .setHamburguer(FabricaArtesanal.getInstance().createHamburguerBase(new Carne200g()))
                .setValorAPagar(50.0f)
                .build();
        cliente.fazerPedido(pedido1);
        cliente.fazerPedido(pedido2);
        cliente.fazerPedido(pedido3);
        assertEquals(pedido2, cliente.restaurarPedido(1));
    }

    @Test
    void deveRetornarExcecaoIndiceInvalido() {
        try {
            Cliente cliente = new Cliente();
            cliente.restaurarPedido(0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Índice inválido", e.getMessage());
        }
    }
    @Test
    void deveRetornarPedidoClonado() throws CloneNotSupportedException {
        Cliente cliente = new Cliente();
        Pedido pedido = new PedidoBuilder()
                .setHamburguer(FabricaArtesanal.getInstance().createHamburguerBase(new Carne200g()))
                .setValorAPagar(50.0f)
                .build();
        pedido.preparar();
        pedido.pronto();
        cliente.fazerPedido(pedido);
        Pedido pedidoClone = cliente.repetirPedido(0);

        assertEquals(PedidoEstadoPronto.getInstance(), pedido.getEstado());
        assertEquals(PedidoEstadoAceito.getInstance(), pedidoClone.getEstado());
        assertEquals(pedido.getHamburguer(), pedidoClone.getHamburguer());
        assertEquals(pedido.getValorAPagar(), pedidoClone.getValorAPagar());
    }
}