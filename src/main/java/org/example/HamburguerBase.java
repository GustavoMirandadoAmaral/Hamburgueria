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

    // Template Method
    public String prepararHamburguer() {
        return selecionarPao() + " + " + prepararCarne() + " + " + finalizarPreparo();
    }

    public String selecionarPao() {
        return "Pão: " + pao;
    }

    public abstract String prepararCarne();

    public String finalizarPreparo() {
        return "Carne: " + carne + " (" + tipoCarne.selecionarCarne() + ")";
    }

    @Override
    public String toString() {
        return "Hamburguer: \npao: " + pao + ' ' + ", carne: " + carne + ' ' + ", tipo da carne: " + tipoCarne.selecionarCarne();
    }

    @Override
    public String getHamburguerCompleto() {
        return toString();
    }
}