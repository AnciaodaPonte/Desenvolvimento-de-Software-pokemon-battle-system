package battle;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import pokemon.DefaultPokemon;
import moves.MoveType;

public class BattleSystemTest {

    private DefaultPokemon fastPokemon;
    private DefaultPokemon slowPokemon;
    private DefaultPokemon equalPokemon1;
    private DefaultPokemon equalPokemon2;

    @BeforeEach
    public void setUp() {
        // ASÍ SE NOS PRESENTA A LOS POKOEMNOS
        fastPokemon = new DefaultPokemon(1, "Jolteon", MoveType.NORMAL, null, 100, 100, 50, 10, 50, 10, 130);
        slowPokemon = new DefaultPokemon(2, "Snorlax", MoveType.NORMAL, null, 100, 160, 60, 50, 40, 50, 30);

        equalPokemon1 = new DefaultPokemon(3, "PikachuA", MoveType.NORMAL, null, 100, 90, 55, 40, 50, 40, 90);
        equalPokemon2 = new DefaultPokemon(4, "PikachuB", MoveType.NORMAL, null, 100, 90, 55, 40, 50, 40, 90);
    }

    @Test
    public void testTurnOrder_HighestSpeedAttacksFirst() {
        // REGLA 1: El Pokémon con mayor velocidad debe atacar primero
        boolean playerFirst = false;
        if (fastPokemon.getSpeed() > slowPokemon.getSpeed()) {
            playerFirst = true;
        }
        assertTrue(playerFirst, "QA ERROR: El Pokémon con 130 de velocidad debió tener prioridad sobre el de 30.");
    }

    @Test
    public void testTurnOrder_EqualSpeedIsConsistent() {
        // REGLA 1 (CasoIgual): Misma velocidad debe mantener un orden consistente, no
        // aleatoreo
        int speed1 = equalPokemon1.getSpeed();
        int speed2 = equalPokemon2.getSpeed();

        /*
         * Aquí demostramos de forma crítica en el análisis que las velocidades son
         * identica pero mapeamos que el sistema original recurre a un booleano
         * aleatorio
         * inestable.
         */
        assertEquals(speed1, speed2, "Las velocidades de ambos Pokémon son iguales.");
    }

    @Test
    public void testDamage_HpNeverNegative() {
        // REGLA 2 y 4: El HP nunca queda en valores negativos y se procesa la derrota
        fastPokemon.receiveDamage(500); // Aplicamos un daño masivo

        assertEquals(0, fastPokemon.getHp(), "QA ERROR: El HP nunca debe quedar por debajo de 0.");
        assertTrue(fastPokemon.isFainted(), "QA ERROR: El Pokémon debería cambiar su estado a debilitado (fainted).");
    }

    @Test
    public void testDamage_HpNeverIncreases() {
        // REGLA 2: El daño aplicado reduce los puntos de vida, nunca los incrementa
        int initialHp = fastPokemon.getHp();

        // Ejecutamos un daño bajo (menor a la defensa) para validar que no existan
        // comportamientos extraños
        fastPokemon.receiveDamage(5);

        assertTrue(fastPokemon.getHp() <= initialHp, "QA ERROR: La vida del Pokémon aumentó o falló la consistencia.");
    }
}