package org.example;

public class FormaPagamentoDinheiro implements FormaPagamento {

    public String pagar(float valorAPagar){
        return "Pagamento via Dinheiro de R$" + valorAPagar;
    }
}
