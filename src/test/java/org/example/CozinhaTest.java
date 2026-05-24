package org.example;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CozinhaTest {

    @Test
    void deveRetornarHamburgueres() {
        Cozinha cozinha = new Cozinha();
        cozinha.adicionarHamburguer("Artesanal", "200g");
        cozinha.adicionarHamburguer("Artesanal", "200g");
        cozinha.adicionarHamburguer("Smash", "200g");
        cozinha.adicionarHamburguer("Smash", "100g");

        List<String> saida = Arrays.asList(
                "Hamburguer Artesanal: Hamburguer: \npao: Pão australiano , carne: Carne ângus , tipo da carne: Carne de 200g",
                "Hamburguer Artesanal: Hamburguer: \npao: Pão australiano , carne: Carne ângus , tipo da carne: Carne de 200g",
                "Hamburguer Smash: Hamburguer: \npao: Pão com gergelim , carne: Carne acém , tipo da carne: Carne de 200g",
                "Hamburguer Smash: Hamburguer: \npao: Pão com gergelim , carne: Carne acém , tipo da carne: Carne de 100g"
        );

        assertEquals(saida, cozinha.obterHamburgueres());
    }

    @Test
    void deveRetornarTotalCarnes() {
        Cozinha cozinha = new Cozinha();
        cozinha.adicionarHamburguer("Artesanal", "200g");
        cozinha.adicionarHamburguer("Artesanal", "200g");
        cozinha.adicionarHamburguer("Smash", "200g");
        cozinha.adicionarHamburguer("Smash", "100g");

        assertEquals(2, CarneFactory.getTotalCarnes());
    }
}