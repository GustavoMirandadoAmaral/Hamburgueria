package org.example;

public class FormaPagamentoPix implements FormaPagamento{

    public String pagar(float valorAPagar) {
        float valorComDesconto = Math.round(valorAPagar * 0.95f * 100) / 100.0f;
        return "Pagamento via Pix de R$" + valorAPagar + " com 5% de desconto: R$" + valorComDesconto;
    }
}
