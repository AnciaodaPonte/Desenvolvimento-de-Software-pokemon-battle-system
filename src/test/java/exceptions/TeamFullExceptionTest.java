package exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TeamFullExceptionTest {

    @Test
    void shouldCreateExceptionWithMessage() {

        TeamFullException exception =
                new TeamFullException(
                        "Your team already has 6 Pokemons!"
                );

        assertEquals(
                "Your team already has 6 Pokemons!",
                exception.getMessage()
        );
    }
}