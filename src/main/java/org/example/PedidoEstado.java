package org.example;

import java.util.Observable;
import java.util.Observer;

public abstract class PedidoEstado implements Observer {
    
    public abstract String getEstado();
    private String notificacaoAtualizacao;

    public String getNotificacaoAtualizacao() {
        return this.notificacaoAtualizacao;
    }

    public boolean aceitar(Pedido pedido) {
        return false;
    }

    public boolean preparar(Pedido pedido) {
        return false;
    }

    public boolean pronto(Pedido pedido) {
        return false;
    }

    public boolean enviarParaRota(Pedido pedido) {
        return false;
    }

    public boolean entregar(Pedido pedido) {
        return false;
    }

    public boolean cancelar(Pedido pedido) {
        return false;
    }

    public boolean devolver(Pedido pedido) {
        return false;
    }

    public void lancarAtualizacao(Pedido pedido) {
        pedido.addObserver(this);
    }

    public void update(Observable pedido, Object arg1) {
        this.notificacaoAtualizacao = "Atualização do pedido: \n" + pedido.toString();
    }
}
