package org.example;

public class RemoverProdutoTarefa implements TarefaCardapio {

    private Categoria categoria;
    private Produto produto;

    public RemoverProdutoTarefa(Categoria categoria, Produto produto) {
        this.categoria = categoria;
        this.produto = produto;
    }

    public void executar() {
        this.categoria.removeItem(produto);
    }

    public void cancelar() {
        this.categoria.addItem(produto);
    }
}