package battle;

import moves.MoveType;
import org.junit.jupiter.api.Test;
import pokemon.DefaultPokemon;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BattleSystemTest {

    private DefaultPokemon crearPokemon(String nombre, int velocidad) {
        return new DefaultPokemon(
                1,
                nombre,
                MoveType.NORMAL,
                null,
                300,
                100,
                50,
                10,
                50,
                10,
                velocidad
        );
    }

    @Test
    void pokemonDelJugadorConMayorVelocidadDebeAtacarPrimero() {
        BattleSystem battleSystem = new BattleSystem();
        DefaultPokemon jugador = crearPokemon("Pikachu", 100);
        DefaultPokemon enemigo = crearPokemon("Bulbasaur", 50);

        boolean resultado = battleSystem.playerAttacksFirst(jugador, enemigo);

        assertTrue(resultado);
    }

    @Test
    void pokemonEnemigoConMayorVelocidadDebeAtacarPrimero() {
        BattleSystem battleSystem = new BattleSystem();
        DefaultPokemon jugador = crearPokemon("Bulbasaur", 50);
        DefaultPokemon enemigo = crearPokemon("Pikachu", 100);

        boolean resultado = battleSystem.playerAttacksFirst(jugador, enemigo);

        assertFalse(resultado);
    }

    @Test
    void empateDeVelocidadDebeMantenerUnOrdenConsistente() {
        BattleSystem battleSystem = new BattleSystem();
        DefaultPokemon jugador = crearPokemon("Pokemon A", 80);
        DefaultPokemon enemigo = crearPokemon("Pokemon B", 80);

        boolean primerResultado = battleSystem.playerAttacksFirst(jugador, enemigo);
        boolean segundoResultado = battleSystem.playerAttacksFirst(jugador, enemigo);
        boolean tercerResultado = battleSystem.playerAttacksFirst(jugador, enemigo);

        assertTrue(primerResultado);
        assertTrue(segundoResultado);
        assertTrue(tercerResultado);
    }
}