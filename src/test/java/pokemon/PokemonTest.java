package pokemon;

import moves.MoveType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {

    private DefaultPokemon crearPokemonDePrueba(int hp, int defense) {
        return new DefaultPokemon(
                1,
                "Pokemon de prueba",
                MoveType.NORMAL,
                null,
                300,
                hp,
                50,
                defense,
                50,
                10,
                60
        );
    }

    @Test
    void recibirDanoFisicoDebeReducirElHpCorrectamente() {
        DefaultPokemon pokemon = crearPokemonDePrueba(100, 10);

        pokemon.receiveDamage(30);

        assertEquals(80, pokemon.getHp());
    }

    @Test
    void elHpNuncaDebeQuedarEnValorNegativo() {
        DefaultPokemon pokemon = crearPokemonDePrueba(100, 10);

        pokemon.receiveDamage(500);

        assertEquals(0, pokemon.getHp());
    }

    @Test
    void pokemonConCeroHpDebeQuedarDerrotado() {
        DefaultPokemon pokemon = crearPokemonDePrueba(100, 10);

        pokemon.receiveDamage(500);

        assertTrue(pokemon.isFainted());
        assertFalse(pokemon.isAlive());
    }

    @Test
    void danoMenorQueLaDefensaNoDebeIncrementarElHp() {
        DefaultPokemon pokemon = crearPokemonDePrueba(100, 50);

        pokemon.receiveDamage(30);

        assertEquals(100, pokemon.getHp());
    }
}