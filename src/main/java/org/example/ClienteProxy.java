package org.example;

import java.util.List;

public class ClienteProxy {

    private Cliente clienteReal;
    private boolean autenticado;

    public ClienteProxy(Cliente clienteReal, boolean autenticado) {
        this.clienteReal = clienteReal;
        this.autenticado = autenticado;
    }

    public List<Pedido> getHistoricoPedidos() {
        if (!autenticado) {
            throw new IllegalArgumentException("Cliente não autenticado");
        }
        return clienteReal.getHistoricoPedidos();
    }

    public Pedido restaurarPedido(int indice) {
        if (!autenticado) {
            throw new IllegalArgumentException("Cliente não autenticado");
        }
        return clienteReal.restaurarPedido(indice);
    }

    public Pedido repetirPedido(int indice) throws CloneNotSupportedException {
        if (!autenticado) {
            throw new IllegalArgumentException("Cliente não autenticado");
        }
        return clienteReal.repetirPedido(indice);
    }
}