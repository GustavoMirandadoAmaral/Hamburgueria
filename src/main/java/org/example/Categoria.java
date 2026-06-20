package org.example;

import java.util.ArrayList;
import java.util.List;

public class Categoria extends ItemCardapio{

    private List<ItemCardapio> itens;

    public Categoria(String descricao) {
        super(descricao);
        this.itens = new ArrayList<ItemCardapio>();
    }

    public void addItem(ItemCardapio item) {
        this.itens.add(item);
    }

    public void removeItem(ItemCardapio item) {
        this.itens.remove(item);
    }

    public String getItemCardapio() {
        String saida = "";
        saida = "Categoria: " + this.getDescricao() + "\n";
        for (ItemCardapio item : itens) {
            saida += item.getItemCardapio();
        }
        return saida;
    }

    public String aceitar(CardapioVisitor visitor) {
        return visitor.exibirCategoria(this);
    }
}
