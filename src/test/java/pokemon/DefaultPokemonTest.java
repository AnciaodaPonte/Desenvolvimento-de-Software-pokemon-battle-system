package pokemon;

import moves.MoveType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultPokemonTest {

    @Test
    void shouldCreateDefaultPokemon() {

        DefaultPokemon pokemon =
                new DefaultPokemon(
                        25,
                        "Pikachu",
                        MoveType.ELECTRIC,
                        null,
                        320,
                        35,
                        55,
                        40,
                        50,
                        50,
                        90
                );

        assertEquals(25, pokemon.getId());
        assertEquals("Pikachu", pokemon.getName());
        assertEquals(MoveType.ELECTRIC, pokemon.getType1());
        assertNull(pokemon.getType2());
        assertEquals(35, pokemon.getHp());
        assertEquals(55, pokemon.getAttack());
        assertEquals(40, pokemon.getDefense());
        assertEquals(50, pokemon.getSpAttack());
        assertEquals(50, pokemon.getSpDefense());
        assertEquals(90, pokemon.getSpeed());
    }
}