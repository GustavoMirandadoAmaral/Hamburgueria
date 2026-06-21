package org.example;

public class MaquinaCartaoAdapter extends MaquinaCartao {

    private FormaPagamento formaPagamento;

    public MaquinaCartaoAdapter(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String recuperarPagamento(float valor) {
        if (this.getCodigoStatus() == 0) {
            return formaPagamento.pagar(valor);
        } else {
            return "Falha no pagamento: código " + getCodigoStatus();
        }
    }

    public void registrarTransacao(float valor) {
        this.setCodigoStatus(0);
    }
}