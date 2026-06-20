package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GerenciadorCardapioTest {

    GerenciadorCardapio gerenciadorCardapio;
    Categoria categoria;
    Produto produto;

    @BeforeEach
    void setUp() {
        gerenciadorCardapio = new GerenciadorCardapio();
        categoria = new Categoria("Hambúrgueres");
        produto = gerenciadorCardapio.criarProdutoArtesanal(new Carne200g(), 35.0f);
    }

    @Test
    void deveAdicionarProduto() {
        TarefaCardapio adicionarProduto = new AdicionarProdutoTarefa(categoria, produto);
        gerenciadorCardapio.executarTarefa(adicionarProduto);

        assertTrue(categoria.getItemCardapio().contains(produto.getDescricao()));
    }

    @Test
    void deveRemoverProduto() {
        categoria.addItem(produto);
        TarefaCardapio removerProduto = new RemoverProdutoTarefa(categoria, produto);
        gerenciadorCardapio.executarTarefa(removerProduto);

        assertFalse(categoria.getItemCardapio().contains(produto.getDescricao()));
    }

    @Test
    void deveCancelarRemocaoProduto() {
        categoria.addItem(produto);
        TarefaCardapio removerProduto = new RemoverProdutoTarefa(categoria, produto);

        gerenciadorCardapio.executarTarefa(removerProduto);
        gerenciadorCardapio.cancelarUltimaTarefa();

        assertTrue(categoria.getItemCardapio().contains(produto.getDescricao()));
    }
}