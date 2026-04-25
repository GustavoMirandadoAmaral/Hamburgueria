package org.example;

public class Pix implements PlataformaPagamento {
    public String processarPagamento(double valor) {
        return "Pago via PIX: R$" + valor;
    }
}