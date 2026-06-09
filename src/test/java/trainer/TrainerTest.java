package trainer;

import exceptions.TeamFullException;
import moves.MoveType;
import org.junit.jupiter.api.Test;
import pokemon.Pokemon;

import static org.junit.jupiter.api.Assertions.*;

class TrainerTest {

    private static class TestPokemon extends Pokemon {

        public TestPokemon(String name) {
            super(
                    1,
                    name,
                    MoveType.NORMAL,
                    null,
                    300,
                    100,
                    50,
                    20,
                    50,
                    20,
                    50
            );
        }
    }

    @Test
    void shouldCreateTrainer() {

        Trainer trainer = new Trainer("Ash");

        assertEquals(
                "Ash",
                trainer.getName()
        );

        assertTrue(
                trainer.getTeam().isEmpty()
        );
    }

    @Test
    void shouldAddPokemonToTeam()
            throws TeamFullException {

        Trainer trainer = new Trainer("Ash");

        Pokemon pokemon =
                new TestPokemon("Pikachu");

        trainer.addPokemon(pokemon);

        assertEquals(
                1,
                trainer.getTeam().size()
        );

        assertTrue(
                trainer.getTeam().contains(pokemon)
        );
    }

    @Test
    void shouldNotAddDuplicatePokemon()
            throws TeamFullException {

        Trainer trainer = new Trainer("Ash");

        Pokemon pokemon =
                new TestPokemon("Pikachu");

        trainer.addPokemon(pokemon);

        trainer.addPokemon(pokemon);

        assertEquals(
                1,
                trainer.getTeam().size()
        );
    }

    @Test
    void shouldThrowExceptionWhenTeamIsFull()
            throws TeamFullException {

        Trainer trainer = new Trainer("Ash");

        for (int i = 0; i < 6; i++) {

            trainer.addPokemon(
                    new TestPokemon("Pokemon" + i)
            );
        }

        assertThrows(
                TeamFullException.class,
                () -> trainer.addPokemon(
                        new TestPokemon("Extra")
                )
        );
    }

    @Test
    void shouldRemovePokemon() throws TeamFullException {

        Trainer trainer = new Trainer("Ash");

        Pokemon pokemon =
                new TestPokemon("Pikachu");

        trainer.addPokemon(pokemon);

        trainer.removePokemon(0);

        assertTrue(
                trainer.getTeam().isEmpty()
        );
    }

    @Test
    void shouldReturnFirstAlivePokemon()
            throws TeamFullException {

        Trainer trainer = new Trainer("Ash");

        Pokemon pokemon =
                new TestPokemon("Pikachu");

        trainer.addPokemon(pokemon);

        assertEquals(
                pokemon,
                trainer.getFirstAlivePokemon()
        );
    }

    @Test
    void shouldHaveAlivePokemon()
            throws TeamFullException {

        Trainer trainer = new Trainer("Ash");

        trainer.addPokemon(
                new TestPokemon("Pikachu")
        );

        assertTrue(
                trainer.hasAlivePokemons()
        );
    }

    @Test
    void shouldNotHaveAlivePokemon()
            throws TeamFullException {

        Trainer trainer = new Trainer("Ash");

        Pokemon pokemon =
                new TestPokemon("Pikachu");

        trainer.addPokemon(pokemon);

        pokemon.receiveDamage(9999);

        assertFalse(
                trainer.hasAlivePokemons()
        );
    }

}