package pokemon;

import moves.MoveType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PokemonTest {

    @Test
    void recibirDanoFisicoDebeReducirElHpCorrectamente() {
        DefaultPokemon pokemon = new DefaultPokemon(
                1,
                "Pokemon de prueba",
                MoveType.NORMAL,
                null,
                300,
                100,
                50,
                10,
                50,
                10,
                60
        );

        pokemon.receiveDamage(30);

        assertEquals(80, pokemon.getHp());
    }
}