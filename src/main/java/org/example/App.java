package org.example;

public class App {
    private static App instancia = new App();
    private App() {}
    public static App getInstance() { return instancia; }

    private Cozinha cozinha = new Cozinha();

    public String receberPedidoRecepcionista(Pedido pedido) {
        FuncionarioGerente gerente = new FuncionarioGerente(null);
        FuncionarioRecepcionista recepcionista = new FuncionarioRecepcionista(gerente);
        cozinha.registrarPedido(pedido);
        return "O App agradece seu contato.\n" +
                "O Recepcionista respondeu sua demanda conforme mensagem a seguir.\n" +
                ">>" + recepcionista.realizarAcao(new Acao(PedidoEstadoAceito.getInstance()));
    }
}