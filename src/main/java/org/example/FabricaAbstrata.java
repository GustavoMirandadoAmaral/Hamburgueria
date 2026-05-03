package org.example;

public interface FabricaAbstrata {
    Hamburguer createHamburguerBase(TipoCarne tipoCarne);

    Hamburguer adicionarMolho(Hamburguer hamburguer);
}
