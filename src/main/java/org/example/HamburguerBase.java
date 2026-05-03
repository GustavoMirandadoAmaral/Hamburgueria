package org.example;


public abstract class HamburguerBase implements Hamburguer {


    private String pao;
    private String carne;
    private TipoCarne tipoCarne;

    public HamburguerBase(String pao, String carne, TipoCarne tipoCarne) {
        this.pao = pao;
        this.carne = carne;
        this.tipoCarne = tipoCarne;
    }

    @Override
    public String toString() {
        return "Hamburguer: \n" + "pao =" + pao + ' ' + ", carne =" + carne + ' ' + ", tipo da carne =" + tipoCarne.selecionarCarne();
    }

    public String getHamburguerCompleto() {
        return toString();
    }
}