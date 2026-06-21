package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MaquinaCartaoAdapterTest {

    @Test
    void deveRetornarPagamentoCartao() {
        MaquinaCartaoAdapter maquinaCartao = new MaquinaCartaoAdapter(new FormaPagamentoCartao());
        maquinaCartao.registrarTransacao(50.0f);

        assertEquals("Pagamento via Cartão de R$50.0 com 3% de taxa: R$51.5", maquinaCartao.recuperarPagamento(50.0f));
    }

    @Test
    void deveRetornarCodigoStatusTransacao() {
        MaquinaCartaoAdapter maquinaCartao = new MaquinaCartaoAdapter(new FormaPagamentoCartao());
        maquinaCartao.registrarTransacao(50.0f);

        assertEquals(0, maquinaCartao.getCodigoStatus());
    }
}