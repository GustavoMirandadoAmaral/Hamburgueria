package org.example;

import java.util.Observable;

public abstract class Pedido extends Observable {

    protected PlataformaPagamento plataformaPagamento;
    protected double valor;
    private PedidoEstado estado;

    public Pedido(double valor) {
        this.valor = valor;
        this.estado = PedidoEstadoAceito.getInstance();
    }

    public void setPlataformaPagamento(PlataformaPagamento plataformaPagamento) {
        this.plataformaPagamento = plataformaPagamento;
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
        this.atualizarEstado();
    }

    public abstract String realizarPedido();

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
}
