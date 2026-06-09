package battle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class BattleMenuTest {

    @Test
    void shouldCreateBattleMenu() {

        BattleMenu battleMenu =
                new BattleMenu();

        assertNotNull(
                battleMenu
        );
    }
}