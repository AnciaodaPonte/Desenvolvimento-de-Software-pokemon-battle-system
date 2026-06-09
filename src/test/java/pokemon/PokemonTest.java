package pokemon;

import moves.MoveType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestPokemon extends Pokemon {

    public TestPokemon() {

        super(
                1,
                "TestPokemon",
                MoveType.FIRE,
                null,
                300,
                100,
                50,
                20,
                50,
                20,
                50
        );
    }

    @Test
    void shouldCreatePokemon() {

        Pokemon pokemon =
                new TestPokemon();

        assertEquals(
                "TestPokemon",
                pokemon.getName()
        );

        assertEquals(
                100,
                pokemon.getHp()
        );
    }

    @Test
    void shouldReceiveDamage() {

        Pokemon pokemon =
                new TestPokemon();

        pokemon.receiveDamage(50);

        assertEquals(
                70,
                pokemon.getHp()
        );
    }

    @Test
    void shouldReceiveSpecialDamage() {

        Pokemon pokemon =
                new TestPokemon();

        pokemon.receiveSpecialDamage(50);

        assertEquals(
                70,
                pokemon.getHp()
        );
    }

    @Test
    void shouldHealToFullHp() {

        Pokemon pokemon =
                new TestPokemon();

        pokemon.receiveDamage(50);

        pokemon.healFull();

        assertEquals(
                100,
                pokemon.getHp()
        );
    }

    @Test
    void shouldBeAlive() {

        Pokemon pokemon =
                new TestPokemon();

        assertTrue(
                pokemon.isAlive()
        );
    }

    @Test
    void shouldBeFainted() {

        Pokemon pokemon =
                new TestPokemon();

        pokemon.receiveDamage(9999);

        assertTrue(
                pokemon.isFainted()
        );
    }

    @Test
    void shouldUseDefenseMoveWithoutDamagingEnemy() {

        Pokemon attacker =
                new TestPokemon();

        Pokemon defender =
                new TestPokemon();

        int hpBefore =
                defender.getHp();

        attacker.useMove(
                0,
                defender
        );

        assertEquals(
                hpBefore,
                defender.getHp()
        );
    }
}