package org.example;

public class HamburguerSmash extends HamburguerBase {

    public HamburguerSmash(TipoCarne tipoCarne) {
        super("Pão com gergelim", "Carne acém", tipoCarne);
    }

    @Override
    public String prepararCarne() {
        return "Carne prensada na chapa";
    }

    @Override
    public String getHamburguerCompleto() {
        return "Hamburguer Smash: " + super.toString();
    }
}
