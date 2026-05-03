package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AtendimentoTest {

    private static final String BASE_ARTESANAL = "Hamburguer Artesanal: Hamburguer: \npao =Pão australiano , carne =Carne ângus , tipo da carne =Carne de 200g";
    private static final String BASE_SMASH = "Hamburguer Smash: Hamburguer: \npao =Pão com gergelim , carne =Carne de boi , tipo da carne =Carne de 100g";

    // FabricaArtesanal
    @Test
    void deveCriarHamburguerArtesanalSemIngrediente() {
        Hamburguer hamburguer = FabricaArtesanal.getInstance().createHamburguerBase(new Carne200g());
        assertEquals(BASE_ARTESANAL, hamburguer.getHamburguerCompleto());
    }

    @Test
    void deveCriarHamburguerArtesanalComMolhoEspecial() {
        Hamburguer hamburguer = FabricaArtesanal.getInstance().adicionarMolho(
                FabricaArtesanal.getInstance().createHamburguerBase(new Carne200g())
        );
        assertEquals(BASE_ARTESANAL + " + molho especial", hamburguer.getHamburguerCompleto());
    }

    @Test
    void deveCriarHamburguerArtesanalComQueijo() {
        Hamburguer hamburguer = new IngredienteQueijo(
                FabricaArtesanal.getInstance().createHamburguerBase(new Carne200g())
        );
        assertEquals(BASE_ARTESANAL + " + queijo", hamburguer.getHamburguerCompleto());
    }

    @Test
    void deveCriarHamburguerArtesanalComQueijoEMolhoEspecial() {
        Hamburguer hamburguer = new IngredienteMolhoEspecial(new IngredienteQueijo(
                FabricaArtesanal.getInstance().createHamburguerBase(new Carne200g())
        ));
        assertEquals(BASE_ARTESANAL + " + queijo + molho especial", hamburguer.getHamburguerCompleto());
    }

    @Test
    void deveCriarHamburguerArtesanalComTodosIngredientes() {
        Hamburguer hamburguer = new IngredienteMolhoSmash(new IngredienteMolhoEspecial(new IngredienteQueijo(
                FabricaArtesanal.getInstance().createHamburguerBase(new Carne200g())
        )));
        assertEquals(BASE_ARTESANAL + " + queijo + molho especial + molho smash", hamburguer.getHamburguerCompleto());
    }

    // FabricaSmash
    @Test
    void deveCriarHamburguerSmashSemIngrediente() {
        Hamburguer hamburguer = FabricaSmash.getInstance().createHamburguerBase(new Carne100g());
        assertEquals(BASE_SMASH, hamburguer.getHamburguerCompleto());
    }

    @Test
    void deveCriarHamburguerSmashComMolhoSmash() {
        Hamburguer hamburguer = FabricaSmash.getInstance().adicionarMolho(
                FabricaSmash.getInstance().createHamburguerBase(new Carne100g())
        );
        assertEquals(BASE_SMASH + " + molho smash", hamburguer.getHamburguerCompleto());
    }

    @Test
    void deveCriarHamburguerSmashComQueijo() {
        Hamburguer hamburguer = new IngredienteQueijo(
                FabricaSmash.getInstance().createHamburguerBase(new Carne100g())
        );
        assertEquals(BASE_SMASH + " + queijo", hamburguer.getHamburguerCompleto());
    }

    @Test
    void deveCriarHamburguerSmashComQueijoEMolhoSmash() {
        Hamburguer hamburguer = new IngredienteMolhoSmash(new IngredienteQueijo(
                FabricaSmash.getInstance().createHamburguerBase(new Carne100g())
        ));
        assertEquals(BASE_SMASH + " + queijo + molho smash", hamburguer.getHamburguerCompleto());
    }

    @Test
    void deveCriarHamburguerSmashComTodosIngredientes() {
        Hamburguer hamburguer = new IngredienteMolhoSmash(new IngredienteMolhoEspecial(new IngredienteQueijo(
                FabricaSmash.getInstance().createHamburguerBase(new Carne100g())
        )));
        assertEquals(BASE_SMASH + " + queijo + molho especial + molho smash", hamburguer.getHamburguerCompleto());
    }
}