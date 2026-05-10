package org.example;

public class Cardapio {

    private ItemCardapio produto;

    public void setProduto(ItemCardapio produto) {
        this.produto = produto;
    }

    public String getProduto() {
        if (this.produto == null) {
            throw new NullPointerException("Cardápio sem produtos");
        }
        return this.produto.getItemCardapio();
    }
}
