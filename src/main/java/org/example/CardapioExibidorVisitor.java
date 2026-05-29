package org.example;

public class CardapioExibidorVisitor implements CardapioVisitor {

    public String exibir(ItemCardapio item) {
        return item.aceitar(this);
    }

    @Override
    public String exibirProduto(Produto produto) {
        return "Produto{" +
                "descricao='" + produto.getDescricao() + '\'' +
                ", preco=" + produto.getPreco() +
                '}';
    }

    @Override
    public String exibirCategoria(Categoria categoria) {
        return "Categoria{" +
                "descricao='" + categoria.getDescricao() + '\'' +
                '}';
    }
}