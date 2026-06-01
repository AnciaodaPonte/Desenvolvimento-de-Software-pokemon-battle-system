package battle;

import moves.MoveType;
import org.junit.jupiter.api.Test;
import pokemon.DefaultPokemon;
import pokemon.Pokemon;

import static org.junit.jupiter.api.Assertions.*;

class BattleEffectivenessRegla3Test {

    @Test
    void r3_ataqueEfectivoCausaMasDanio() {
        Pokemon atacante = new DefaultPokemon(
            1, "Charmander", MoveType.FIRE, null,
            309, 39, 52, 10, 60, 10, 65
        );

        Pokemon defensorDebil = new DefaultPokemon(
            2, "Bulbasaur", MoveType.GRASS, null,
            318, 300, 49, 10, 65, 10, 45
        );

        int hpAntes = defensorDebil.getHp();

        atacante.useMove(1, defensorDebil);

        int danioRecibido = hpAntes - defensorDebil.getHp();

        assertTrue(danioRecibido > 100);
    }

    @Test
    void r3_ataquePocoEfectivoCausaMenosDanio() {
        Pokemon atacante = new DefaultPokemon(
                1, "Bulbasaur", MoveType.GRASS, null,
                318, 45, 49, 10, 65, 10, 45
        );

        Pokemon defensorResistente = new DefaultPokemon(
                2, "Charmander", MoveType.FIRE, null,
                309, 100, 52, 10, 60, 10, 65
        );

        int hpAntes = defensorResistente.getHp();

        atacante.useMove(1, defensorResistente);

        int danioRecibido = hpAntes - defensorResistente.getHp();

        assertTrue(danioRecibido < 100);
    }

    @Test
    void r3_ataqueNeutroMantieneDanioBase() {
        Pokemon atacante = new DefaultPokemon(
                1, "Eevee", MoveType.NORMAL, null,
                325, 55, 55, 10, 45, 10, 55
        );

        Pokemon defensorNeutro = new DefaultPokemon(
                2, "Squirtle", MoveType.WATER, null,
                314, 100, 48, 10, 50, 10, 43
        );

        int hpAntes = defensorNeutro.getHp();

        atacante.useMove(1, defensorNeutro);

        int danioRecibido = hpAntes - defensorNeutro.getHp();

        assertEquals(95, danioRecibido);
    }
}