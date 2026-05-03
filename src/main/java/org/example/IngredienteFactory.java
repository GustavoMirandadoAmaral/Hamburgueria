package org.example;

public class IngredienteFactory {

    private IngredienteFactory() {};
    private static IngredienteFactory instance = new IngredienteFactory();
    public static IngredienteFactory getInstance() {
        return instance;
    }

    public static Hamburguer obterIngrediente(String ingrediente, Hamburguer hamburguer) {
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName("org.example.Ingrediente" + ingrediente);
            objeto = classe.getDeclaredConstructor(Hamburguer.class).newInstance(hamburguer);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Ingrediente inexistente");
        }
        if (!(objeto instanceof Hamburguer)) {
            throw new IllegalArgumentException("Ingrediente inválido");
        }
        return (Hamburguer) objeto;
    }
}