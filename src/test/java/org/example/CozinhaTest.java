package org.example;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CozinhaTest {

    private Pedido criarPedido(FabricaAbstrata fabrica, String tipoCarne, float valor) {
        return new PedidoBuilder()
                .setHamburguer(fabrica.createHamburguerBase(CarneFactory.getCarne(tipoCarne)))
                .setValorAPagar(valor)
                .build();
    }

    @Test
    void devePrepararHamburgueres() {
        Cozinha cozinha = new Cozinha();
        Pedido pedido1 = criarPedido(FabricaArtesanal.getInstance(), "200g", 50.0f);
        Pedido pedido2 = criarPedido(FabricaArtesanal.getInstance(), "200g", 50.0f);
        Pedido pedido3 = criarPedido(FabricaSmash.getInstance(), "200g", 45.0f);
        Pedido pedido4 = criarPedido(FabricaSmash.getInstance(), "100g", 40.0f);

        cozinha.registrarPedido(pedido1);
        cozinha.registrarPedido(pedido2);
        cozinha.registrarPedido(pedido3);
        cozinha.registrarPedido(pedido4);

        List<String> saida = Arrays.asList(
                "Pão: Pão australiano + Carne grelhada em fogo alto + Carne: Carne ângus (Carne de 200g)",
                "Pão: Pão australiano + Carne grelhada em fogo alto + Carne: Carne ângus (Carne de 200g)",
                "Pão: Pão com gergelim + Carne prensada na chapa + Carne: Carne acém (Carne de 200g)",
                "Pão: Pão com gergelim + Carne prensada na chapa + Carne: Carne acém (Carne de 100g)"
        );

        assertEquals(saida, cozinha.prepararTodos());
    }

    @Test
    void deveMudarEstadoDosPedidosParaPreparando() {
        Cozinha cozinha = new Cozinha();
        Pedido pedido = criarPedido(FabricaArtesanal.getInstance(), "200g", 50.0f);

        cozinha.registrarPedido(pedido);
        cozinha.prepararTodos();

        assertEquals(PedidoEstadoPreparando.getInstance(), pedido.getEstado());
    }

    @Test
    void deveRetornarTotalCarnesCompartilhadas() {
        Cozinha cozinha = new Cozinha();
        cozinha.registrarPedido(criarPedido(FabricaArtesanal.getInstance(), "200g", 50.0f));
        cozinha.registrarPedido(criarPedido(FabricaArtesanal.getInstance(), "200g", 50.0f));
        cozinha.registrarPedido(criarPedido(FabricaSmash.getInstance(), "200g", 45.0f));
        cozinha.registrarPedido(criarPedido(FabricaSmash.getInstance(), "100g", 40.0f));

        assertEquals(2, CarneFactory.getTotalCarnes());
    }
}