package org.example;


public class IngredienteMolhoEspecial extends HamburguerDecorator {

    public IngredienteMolhoEspecial(Hamburguer hamburguer) {
        super(hamburguer);
    }

   public String getIngrediente() {
        return "molho especial";
    }
}