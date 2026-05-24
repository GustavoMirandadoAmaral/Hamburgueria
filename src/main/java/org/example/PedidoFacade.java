package org.example;

public class PedidoFacade {

    public static boolean verificarPendenciasPedido(FabricaAbstrata fabrica, TipoCarne tipoCarne, String ingrediente, float valor) {
        if (!verificarHamburguer(fabrica, tipoCarne)) {
            return false;
        }
        if (!verificarIngrediente(ingrediente, fabrica.createHamburguerBase(tipoCarne))) {
            return false;
        }
        if (!verificarPagamento(valor)) {
            return false;
        }
        return true;
    }

    private static boolean verificarHamburguer(FabricaAbstrata fabrica, TipoCarne tipoCarne) {
        try {
            fabrica.createHamburguerBase(tipoCarne);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean verificarIngrediente(String ingrediente, Hamburguer hamburguer) {
        try {
            IngredienteFactory.getInstance().obterIngrediente(ingrediente, hamburguer);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean verificarPagamento(float valor) {
        return valor > 0;
    }
}