package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CardapioTest {

    @Test
    void deveRetornarCardapio() {
        Categoria hamburgueres = new Categoria("Hambúrgueres");
        Produto artesanal = new Produto(
                FabricaArtesanal.getInstance().createHamburguerBase(new Carne200g()), 35.0f);
        Produto smash = new Produto(
                FabricaSmash.getInstance().createHamburguerBase(new Carne100g()), 28.0f);
        hamburgueres.addItem(artesanal);
        hamburgueres.addItem(smash);

        Cardapio cardapio = new Cardapio();
        cardapio.setProduto(hamburgueres);

        assertEquals("Categoria: Hambúrgueres\n" +
                "Produto: " + artesanal.getDescricao() + " - preço: R$35.0\n" +
                "Produto: " + smash.getDescricao() + " - preço: R$28.0\n", cardapio.getProduto());
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

    @Test
    void deveExibirProduto() {
        Produto produto = new Produto(
                FabricaArtesanal.getInstance().createHamburguerBase(new Carne200g()), 35.0f);

        CardapioExibidorVisitor visitor = new CardapioExibidorVisitor();
        assertEquals("Produto{descricao='" + produto.getDescricao() + "', preco=35.0}", visitor.exibir(produto));
    }

    @Test
    void deveExibirCategoria() {
        Categoria categoria = new Categoria("Hambúrgueres");

        CardapioExibidorVisitor visitor = new CardapioExibidorVisitor();
        assertEquals("Categoria{descricao='Hambúrgueres'}", visitor.exibir(categoria));
    }
}