package org.example;

public class FormaPagamentoCartao implements FormaPagamento {

    public String pagar(float valorAPagar) {
        float valorComTaxa = Math.round(valorAPagar * 1.03f * 100) / 100.0f;
        return "Pagamento via Cartão de R$" + valorAPagar + " com 3% de taxa: R$" + valorComTaxa;
    }
}