package org.example;

public class FormaPagamentoCartao implements FormaPagamento{

    public String pagar(float valorAPagar){
        return "Pagamento via Cartão de R$" + valorAPagar + " com 3% de taxa: R$" + (valorAPagar * 1.03f);
    }
}
