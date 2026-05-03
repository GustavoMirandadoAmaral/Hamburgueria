package org.example;

public class FormaPagamentoPix implements FormaPagamento{

    public String pagar(float valorAPagar){
        return "Pagamento via Pix de R$" + valorAPagar + " com 5% de desconto: R$" + (valorAPagar * 0.95f);
    }
}
