package org.example;


public class IngredienteTomate extends HamburguerDecorator {


    public IngredienteTomate(Hamburguer hamburguer) {
        super(hamburguer);
    }


    public String getIngrediente() {
        return "tomate";
    }
}