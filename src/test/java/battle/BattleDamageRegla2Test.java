package battle;

import moves.MoveType;
import org.junit.jupiter.api.Test;
import pokemon.DefaultPokemon;
import pokemon.Pokemon;

import static org.junit.jupiter.api.Assertions.*;

class BattleDamageRegla2Test {

    @Test
    void r2_elDanioReduceLaVidaDelPokemonAtacado() {
        Pokemon atacante = new DefaultPokemon(
                1, "Charmander", MoveType.FIRE, null,
                309, 39, 52, 10, 60, 10, 65
        );

        Pokemon defensor = new DefaultPokemon(
                2, "Bulbasaur", MoveType.GRASS, null,
                318, 45, 49, 10, 65, 10, 45
        );

        int vidaAntes = defensor.getHp();

        atacante.useMove(1, defensor);

        int vidaDespues = defensor.getHp();

        assertTrue(vidaDespues < vidaAntes);
    }

    @Test
    void r2_laVidaNuncaQuedaNegativa() {
        Pokemon atacante = new DefaultPokemon(
                1, "Charizard", MoveType.FIRE, null,
                534, 78, 999, 10, 999, 10, 100
        );

        Pokemon defensor = new DefaultPokemon(
                2, "Bulbasaur", MoveType.GRASS, null,
                318, 20, 49, 10, 65, 10, 45
        );

        atacante.useMove(1, defensor);

        assertEquals(0, defensor.getHp());
    }

    @Test
    void r2_elDanioNoIncrementaLaVida() {
        Pokemon atacante = new DefaultPokemon(
                1, "Squirtle", MoveType.WATER, null,
                314, 44, 48, 10, 50, 10, 43
        );

        Pokemon defensor = new DefaultPokemon(
                2, "Charmander", MoveType.FIRE, null,
                309, 39, 52, 10, 60, 10, 65
        );

        int vidaAntes = defensor.getHp();

        atacante.useMove(1, defensor);

        assertTrue(defensor.getHp() <= vidaAntes);
    }
}
