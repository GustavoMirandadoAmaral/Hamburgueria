package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    Pedido pedido;
    FuncionarioRecepcionista recepcionista;
    FuncionarioGerente gerente;

    private Pedido criarPedidoArtesanal() {
        return new PedidoBuilder()
                .setHamburguer(FabricaArtesanal.getInstance().createHamburguerBase(new Carne200g()))
                .setValorAPagar(50.0f)
                .build();
    }

    private Pedido criarPedidoSmash() {
        return new PedidoBuilder()
                .setHamburguer(FabricaSmash.getInstance().createHamburguerBase(new Carne100g()))
                .setValorAPagar(40.0f)
                .build();
    }

    @BeforeEach
    public void setUp() {
        //pedido para testes
        pedido = criarPedidoArtesanal();

        //funcionarios para testes
        gerente = new FuncionarioGerente(null);
        recepcionista = new FuncionarioRecepcionista(gerente);
    }

    // Estado Aceito
    @Test
    public void naoDeveAceitarPedidoAceito() {
        pedido.setEstado(PedidoEstadoAceito.getInstance());
        assertFalse(pedido.aceitar());
    }

    @Test
    public void devePrepararPedidoAceito() {
        pedido.setEstado(PedidoEstadoAceito.getInstance());
        assertTrue(pedido.preparar());
        assertEquals(PedidoEstadoPreparando.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveProntoPedidoAceito() {
        pedido.setEstado(PedidoEstadoAceito.getInstance());
        assertFalse(pedido.pronto());
    }

    @Test
    public void naoDeveEnviarParaRotaPedidoAceito() {
        pedido.setEstado(PedidoEstadoAceito.getInstance());
        assertFalse(pedido.enviarParaRota());
    }

    @Test
    public void naoDeveEntregarPedidoAceito() {
        pedido.setEstado(PedidoEstadoAceito.getInstance());
        assertFalse(pedido.entregar());
    }

    @Test
    public void deveCancelarPedidoAceito() {
        pedido.setEstado(PedidoEstadoAceito.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveDevolverPedidoAceito() {
        pedido.setEstado(PedidoEstadoAceito.getInstance());
        assertFalse(pedido.devolver());
    }

    // Estado Preparando
    @Test
    public void naoDeveAceitarPedidoPreparando() {
        pedido.setEstado(PedidoEstadoPreparando.getInstance());
        assertFalse(pedido.aceitar());
    }

    @Test
    public void naoDevePrepararPedidoPreparando() {
        pedido.setEstado(PedidoEstadoPreparando.getInstance());
        assertFalse(pedido.preparar());
    }

    @Test
    public void deveProntoPedidoPreparando() {
        pedido.setEstado(PedidoEstadoPreparando.getInstance());
        assertTrue(pedido.pronto());
        assertEquals(PedidoEstadoPronto.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveEnviarParaRotaPedidoPreparando() {
        pedido.setEstado(PedidoEstadoPreparando.getInstance());
        assertFalse(pedido.enviarParaRota());
    }

    @Test
    public void naoDeveEntregarPedidoPreparando() {
        pedido.setEstado(PedidoEstadoPreparando.getInstance());
        assertFalse(pedido.entregar());
    }

    @Test
    public void deveCancelarPedidoPreparando() {
        pedido.setEstado(PedidoEstadoPreparando.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveDevolverPedidoPreparando() {
        pedido.setEstado(PedidoEstadoPreparando.getInstance());
        assertFalse(pedido.devolver());
    }

    // Estado Pronto
    @Test
    public void naoDeveAceitarPedidoPronto() {
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        assertFalse(pedido.aceitar());
    }

    @Test
    public void naoDevePrepararPedidoPronto() {
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        assertFalse(pedido.preparar());
    }

    @Test
    public void naoDeveProntoPedidoPronto() {
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        assertFalse(pedido.pronto());
    }

    @Test
    public void deveEnviarParaRotaPedidoPronto() {
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        assertTrue(pedido.enviarParaRota());
        assertEquals(PedidoEstadoEmRota.getInstance(), pedido.getEstado());
    }

    @Test
    public void deveEntregarPedidoPronto() {
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        assertTrue(pedido.entregar());
        assertEquals(PedidoEstadoEntregue.getInstance(), pedido.getEstado());
    }

    @Test
    public void deveCancelarPedidoPronto() {
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveDevolverPedidoPronto() {
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        assertFalse(pedido.devolver());
    }

    // Estado EmRota
    @Test
    public void naoDeveAceitarPedidoEmRota() {
        pedido.setEstado(PedidoEstadoEmRota.getInstance());
        assertFalse(pedido.aceitar());
    }

    @Test
    public void naoDevePrepararPedidoEmRota() {
        pedido.setEstado(PedidoEstadoEmRota.getInstance());
        assertFalse(pedido.preparar());
    }

    @Test
    public void naoDeveProntoPedidoEmRota() {
        pedido.setEstado(PedidoEstadoEmRota.getInstance());
        assertFalse(pedido.pronto());
    }

    @Test
    public void naoDeveEnviarParaRotaPedidoEmRota() {
        pedido.setEstado(PedidoEstadoEmRota.getInstance());
        assertFalse(pedido.enviarParaRota());
    }

    @Test
    public void deveEntregarPedidoEmRota() {
        pedido.setEstado(PedidoEstadoEmRota.getInstance());
        assertTrue(pedido.entregar());
        assertEquals(PedidoEstadoEntregue.getInstance(), pedido.getEstado());
    }

    @Test
    public void deveCancelarPedidoEmRota() {
        pedido.setEstado(PedidoEstadoEmRota.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveDevolverPedidoEmRota() {
        pedido.setEstado(PedidoEstadoEmRota.getInstance());
        assertFalse(pedido.devolver());
    }

    // Estado Entregue
    @Test
    public void naoDeveAceitarPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.aceitar());
    }

    @Test
    public void naoDevePrepararPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.preparar());
    }

    @Test
    public void naoDeveProntoPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.pronto());
    }

    @Test
    public void naoDeveEnviarParaRotaPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.enviarParaRota());
    }

    @Test
    public void naoDeveEntregarPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.entregar());
    }

    @Test
    public void naoDeveCancelarPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.cancelar());
    }

    @Test
    public void deveDevolverPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertTrue(pedido.devolver());
        assertEquals(PedidoEstadoDevolvido.getInstance(), pedido.getEstado());
    }

    // Estado Cancelado
    @Test
    public void naoDeveAceitarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.aceitar());
    }

    @Test
    public void naoDevePrepararPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.preparar());
    }

    @Test
    public void naoDeveProntoPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.pronto());
    }

    @Test
    public void naoDeveEnviarParaRotaPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.enviarParaRota());
    }

    @Test
    public void naoDeveEntregarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.entregar());
    }

    @Test
    public void naoDeveCancelarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.cancelar());
    }

    @Test
    public void naoDeveDevolverPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.devolver());
    }

    // Estado Devolvido
    @Test
    public void naoDeveAceitarPedidoDevolvido() {
        pedido.setEstado(PedidoEstadoDevolvido.getInstance());
        assertFalse(pedido.aceitar());
    }

    @Test
    public void naoDevePrepararPedidoDevolvido() {
        pedido.setEstado(PedidoEstadoDevolvido.getInstance());
        assertFalse(pedido.preparar());
    }

    @Test
    public void naoDeveProntoPedidoDevolvido() {
        pedido.setEstado(PedidoEstadoDevolvido.getInstance());
        assertFalse(pedido.pronto());
    }

    @Test
    public void naoDeveEnviarParaRotaPedidoDevolvido() {
        pedido.setEstado(PedidoEstadoDevolvido.getInstance());
        assertFalse(pedido.enviarParaRota());
    }

    @Test
    public void naoDeveEntregarPedidoDevolvido() {
        pedido.setEstado(PedidoEstadoDevolvido.getInstance());
        assertFalse(pedido.entregar());
    }

    @Test
    public void deveCancelarPedidoDevolvido() {
        pedido.setEstado(PedidoEstadoDevolvido.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveDevolverPedidoDevolvido() {
        pedido.setEstado(PedidoEstadoDevolvido.getInstance());
        assertFalse(pedido.devolver());
    }

    //Notificações
    @Test
    void deveNotificarAtualizacaoDeAceitoParaEmPreparacao() {
        pedido.setEstado(PedidoEstadoAceito.getInstance());
        assertTrue(pedido.preparar());
        pedido.atualizarEstado();
        assertEquals("Atualização do pedido: \n" + "Status atual do Pedido: Pedido está sendo preparado!!",pedido.getEstado().getNotificacaoAtualizacao());
    }

    @Test
    void deveNotificarAtualizacaoDeAceitoParaCancelado() {
        pedido.setEstado(PedidoEstadoAceito.getInstance());
        assertTrue(pedido.cancelar());
        pedido.atualizarEstado();
        assertEquals("Atualização do pedido: \n" + "Status atual do Pedido: Pedido cancelado!!",pedido.getEstado().getNotificacaoAtualizacao());
    }

    @Test
    void deveNotificarAtualizacaoDeEmPreparacaoParaPronto() {
        pedido.setEstado(PedidoEstadoPreparando.getInstance());
        assertTrue(pedido.pronto());
        pedido.atualizarEstado();
        assertEquals("Atualização do pedido: \n" + "Status atual do Pedido: Pedido está pronto!!",pedido.getEstado().getNotificacaoAtualizacao());
    }

    @Test
    void deveNotificarAtualizacaoDeEmPreparacaoParaCancelado() {
        pedido.setEstado(PedidoEstadoPreparando.getInstance());
        assertTrue(pedido.cancelar());
        pedido.atualizarEstado();
        assertEquals("Atualização do pedido: \n" + "Status atual do Pedido: Pedido cancelado!!",pedido.getEstado().getNotificacaoAtualizacao());
    }

    @Test
    void deveNotificarAtualizacaoDeProntoParaEmRota() {
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        assertTrue(pedido.enviarParaRota());
        pedido.atualizarEstado();
        assertEquals("Atualização do pedido: \n" + "Status atual do Pedido: Pedido saiu para a rota de entrega!!",pedido.getEstado().getNotificacaoAtualizacao());
    }

    @Test
    void deveNotificarAtualizacaoDeProntoParaCancelado() {
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        assertTrue(pedido.cancelar());
        pedido.atualizarEstado();
        assertEquals("Atualização do pedido: \n" + "Status atual do Pedido: Pedido cancelado!!",pedido.getEstado().getNotificacaoAtualizacao());
    }

    @Test
    void deveNotificarAtualizacaoDeProntoParaEntregue() {
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        assertTrue(pedido.entregar());
        pedido.atualizarEstado();
        assertEquals("Atualização do pedido: \n" + "Status atual do Pedido: Pedido foi entregue com sucesso!!",pedido.getEstado().getNotificacaoAtualizacao());
    }

    @Test
    void deveNotificarAtualizacaoDeEmRotaParaCancelado() {
        pedido.setEstado(PedidoEstadoEmRota.getInstance());
        assertTrue(pedido.cancelar());
        pedido.atualizarEstado();
        assertEquals("Atualização do pedido: \n" + "Status atual do Pedido: Pedido cancelado!!",pedido.getEstado().getNotificacaoAtualizacao());
    }

    @Test
    void deveNotificarAtualizacaoDeEmRotaParaEntregue() {
        pedido.setEstado(PedidoEstadoEmRota.getInstance());
        assertTrue(pedido.entregar());
        pedido.atualizarEstado();
        assertEquals("Atualização do pedido: \n" + "Status atual do Pedido: Pedido foi entregue com sucesso!!",pedido.getEstado().getNotificacaoAtualizacao());
    }

    @Test
    void deveNotificarAtualizacaoDeDevolucaoParaCancelado() {
        pedido.setEstado(PedidoEstadoDevolvido.getInstance());
        assertTrue(pedido.cancelar());
        pedido.atualizarEstado();
        assertEquals("Atualização do pedido: \n" + "Status atual do Pedido: Pedido cancelado!!",pedido.getEstado().getNotificacaoAtualizacao());
    }

    @Test
    void deveRetornarPedidoPagoComCartao() {
        assertEquals("Pagamento via Cartão de R$50.0 com 3% de taxa: R$51.5", pedido.pagarComCartao());
    }

    @Test
    void deveRetornarPedidoPagoComDinheiro() {
        assertEquals("Pagamento via Dinheiro de R$50.0", pedido.pagarComDinheiro());
    }

    @Test
    void deveRetornarPedidoPagoComPix() {
        assertEquals("Pagamento via Pix de R$50.0 com 5% de desconto: R$47.5", pedido.pagarComPix());
    }

    @Test
    void deveRetornarRecepcionistaParaAcaoAceita() {
        assertEquals("Recepcionista aceitou o pedido", recepcionista.realizarAcao(new Acao(PedidoEstadoAceito.getInstance())));
    }

    @Test
    void deveRetornarGerenteParaAcaoCancelada() {
        assertEquals("Gerente cancelou o pedido", recepcionista.realizarAcao(new Acao(PedidoEstadoCancelado.getInstance())));
    }

}