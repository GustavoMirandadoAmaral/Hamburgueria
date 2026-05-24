package org.example;

import java.util.HashMap;
import java.util.Map;

public class CarneFactory {

    private static Map<String, TipoCarne> carnes = new HashMap<>();

    public static TipoCarne getCarne(String tipo) {
        TipoCarne carne = carnes.get(tipo);
        if (carne == null) {
            if (tipo.equals("100g")) {
                carne = new Carne100g();
            } else if (tipo.equals("200g")) {
                carne = new Carne200g();
            } else {
                throw new IllegalArgumentException("Tipo de carne inexistente");
            }
            carnes.put(tipo, carne);
        }
        return carne;
    }

    public static int getTotalCarnes() {
        return carnes.size();
    }
}