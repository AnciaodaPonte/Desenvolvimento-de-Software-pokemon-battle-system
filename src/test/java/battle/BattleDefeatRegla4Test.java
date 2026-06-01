package battle;

import moves.MoveType;
import org.junit.jupiter.api.Test;
import pokemon.DefaultPokemon;
import pokemon.Pokemon;

import static org.junit.jupiter.api.Assertions.*;

class BattleDefeatRegla4Test {

    @Test
    void r4_elCombateTerminaCuandoUnPokemonQuedaDerrotado() {

        BattleSystem battleSystem = new BattleSystem();

        Pokemon player = new DefaultPokemon(
                1, "Charizard", MoveType.FIRE, null,
                534, 78, 999, 10, 999, 10, 100
        );

        Pokemon enemy = new DefaultPokemon(
                2, "Bulbasaur", MoveType.GRASS, null,
                318, 20, 49, 10, 65, 10, 45
        );

        player.useMove(1, enemy);

        assertTrue(battleSystem.isBattleOver(player, enemy));
    }

    @Test
    void r4_unPokemonDerrotadoNoEstaVivo() {

        Pokemon pokemon = new DefaultPokemon(
                1, "Charmander", MoveType.FIRE, null,
                309, 39, 52, 10, 60, 10, 65
        );

        pokemon.receiveDamage(999);

        assertFalse(pokemon.isAlive());
    }

    @Test
    void r4_elSistemaIdentificaCorrectamenteAlGanador() {

        BattleSystem battleSystem = new BattleSystem();

        Pokemon winner = new DefaultPokemon(
                1, "Blastoise", MoveType.WATER, null,
                530, 79, 83, 100, 85, 105, 78
        );

        Pokemon loser = new DefaultPokemon(
                2, "Charmander", MoveType.FIRE, null,
                309, 1, 52, 10, 60, 10, 65
        );

        loser.receiveDamage(999);

        assertEquals(winner, battleSystem.getWinner(winner, loser));
    }
}