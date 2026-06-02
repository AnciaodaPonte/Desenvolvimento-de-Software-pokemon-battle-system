package pokemon;

import moves.MoveType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {

    private DefaultPokemon crearPokemonDePrueba(int hp, int defense) {
        return new DefaultPokemon(
                1,
                "Pokemon de prueba",
                MoveType.NORMAL,
                null,
                300,
                hp,
                50,
                defense,
                50,
                10,
                60
        );
    }

    private DefaultPokemon crearPokemonPorTipo(
            String nombre,
            MoveType tipo,
            int hp,
            int attack,
            int defense
    ) {
        return new DefaultPokemon(
                1,
                nombre,
                tipo,
                null,
                300,
                hp,
                attack,
                defense,
                40,
                0,
                60
        );
    }

    @Test
    void recibirDanoFisicoDebeReducirElHpCorrectamente() {
        DefaultPokemon pokemon = crearPokemonDePrueba(100, 10);

        pokemon.receiveDamage(30);

        assertEquals(80, pokemon.getHp());
    }

    @Test
    void elHpNuncaDebeQuedarEnValorNegativo() {
        DefaultPokemon pokemon = crearPokemonDePrueba(100, 10);

        pokemon.receiveDamage(500);

        assertEquals(0, pokemon.getHp());
    }

    @Test
    void pokemonConCeroHpDebeQuedarDerrotado() {
        DefaultPokemon pokemon = crearPokemonDePrueba(100, 10);

        pokemon.receiveDamage(500);

        assertTrue(pokemon.isFainted());
        assertFalse(pokemon.isAlive());
    }

    @Test
    void danoMenorQueLaDefensaNoDebeIncrementarElHp() {
        DefaultPokemon pokemon = crearPokemonDePrueba(100, 50);

        pokemon.receiveDamage(30);

        assertEquals(100, pokemon.getHp());
    }

    @Test
    void recibirDanoSoloDebeModificarElHp() {
        DefaultPokemon pokemon = crearPokemonDePrueba(100, 10);

        MoveType tipoInicial = pokemon.getType1();
        int ataqueInicial = pokemon.getAttack();
        int defensaInicial = pokemon.getDefense();
        int ataqueEspecialInicial = pokemon.getSpAttack();
        int defensaEspecialInicial = pokemon.getSpDefense();
        int velocidadInicial = pokemon.getSpeed();

        pokemon.receiveDamage(30);

        assertAll(
                () -> assertEquals(80, pokemon.getHp()),
                () -> assertEquals(tipoInicial, pokemon.getType1()),
                () -> assertEquals(ataqueInicial, pokemon.getAttack()),
                () -> assertEquals(defensaInicial, pokemon.getDefense()),
                () -> assertEquals(ataqueEspecialInicial, pokemon.getSpAttack()),
                () -> assertEquals(defensaEspecialInicial, pokemon.getSpDefense()),
                () -> assertEquals(velocidadInicial, pokemon.getSpeed())
        );
    }

    @Test
    void ataqueDeFuegoContraPlantaDebeSerSuperEfectivo() {
        DefaultPokemon atacante =
                crearPokemonPorTipo("Charmander", MoveType.FIRE, 500, 50, 0);
        DefaultPokemon objetivo =
                crearPokemonPorTipo("Bulbasaur", MoveType.GRASS, 500, 50, 0);

        atacante.useMove(1, objetivo);

        assertEquals(300, objetivo.getHp());
    }

    @Test
    void ataqueDeFuegoContraAguaDebeSerPocoEfectivo() {
        DefaultPokemon atacante =
                crearPokemonPorTipo("Charmander", MoveType.FIRE, 500, 50, 0);
        DefaultPokemon objetivo =
                crearPokemonPorTipo("Squirtle", MoveType.WATER, 500, 50, 0);

        atacante.useMove(1, objetivo);

        assertEquals(450, objetivo.getHp());
    }

    @Test
    void ataqueDeFuegoContraTipoNormalDebeMantenerDanoNeutro() {
        DefaultPokemon atacante =
                crearPokemonPorTipo("Charmander", MoveType.FIRE, 500, 50, 0);
        DefaultPokemon objetivo =
                crearPokemonPorTipo("Eevee", MoveType.NORMAL, 500, 50, 0);

        atacante.useMove(1, objetivo);

        assertEquals(400, objetivo.getHp());
    }

    @Test
    void ataqueElectricoContraTierraNoDebeCausarDano() {
        DefaultPokemon atacante =
                crearPokemonPorTipo("Pikachu", MoveType.ELECTRIC, 500, 50, 0);
        DefaultPokemon objetivo =
                crearPokemonPorTipo("Sandshrew", MoveType.GROUND, 500, 50, 0);

        atacante.useMove(1, objetivo);

        assertEquals(500, objetivo.getHp());
    }

    @Test
    void ataqueCompletoSoloDebeModificarElHpDelObjetivo() {
        DefaultPokemon atacante =
                crearPokemonPorTipo("Charmander", MoveType.FIRE, 500, 50, 0);
        DefaultPokemon objetivo =
                crearPokemonPorTipo("Eevee", MoveType.NORMAL, 500, 50, 0);

        int hpInicialAtacante = atacante.getHp();

        MoveType tipoInicialObjetivo = objetivo.getType1();
        int ataqueInicialObjetivo = objetivo.getAttack();
        int defensaInicialObjetivo = objetivo.getDefense();
        int ataqueEspecialInicialObjetivo = objetivo.getSpAttack();
        int defensaEspecialInicialObjetivo = objetivo.getSpDefense();
        int velocidadInicialObjetivo = objetivo.getSpeed();

        atacante.useMove(1, objetivo);

        assertAll(
                () -> assertEquals(hpInicialAtacante, atacante.getHp()),
                () -> assertEquals(400, objetivo.getHp()),
                () -> assertEquals(tipoInicialObjetivo, objetivo.getType1()),
                () -> assertEquals(ataqueInicialObjetivo, objetivo.getAttack()),
                () -> assertEquals(defensaInicialObjetivo, objetivo.getDefense()),
                () -> assertEquals(ataqueEspecialInicialObjetivo, objetivo.getSpAttack()),
                () -> assertEquals(defensaEspecialInicialObjetivo, objetivo.getSpDefense()),
                () -> assertEquals(velocidadInicialObjetivo, objetivo.getSpeed())
        );
    }
}