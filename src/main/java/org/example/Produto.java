package org.example;

public class Produto extends ItemCardapio {

    private float preco;

    public Produto(Hamburguer hamburguer, float preco) {
        super(hamburguer.getHamburguerCompleto());
        this.preco = preco;
    }

    public float getPreco() {
        return preco;
    }

    public String getItemCardapio() {
        return "Produto: " + this.getDescricao() + " - preço: R$" + this.preco + "\n";
    }

    public String aceitar(CardapioVisitor visitor) {
        return visitor.exibirProduto(this);
    }
}