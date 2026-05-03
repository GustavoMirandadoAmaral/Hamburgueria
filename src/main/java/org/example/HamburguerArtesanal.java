package org.example;

public class HamburguerArtesanal extends HamburguerBase{

    public HamburguerArtesanal(TipoCarne tipoCarne){
        super("Pão australiano", "Carne ângus", tipoCarne);
    }

    public String getHamburguerCompleto(){
        return "Hamburguer Artesanal: " + super.getHamburguerCompleto();
    }
}
