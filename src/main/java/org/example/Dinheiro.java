package org.example;

public class Dinheiro implements PlataformaPagamento {
    public String processarPagamento(double valor) {
        return "Pago via Dinheiro: R$" + valor;
    }
}