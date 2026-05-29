package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FilaPedidos implements Iterable<Pedido> {

    private List<Pedido> pedidos = new ArrayList<>();

    public FilaPedidos(Pedido... pedidos) {
        this.pedidos = Arrays.asList(pedidos);
    }

    @Override
    public Iterator<Pedido> iterator() {
        return pedidos.iterator();
    }
}