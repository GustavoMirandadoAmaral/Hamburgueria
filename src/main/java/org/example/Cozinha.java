package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cozinha {

    private List<Pedido> pedidosEmPreparo = new ArrayList<>();

    public void registrarPedido(Pedido pedido) {
        pedidosEmPreparo.add(pedido);
    }

    public List<String> prepararTodos() {
        List<String> saida = new ArrayList<>();
        for (Pedido pedido : pedidosEmPreparo) {
            saida.add(pedido.getHamburguer().prepararHamburguer());
            pedido.preparar();
        }
        return saida;
    }
}