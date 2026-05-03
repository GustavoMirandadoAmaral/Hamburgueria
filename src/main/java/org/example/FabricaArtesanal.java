package org.example;

public class FabricaArtesanal implements FabricaAbstrata{

    private FabricaArtesanal() {};
    private static FabricaArtesanal instance = new FabricaArtesanal();
    public static FabricaArtesanal getInstance() {
        return instance;
    }

    public Hamburguer createHamburguerBase(TipoCarne tipoCarne){
        return new HamburguerArtesanal(tipoCarne);
    }

    public Hamburguer adicionarMolho(Hamburguer hamburguer){
        return IngredienteFactory.getInstance().obterIngrediente("MolhoEspecial", hamburguer);
    }
}
