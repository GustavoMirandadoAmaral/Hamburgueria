package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RelatorioPedidosTest {

    @Test
    void deveContarPedidosEntregues() {
        Pedido pedido1 = new PedidoBuilder()
                .setHamburguer(FabricaArtesanal.getInstance().createHamburguerBase(CarneFactory.getCarne("200g")))
                .setValorAPagar(50.0f)
                .build();
        pedido1.preparar();
        pedido1.pronto();
        pedido1.entregar();

        Pedido pedido2 = new PedidoBuilder()
                .setHamburguer(FabricaSmash.getInstance().createHamburguerBase(new Carne100g()))
                .setValorAPagar(40.0f)
                .build();
        pedido2.preparar();
        pedido2.pronto();
        pedido2.entregar();

        Pedido pedido3 = new PedidoBuilder()
                .setHamburguer(FabricaArtesanal.getInstance().createHamburguerBase(CarneFactory.getCarne("200g")))
                .setValorAPagar(50.0f)
                .build();
        pedido3.cancelar();

        Pedido pedido4 = new PedidoBuilder()
                .setHamburguer(FabricaSmash.getInstance().createHamburguerBase(CarneFactory.getCarne("100g")))
                .setValorAPagar(40.0f)
                .build();
        pedido4.preparar();
        pedido4.pronto();
        pedido4.entregar();

        FilaPedidos fila = new FilaPedidos(pedido1, pedido2, pedido3, pedido4);
        assertEquals(3, RelatorioPedidos.contarPedidosEntregues(fila));
    }

    @Test
    void deveContarTotalPedidos() {
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

        Pedido pedido4 = new PedidoBuilder()
                .setHamburguer(FabricaSmash.getInstance().createHamburguerBase(CarneFactory.getCarne("100g")))
                .setValorAPagar(40.0f)
                .build();

        FilaPedidos fila = new FilaPedidos(pedido1, pedido2, pedido3, pedido4);
        assertEquals(4, RelatorioPedidos.contarTotalPedidos(fila));
    }
}