package org.example;


public class IngredienteMolhoSmash extends HamburguerDecorator {

    public IngredienteMolhoSmash(Hamburguer hamburguer) {
        super(hamburguer);
    }

    public String getIngrediente() {
        return "molho smash";
    }
}