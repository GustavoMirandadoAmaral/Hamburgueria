package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cozinha {

    private List<HamburguerBase> hamburgueres = new ArrayList<>();

    public void adicionarHamburguer(String tipo, String tipoCarne) {
        TipoCarne carne = CarneFactory.getCarne(tipoCarne);
        HamburguerBase hamburguer;
        if (tipo.equals("Artesanal")) {
            hamburguer = new HamburguerArtesanal(carne);
        } else {
            hamburguer = new HamburguerSmash(carne);
        }
        hamburgueres.add(hamburguer);
    }

    public List<String> obterHamburgueres() {
        List<String> saida = new ArrayList<>();
        for (HamburguerBase hamburguer : hamburgueres) {
            saida.add(hamburguer.getHamburguerCompleto());
        }
        return saida;
    }
}