package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GerenciadorCardapioTest {

    GerenciadorCardapio gerenciadorCardapio;
    Categoria categoria;
    Produto produto1;
    Produto produto2;

    @BeforeEach
    void setUp() {
        gerenciadorCardapio = new GerenciadorCardapio();
        categoria = new Categoria("Hambúrgueres");
        produto1 = gerenciadorCardapio.criarProdutoArtesanal(CarneFactory.getCarne("200g"), 35.0f);
        produto2 = gerenciadorCardapio.criarProdutoSmash(CarneFactory.getCarne("100g"), 28.0f);

    }

    @Test
    void deveAdicionarProdutoArtesanal() {
        TarefaCardapio adicionarProduto = new AdicionarProdutoTarefa(categoria, produto1);
        gerenciadorCardapio.executarTarefa(adicionarProduto);

        assertTrue(categoria.getItemCardapio().contains(produto1.getDescricao()));
    }

    @Test
    void deveAdicionarProdutoSmash() {
        TarefaCardapio adicionarProduto = new AdicionarProdutoTarefa(categoria, produto2);
        gerenciadorCardapio.executarTarefa(adicionarProduto);

        assertTrue(categoria.getItemCardapio().contains(produto2.getDescricao()));
    }

    @Test
    void deveRemoverProduto() {
        categoria.addItem(produto1);
        TarefaCardapio removerProduto = new RemoverProdutoTarefa(categoria, produto1);
        gerenciadorCardapio.executarTarefa(removerProduto);

        assertFalse(categoria.getItemCardapio().contains(produto1.getDescricao()));
    }

    @Test
    void deveCancelarRemocaoProduto() {
        categoria.addItem(produto1);
        TarefaCardapio removerProduto = new RemoverProdutoTarefa(categoria, produto1);

        gerenciadorCardapio.executarTarefa(removerProduto);
        gerenciadorCardapio.cancelarUltimaTarefa();

        assertTrue(categoria.getItemCardapio().contains(produto1.getDescricao()));
    }
}