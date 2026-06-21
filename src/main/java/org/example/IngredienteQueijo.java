package org.example;


public class IngredienteQueijo extends HamburguerDecorator {

    public IngredienteQueijo(Hamburguer hamburguer) {
        super(hamburguer);
    }

    public String getIngrediente() {
        return "queijo";
    }
}