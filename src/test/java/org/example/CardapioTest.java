package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CardapioTest {

    @Test
    void deveRetornarCardapio() {
        Categoria hamburgueres = new Categoria("Hambúrgueres");
        Produto artesanal = new Produto("Hamburguer Artesanal", 35.0f);
        Produto smash = new Produto("Hamburguer Smash", 28.0f);
        hamburgueres.addItem(artesanal);
        hamburgueres.addItem(smash);

        Categoria bebidas = new Categoria("Bebidas");
        Produto refrigerante = new Produto("Refrigerante", 8.0f);
        Produto suco = new Produto("Suco", 10.0f);
        bebidas.addItem(refrigerante);
        bebidas.addItem(suco);

        Categoria acompanhamentos = new Categoria("Acompanhamentos");
        Produto fritas = new Produto("Fritas", 12.0f);
        acompanhamentos.addItem(fritas);

        Categoria cardapioCompleto = new Categoria("Cardápio da Hamburgueria");
        cardapioCompleto.addItem(hamburgueres);
        cardapioCompleto.addItem(bebidas);
        cardapioCompleto.addItem(acompanhamentos);

        Cardapio cardapio = new Cardapio();
        cardapio.setProduto(cardapioCompleto);

        assertEquals("Categoria: Cardápio da Hamburgueria\n" +
                "Categoria: Hambúrgueres\n" +
                "Produto: Hamburguer Artesanal - preço: R$35.0\n" +
                "Produto: Hamburguer Smash - preço: R$28.0\n" +
                "Categoria: Bebidas\n" +
                "Produto: Refrigerante - preço: R$8.0\n" +
                "Produto: Suco - preço: R$10.0\n" +
                "Categoria: Acompanhamentos\n" +
                "Produto: Fritas - preço: R$12.0\n", cardapio.getProduto());
    }

    @Test
    void deveRetornarExcecaoCardapioSemProduto() {
        try {
            Cardapio cardapio = new Cardapio();
            cardapio.getProduto();
            fail();
        }
        catch (NullPointerException e) {
            assertEquals("Cardápio sem produtos", e.getMessage());
        }
    }
}