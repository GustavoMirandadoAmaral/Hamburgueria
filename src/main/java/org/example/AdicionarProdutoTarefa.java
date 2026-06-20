package org.example;

public class AdicionarProdutoTarefa implements TarefaCardapio {

    private Categoria categoria;
    private Produto produto;

    public AdicionarProdutoTarefa(Categoria categoria, Produto produto) {
        this.categoria = categoria;
        this.produto = produto;
    }

    public void executar() {
        this.categoria.addItem(produto);
    }

    public void cancelar() {
        this.categoria.removeItem(produto);
    }
}