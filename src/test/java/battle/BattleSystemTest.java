package battle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class BattleSystemTest {

    @Test
    void shouldCreateBattleSystem() {

        BattleSystem battleSystem =
                new BattleSystem();

        assertNotNull(
                battleSystem
        );
    }
}