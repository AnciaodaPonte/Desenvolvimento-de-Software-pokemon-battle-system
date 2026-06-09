package moves;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TypeMovesTest {

    @Test
    void shouldReturnMovesForFireType() {

        ArrayList<Move> moves =
                TypeMoves.getMoves(MoveType.FIRE);

        assertNotNull(moves);

        assertEquals(3, moves.size());

        assertEquals(
                "Fire Punch",
                moves.get(0).getName()
        );
    }

    @Test
    void shouldReturnThreeMovesForEveryType() {

        for (MoveType type : MoveType.values()) {

            ArrayList<Move> moves =
                    TypeMoves.getMoves(type);

            assertNotNull(moves);

            assertEquals(
                    3,
                    moves.size()
            );
        }
    }
}