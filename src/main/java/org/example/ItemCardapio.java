package org.example;

public abstract class ItemCardapio {

    private String descricao;

    public ItemCardapio(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public abstract String getItemCardapio();
}
