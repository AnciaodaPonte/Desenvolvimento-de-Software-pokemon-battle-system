package types;

import moves.MoveType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TypeChartTest {

    @Test
    void shouldReturnSuperEffectiveMultiplier() {

        assertEquals(
                2.0,
                TypeChart.getMultiplier(
                        MoveType.FIRE,
                        MoveType.GRASS
                )
        );
    }

    @Test
    void shouldReturnNotVeryEffectiveMultiplier() {

        assertEquals(
                0.5,
                TypeChart.getMultiplier(
                        MoveType.FIRE,
                        MoveType.WATER
                )
        );
    }

    @Test
    void shouldReturnNoEffectMultiplier() {

        assertEquals(
                0.0,
                TypeChart.getMultiplier(
                        MoveType.NORMAL,
                        MoveType.GHOST
                )
        );
    }

    @Test
    void shouldReturnNormalEffectivenessWhenCombinationDoesNotExist() {

        assertEquals(
                1.0,
                TypeChart.getMultiplier(
                        MoveType.FIRE,
                        MoveType.PSYCHIC
                )
        );
    }

    @Test
    void shouldReturnElectricImmuneAgainstGround() {

        assertEquals(
                0.0,
                TypeChart.getMultiplier(
                        MoveType.ELECTRIC,
                        MoveType.GROUND
                )
        );
    }

    @Test
    void shouldReturnGroundSuperEffectiveAgainstElectric() {

        assertEquals(
                2.0,
                TypeChart.getMultiplier(
                        MoveType.GROUND,
                        MoveType.ELECTRIC
                )
        );
    }

    @Test
    void shouldReturnDragonNoEffectAgainstFairy() {

        assertEquals(
                0.0,
                TypeChart.getMultiplier(
                        MoveType.DRAGON,
                        MoveType.FAIRY
                )
        );
    }

    @Test
    void shouldReturnFairySuperEffectiveAgainstDragon() {

        assertEquals(
                2.0,
                TypeChart.getMultiplier(
                        MoveType.FAIRY,
                        MoveType.DRAGON
                )
        );
    }
}