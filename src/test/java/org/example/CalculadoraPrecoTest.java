package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraPrecoTest {

    @Test
    void deveCalcularExpressaoComFormulaHamburguerArtesanal() {
        Produto produto = new Produto(
                FabricaArtesanal.getInstance().createHamburguerBase(CarneFactory.getCarne("200g")), 35.0f);

        assertEquals(42.5f, produto.getPrecoComTaxa(5.0f));
    }

    @Test
    void deveCalcularExpressaoComFormulaHamburguerSmash() {
        Produto produto = new Produto(
                FabricaSmash.getInstance().createHamburguerBase(CarneFactory.getCarne("100g")), 28.0f);

        assertEquals(34.0f, produto.getPrecoComTaxa(4.0f));
    }
}