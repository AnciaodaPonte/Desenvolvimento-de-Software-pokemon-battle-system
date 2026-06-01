package battle;

import moves.MoveType;
import org.junit.jupiter.api.Test;
import pokemon.DefaultPokemon;
import pokemon.Pokemon;

import static org.junit.jupiter.api.Assertions.*;

class BattleOrderRegla1Test {

    @Test
    void r1_elPokemonMasRapidoAtacaPrimero() {

        BattleSystem battleSystem = new BattleSystem();

        Pokemon rapido = new DefaultPokemon(
                1, "Pikachu", MoveType.ELECTRIC, null,
                320, 35, 55, 40, 50, 50, 90
        );

        Pokemon lento = new DefaultPokemon(
                2, "Squirtle", MoveType.WATER, null,
                314, 44, 48, 65, 50, 64, 43
        );

        assertTrue(battleSystem.isPlayerFirst(rapido, lento));
    }

    @Test
    void r1_elPokemonMasLentoNoAtacaPrimero() {

        BattleSystem battleSystem = new BattleSystem();

        Pokemon lento = new DefaultPokemon(
                1, "Bulbasaur", MoveType.GRASS, null,
                318, 45, 49, 49, 65, 65, 45
        );

        Pokemon rapido = new DefaultPokemon(
                2, "Pikachu", MoveType.ELECTRIC, null,
                320, 35, 55, 40, 50, 50, 90
        );

        assertFalse(battleSystem.isPlayerFirst(lento, rapido));
    }

    @Test
    void r1_velocidadesIgualesNoGeneranError() {

        BattleSystem battleSystem = new BattleSystem();

        Pokemon pokemon1 = new DefaultPokemon(
                1, "Charmander", MoveType.FIRE, null,
                309, 39, 52, 43, 60, 50, 65
        );

        Pokemon pokemon2 = new DefaultPokemon(
                2, "Eevee", MoveType.NORMAL, null,
                325, 55, 55, 50, 45, 65, 65
        );

        assertDoesNotThrow(() ->
                battleSystem.isPlayerFirst(pokemon1, pokemon2)
        );
    }
}