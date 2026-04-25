package org.example;


public class HamburguerBase implements Hamburguer {


    private String pao;
    private String carne;


    public HamburguerBase() {

    }


    public HamburguerBase(String pao, String carne) {
        this.pao = pao;
        this.carne = carne;
    }


    public String getHamburguerCompleto() {
        return toString();
    }


    @Override
    public String toString() {
        return "Hamburguer: " +
                "pao='" + pao + ' ' +
        ", carne='" + carne + ' ' +
        '}';
    }
}