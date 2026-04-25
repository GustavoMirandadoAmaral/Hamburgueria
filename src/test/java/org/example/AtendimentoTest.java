package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AtendimentoTest {

    @Test
    void deveRealizarPedidoLocalPixSemIngrediente() {
        Hamburguer base = new HamburguerBase("Brioche", "Angus");
        Atendimento atendimento = new Atendimento(new FabricaLocalPix(), 50.0, base);
        assertEquals("Pedido local: Pago via PIX: R$50.0 | Hamburguer: pao='Brioche , carne='Angus }", atendimento.realizarAtendimento());
    }

    @Test
    void deveRealizarPedidoDeliveryDinheiroSemIngrediente() {
        Hamburguer base = new HamburguerBase("Sesamo", "Smash");
        Atendimento atendimento = new Atendimento(new FabricaDeliveryDinheiro(), 80.0, base);
        assertEquals("Pedido delivery: Pago via Dinheiro: R$80.0 | Hamburguer: pao='Sesamo , carne='Smash }", atendimento.realizarAtendimento());
    }

    @Test
    void deveRealizarPedidoLocalPixComQueijo() {
        Hamburguer base = new HamburguerBase("Brioche", "Angus");
        Hamburguer comQueijo = new IngredienteQueijo(base);
        Atendimento atendimento = new Atendimento(new FabricaLocalPix(), 50.0, comQueijo);
        assertEquals("Pedido local: Pago via PIX: R$50.0 | Hamburguer: pao='Brioche , carne='Angus } + queijo", atendimento.realizarAtendimento());
    }

    @Test
    void deveRealizarPedidoDeliveryDinheiroComQueijo() {
        Hamburguer base = new HamburguerBase("Sesamo", "Smash");
        Hamburguer comQueijo = new IngredienteQueijo(base);
        Atendimento atendimento = new Atendimento(new FabricaDeliveryDinheiro(), 80.0, comQueijo);
        assertEquals("Pedido delivery: Pago via Dinheiro: R$80.0 | Hamburguer: pao='Sesamo , carne='Smash } + queijo", atendimento.realizarAtendimento());
    }

    @Test
    void deveRealizarPedidoLocalPixComAlface() {
        Hamburguer base = new HamburguerBase("Brioche", "Angus");
        Hamburguer comAlface = new IngredienteAlface(base);
        Atendimento atendimento = new Atendimento(new FabricaLocalPix(), 50.0, comAlface);
        assertEquals("Pedido local: Pago via PIX: R$50.0 | Hamburguer: pao='Brioche , carne='Angus } + alface", atendimento.realizarAtendimento());
    }

    @Test
    void deveRealizarPedidoDeliveryDinheiroComAlface() {
        Hamburguer base = new HamburguerBase("Sesamo", "Smash");
        Hamburguer comAlface = new IngredienteAlface(base);
        Atendimento atendimento = new Atendimento(new FabricaDeliveryDinheiro(), 80.0, comAlface);
        assertEquals("Pedido delivery: Pago via Dinheiro: R$80.0 | Hamburguer: pao='Sesamo , carne='Smash } + alface", atendimento.realizarAtendimento());
    }

    @Test
    void deveRealizarPedidoLocalPixComTomate() {
        Hamburguer base = new HamburguerBase("Brioche", "Angus");
        Hamburguer comTomate = new IngredienteTomate(base);
        Atendimento atendimento = new Atendimento(new FabricaLocalPix(), 50.0, comTomate);
        assertEquals("Pedido local: Pago via PIX: R$50.0 | Hamburguer: pao='Brioche , carne='Angus } + tomate", atendimento.realizarAtendimento());
    }

    @Test
    void deveRealizarPedidoDeliveryDinheiroComTomate() {
        Hamburguer base = new HamburguerBase("Sesamo", "Smash");
        Hamburguer comTomate = new IngredienteTomate(base);
        Atendimento atendimento = new Atendimento(new FabricaDeliveryDinheiro(), 80.0, comTomate);
        assertEquals("Pedido delivery: Pago via Dinheiro: R$80.0 | Hamburguer: pao='Sesamo , carne='Smash } + tomate", atendimento.realizarAtendimento());
    }

    @Test
    void deveRealizarPedidoLocalPixComQueijoEAlface() {
        Hamburguer base = new HamburguerBase("Brioche", "Angus");
        Hamburguer comIngredientes = new IngredienteAlface(new IngredienteQueijo(base));
        Atendimento atendimento = new Atendimento(new FabricaLocalPix(), 50.0, comIngredientes);
        assertEquals("Pedido local: Pago via PIX: R$50.0 | Hamburguer: pao='Brioche , carne='Angus } + queijo + alface", atendimento.realizarAtendimento());
    }

    @Test
    void deveRealizarPedidoDeliveryDinheiroComQueijoEAlface() {
        Hamburguer base = new HamburguerBase("Sesamo", "Smash");
        Hamburguer comIngredientes = new IngredienteAlface(new IngredienteQueijo(base));
        Atendimento atendimento = new Atendimento(new FabricaDeliveryDinheiro(), 80.0, comIngredientes);
        assertEquals("Pedido delivery: Pago via Dinheiro: R$80.0 | Hamburguer: pao='Sesamo , carne='Smash } + queijo + alface", atendimento.realizarAtendimento());
    }

    @Test
    void deveRealizarPedidoLocalPixComQueijoETomate() {
        Hamburguer base = new HamburguerBase("Brioche", "Angus");
        Hamburguer comIngredientes = new IngredienteTomate(new IngredienteQueijo(base));
        Atendimento atendimento = new Atendimento(new FabricaLocalPix(), 50.0, comIngredientes);
        assertEquals("Pedido local: Pago via PIX: R$50.0 | Hamburguer: pao='Brioche , carne='Angus } + queijo + tomate", atendimento.realizarAtendimento());
    }

    @Test
    void deveRealizarPedidoDeliveryDinheiroComQueijoETomate() {
        Hamburguer base = new HamburguerBase("Sesamo", "Smash");
        Hamburguer comIngredientes = new IngredienteTomate(new IngredienteQueijo(base));
        Atendimento atendimento = new Atendimento(new FabricaDeliveryDinheiro(), 80.0, comIngredientes);
        assertEquals("Pedido delivery: Pago via Dinheiro: R$80.0 | Hamburguer: pao='Sesamo , carne='Smash } + queijo + tomate", atendimento.realizarAtendimento());
    }

    @Test
    void deveRealizarPedidoLocalPixComAlfaceETomate() {
        Hamburguer base = new HamburguerBase("Brioche", "Angus");
        Hamburguer comIngredientes = new IngredienteTomate(new IngredienteAlface(base));
        Atendimento atendimento = new Atendimento(new FabricaLocalPix(), 50.0, comIngredientes);
        assertEquals("Pedido local: Pago via PIX: R$50.0 | Hamburguer: pao='Brioche , carne='Angus } + alface + tomate", atendimento.realizarAtendimento());
    }

    @Test
    void deveRealizarPedidoDeliveryDinheiroComAlfaceETomate() {
        Hamburguer base = new HamburguerBase("Sesamo", "Smash");
        Hamburguer comIngredientes = new IngredienteTomate(new IngredienteAlface(base));
        Atendimento atendimento = new Atendimento(new FabricaDeliveryDinheiro(), 80.0, comIngredientes);
        assertEquals("Pedido delivery: Pago via Dinheiro: R$80.0 | Hamburguer: pao='Sesamo , carne='Smash } + alface + tomate", atendimento.realizarAtendimento());
    }

    @Test
    void deveRealizarPedidoLocalPixComTodosIngredientes() {
        Hamburguer base = new HamburguerBase("Brioche", "Angus");
        Hamburguer comTudo = new IngredienteTomate(new IngredienteAlface(new IngredienteQueijo(base)));
        Atendimento atendimento = new Atendimento(new FabricaLocalPix(), 50.0, comTudo);
        assertEquals("Pedido local: Pago via PIX: R$50.0 | Hamburguer: pao='Brioche , carne='Angus } + queijo + alface + tomate", atendimento.realizarAtendimento());
    }

    @Test
    void deveRealizarPedidoDeliveryDinheiroComTodosIngredientes() {
        Hamburguer base = new HamburguerBase("Sesamo", "Smash");
        Hamburguer comTudo = new IngredienteTomate(new IngredienteAlface(new IngredienteQueijo(base)));
        Atendimento atendimento = new Atendimento(new FabricaDeliveryDinheiro(), 80.0, comTudo);
        assertEquals("Pedido delivery: Pago via Dinheiro: R$80.0 | Hamburguer: pao='Sesamo , carne='Smash } + queijo + alface + tomate", atendimento.realizarAtendimento());
    }
}