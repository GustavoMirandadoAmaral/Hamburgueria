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
}