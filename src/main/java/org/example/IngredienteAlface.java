package org.example;


public class IngredienteAlface extends HamburguerDecorator {


    public IngredienteAlface(Hamburguer hamburguer) {
        super(hamburguer);
    }


    public String getIngrediente() {
        return "alface";
    }
}