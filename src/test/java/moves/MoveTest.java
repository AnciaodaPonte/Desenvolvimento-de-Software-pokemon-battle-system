package moves;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveTest {

    @Test
    void shouldCreateMove() {

        Move move = new Move(
                "Thunderbolt",
                MoveType.ELECTRIC,
                MoveCategory.SPECIAL,
                90
        );

        assertEquals("Thunderbolt", move.getName());
        assertEquals(MoveType.ELECTRIC, move.getType());
        assertEquals(MoveCategory.SPECIAL, move.getCategory());
        assertEquals(90, move.getPower());
    }
}