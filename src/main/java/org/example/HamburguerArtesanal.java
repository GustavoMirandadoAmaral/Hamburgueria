package org.example;

public class HamburguerArtesanal extends HamburguerBase {

    public HamburguerArtesanal(TipoCarne tipoCarne) {
        super("Pão australiano", "Carne ângus", tipoCarne);
    }

    @Override
    public String prepararCarne() {
        return "Carne grelhada em fogo alto";
    }

    @Override
    public String getHamburguerCompleto() {
        return "Hamburguer Artesanal: " + super.toString();
    }
}
