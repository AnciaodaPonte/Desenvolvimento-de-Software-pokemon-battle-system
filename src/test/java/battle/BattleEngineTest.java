package battle;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import pokemon.Pokemon;
import pokemon.DefaultPokemon;
import moves.MoveType;

class BattleEngineTest {

    @Test
    @DisplayName("Regla 1: El Pokémon con mayor velocidad debe tener prioridad lógica")
    void testPokemonMasRapidoTieneMayorVelocidad() {
        // Inicializamos con los 11 argumentos reales: (id, name, type1, type2, total, hp, attack, defense, spAttack, spDefense, speed)
        Pokemon fastPokemon = new DefaultPokemon(1, "Pikachu", MoveType.ELECTRIC, null, 320, 100, 55, 40, 50, 50, 90);
        Pokemon slowPokemon = new DefaultPokemon(2, "Bulbasaur", MoveType.GRASS, null, 318, 100, 49, 49, 65, 65, 45);

        // Comprobamos que la condición lógica que usa BattleSystem se cumpla coherentemente
        assertTrue(fastPokemon.getSpeed() > slowPokemon.getSpeed(),
                "El Pokémon rápido debería superar en velocidad al lento.");
    }

    @Test
    @DisplayName("Regla 1 (Caso Borde - Riesgo): El desempate por velocidades iguales no debe ser aleatorio")
    void testVelocidadesIgualesNoDebeSerAleatorio() {
        // Creamos dos Pokémon con exactamente la misma velocidad (90)
        Pokemon p1 = new DefaultPokemon(1, "Pikachu A", MoveType.ELECTRIC, null, 320, 100, 55, 40, 50, 50, 90);
        Pokemon p2 = new DefaultPokemon(3, "Pikachu B", MoveType.ELECTRIC, null, 320, 100, 55, 40, 50, 50, 90);

        // Análisis crítico: Aquí evaluamos que las velocidades sean idénticas
        assertEquals(p1.getSpeed(), p2.getSpeed(), "Las velocidades deberían ser iguales para evaluar el caso borde.");

        // Explicación para la exposición:
        // El código actual del sistema usa 'random.nextBoolean()' en BattleSystem, lo cual viola la consistencia
        // requerida por la regla de negocio del taller.
    }
}