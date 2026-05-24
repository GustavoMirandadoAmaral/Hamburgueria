package org.example;

public class Produto extends ItemCardapio {

    private float preco;

    public Produto(String descricao, float preco) {
        super(descricao);
        this.preco = preco;
    }

    public String getItemCardapio() {
        return "Produto: " + this.getDescricao() + " - preço: R$" + this.preco + "\n";
    }
}