package org.example;

import java.util.Observable;

public class Pedido extends Observable implements Cloneable {

    private Hamburguer hamburguer;
    private PedidoEstado estado;
    private float valorAPagar;

    public Hamburguer getHamburguer() {
        return hamburguer;
    }

    public Pedido() {
        this.hamburguer = null;
        this.valorAPagar = 0;
        this.estado = PedidoEstadoAceito.getInstance();
    }

    public void setHamburguer(Hamburguer hamburguer) {
        this.hamburguer = hamburguer;
    }

    public void setValorAPagar(float valorAPagar) {
        this.valorAPagar = valorAPagar;
    }

    public float getValorAPagar() {
        return valorAPagar;
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
        this.atualizarEstado();
    }

    public boolean aceitar() {
        return estado.aceitar(this);
    }

    public boolean preparar() {
        return estado.preparar(this);
    }

    public boolean pronto() {
        return estado.pronto(this);
    }

    public boolean enviarParaRota() {
        return estado.enviarParaRota(this);
    }

    public boolean entregar() {
        return estado.entregar(this);
    }

    public boolean cancelar() {
        return estado.cancelar(this);
    }

    public boolean devolver() {
        return estado.devolver(this);
    }

    public PedidoEstado getEstado(){return estado;}

    public void atualizarEstado() {
        estado.lancarAtualizacao(this);
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Status atual do Pedido: " + estado.getEstado();
    }

    @Override
    public Pedido clone() throws CloneNotSupportedException {
        return (Pedido) super.clone();
    }

    private String pagar(FormaPagamento formaPagamento) {
        return formaPagamento.pagar(valorAPagar);
    }

    public String pagarComPix() {
        return pagar(new FormaPagamentoPix());
    }

    public String pagarComCartao() {
        return pagar(new FormaPagamentoCartao());
    }

    public String pagarComDinheiro() {
        return pagar(new FormaPagamentoDinheiro());
    }
}
