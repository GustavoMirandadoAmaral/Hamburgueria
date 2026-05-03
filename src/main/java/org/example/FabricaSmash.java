package org.example;

public class FabricaSmash implements FabricaAbstrata{

    private FabricaSmash() {};
    private static FabricaSmash instance = new FabricaSmash();
    public static FabricaSmash getInstance() {
        return instance;
    }

    public Hamburguer createHamburguerBase(TipoCarne tipoCarne){
        return new HamburguerSmash(tipoCarne);
    }

    public Hamburguer adicionarMolho(Hamburguer hamburguer){
        return IngredienteFactory.getInstance().obterIngrediente("MolhoSmash", hamburguer);
    }
}
