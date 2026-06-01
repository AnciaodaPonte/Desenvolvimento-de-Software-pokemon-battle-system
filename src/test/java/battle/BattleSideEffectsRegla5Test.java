package battle;

import moves.MoveType;
import org.junit.jupiter.api.Test;
import pokemon.DefaultPokemon;
import pokemon.Pokemon;

import static org.junit.jupiter.api.Assertions.*;

class BattleSideEffectsRegla5Test {

    @Test
    void r5_elAtaqueSoloModificaElHp() {

        Pokemon atacante = new DefaultPokemon(
                1, "Pikachu", MoveType.ELECTRIC, null,
                320, 35, 55, 40, 50, 50, 90
        );

        Pokemon defensor = new DefaultPokemon(
                2, "Squirtle", MoveType.WATER, null,
                314, 100, 48, 65, 50, 64, 43
        );

        int hpAntes = defensor.getHp();

        int attackAntes = defensor.getAttack();
        int defenseAntes = defensor.getDefense();
        int speedAntes = defensor.getSpeed();

        atacante.useMove(1, defensor);

        assertTrue(defensor.getHp() < hpAntes);

        assertEquals(attackAntes, defensor.getAttack());
        assertEquals(defenseAntes, defensor.getDefense());
        assertEquals(speedAntes, defensor.getSpeed());
    }

    @Test
    void r5_elTipoDelPokemonNoCambiaDespuesDelAtaque() {

        Pokemon atacante = new DefaultPokemon(
                1, "Charmander", MoveType.FIRE, null,
                309, 39, 52, 43, 60, 50, 65
        );

        Pokemon defensor = new DefaultPokemon(
                2, "Bulbasaur", MoveType.GRASS, null,
                318, 100, 49, 49, 65, 65, 45
        );

        MoveType tipoAntes = defensor.getType1();

        atacante.useMove(1, defensor);

        assertEquals(tipoAntes, defensor.getType1());
    }

    @Test
    void r5_noHayEfectosColateralesEntreTurnos() {
        Pokemon atacante = new DefaultPokemon(
                1, "Squirtle", MoveType.WATER, null,
                314, 44, 48, 65, 50, 64, 43
        );

        Pokemon defensor = new DefaultPokemon(
                2, "Charmander", MoveType.FIRE, null,
                309, 100, 52, 43, 60, 50, 65
        );

        int ataqueAntes = atacante.getAttack();
        int defensaAntes = atacante.getDefense();
        int velocidadAntes = atacante.getSpeed();

        atacante.useMove(1, defensor);

        assertEquals(ataqueAntes, atacante.getAttack());
        assertEquals(defensaAntes, atacante.getDefense());
        assertEquals(velocidadAntes, atacante.getSpeed());
    }
}
