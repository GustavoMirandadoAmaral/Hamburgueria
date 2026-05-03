package org.example;

public class HamburguerSmash extends HamburguerBase{

    public HamburguerSmash(TipoCarne tipoCarne){
        super("Pão com gergelim", "Carne de boi", tipoCarne);
    }

    public String getHamburguerCompleto(){
        return "Hamburguer Smash: " + super.getHamburguerCompleto();
    }
}
