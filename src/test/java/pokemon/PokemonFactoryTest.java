package pokemon;

import moves.MoveType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonFactoryTest {

    @Test
    void shouldCreateBulbasaur() {

        Pokemon pokemon =
                PokemonFactory.createPokemon(1);

        assertEquals(
                1,
                pokemon.getId()
        );

        assertEquals(
                "Bulbasaur",
                pokemon.getName()
        );

        assertEquals(
                MoveType.GRASS,
                pokemon.getType1()
        );

        assertEquals(
                MoveType.POISON,
                pokemon.getType2()
        );

        assertEquals(
                45,
                pokemon.getHp()
        );
    }

    @Test
    void shouldCreateCharmanderWithoutSecondType() {

        Pokemon pokemon =
                PokemonFactory.createPokemon(4);

        assertEquals(
                "Charmander",
                pokemon.getName()
        );

        assertEquals(
                MoveType.FIRE,
                pokemon.getType1()
        );

        assertNull(
                pokemon.getType2()
        );
    }

    @Test
    void shouldCreateCharizardWithTwoTypes() {

        Pokemon pokemon =
                PokemonFactory.createPokemon(6);

        assertEquals(
                "Charizard",
                pokemon.getName()
        );

        assertEquals(
                MoveType.FIRE,
                pokemon.getType1()
        );

        assertEquals(
                MoveType.FLYING,
                pokemon.getType2()
        );
    }

    @Test
    void shouldThrowExceptionForInvalidPokemonId() {

        assertThrows(
                IllegalArgumentException.class,
                () -> PokemonFactory.createPokemon(9999)
        );
    }

    @Test
    void shouldAlwaysReturnANewInstance() {

        Pokemon pokemon1 =
                PokemonFactory.createPokemon(1);

        Pokemon pokemon2 =
                PokemonFactory.createPokemon(1);

        assertNotSame(
                pokemon1,
                pokemon2
        );
    }
}