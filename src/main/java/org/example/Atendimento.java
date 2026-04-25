package org.example;

public class Atendimento {
    private Pedido pedido;
    private PlataformaPagamento pagamento;
    private Hamburguer hamburguer;

    public Atendimento(FabricaAbstrata fabrica, double valor, Hamburguer hamburguer) {
        this.pedido = fabrica.createPedido(valor);
        this.pagamento = fabrica.createPagamento();
        this.pedido.setPlataformaPagamento(this.pagamento);
        this.hamburguer = hamburguer;
    }

    public String realizarAtendimento() {
        return this.pedido.realizarPedido() + " | " + this.hamburguer.getHamburguerCompleto();
    }
}
