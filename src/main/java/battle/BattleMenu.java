package battle;

import exceptions.TeamFullException;
import pokemon.*;
import trainer.Trainer;

import java.util.Random;
import java.util.Scanner;

public class BattleMenu {

    private final Trainer player = new Trainer("Player");
    private final Trainer enemy = new Trainer("Computer");

    private final BattleSystem battleSystem = new BattleSystem();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1 - Build Team");
            System.out.println("2 - Battle");
            System.out.println("3 - Show My Team");
            System.out.println("0 - Exit");

            int option = readOption(0, 3);

            switch (option) {
                case 1 -> buildPlayerTeam();
                case 2 -> chooseBattle();
                case 3 -> player.showTeam();
                case 0 -> {
                    System.out.println("Exiting game...");
                    return;
                }
            }
        }
    }

    private void buildPlayerTeam() {

        while (true) {

            System.out.println(
                    "\n===== BUILD TEAM ====="
            );

            System.out.println(
                    "Current Team Size: "
                            + player.getTeam().size()
                            + "/6"
            );

            System.out.println("1 - Add Pokemon");
            System.out.println("2 - Reset Team");
            System.out.println("3 - Back");

            int option = readOption(1, 3);

            switch (option) {

                case 1 -> addPokemonToTeam();

                case 2 -> {

                    player.getTeam().clear();

                    System.out.println(
                            "\nTeam reset successfully!"
                    );
                }

                case 3 -> {
                    return;
                }
            }
        }
    }

    private void chooseBattle() {

        if (player.getTeam().isEmpty()) {

            System.out.println("\nBuild your team first!");
            return;
        }

        prepareEnemyTeam();

        battleSystem.startBattle(player, enemy);
    }

    private void prepareEnemyTeam() {

        enemy.getTeam().clear();

        System.out.println("\n===== ENEMY TEAM MODE =====");
        System.out.println("1 - Choose manually");
        System.out.println("2 - Random team");

        int option = readOption(1, 2);

        if (option == 1) {

            System.out.println("\n===== POKEMON DATABASE =====");
            showAllPokemons();

            for (int i = 0; i < 6; i++) {

                System.out.println("\nChoose pokemon " + (i + 1) + " for enemy:");

                int index = readOption(0, PokemonDatabase.POKEMONS.length - 1);

                try {

                    enemy.addPokemon(PokemonFactory.createPokemon(index));

                }
                catch (TeamFullException e) {

                    System.out.println("Team rule error!" + e.getMessage());
                }
                catch (Exception e) {

                    System.out.println("Unexpected error!");
                }
                finally {

                    System.out.println("Operation finished.");
                }
            }
        }
        else {

            Random random = new Random();

            for (int i = 0; i < 6; i++) {

                int index = random.nextInt(PokemonDatabase.POKEMONS.length);

                try {

                    enemy.addPokemon(PokemonFactory.createPokemon(index));

                }
                catch (TeamFullException e) {

                    System.out.println("Team rule error!" + e.getMessage());
                }
                catch (Exception e) {

                    System.out.println("Unexpected error!");
                }
                finally {

                    System.out.println("Operation finished.");
                }
            }
            System.out.println("\nEnemy team generated randomly!");
        }
    }

    private void showAllPokemons() {

        System.out.println(
                "\n===== POKEMON DATABASE ====="
        );

        for (int i = 0; i < PokemonDatabase.POKEMONS.length; i++) {

            String data = PokemonDatabase.POKEMONS[i];

            String[] values = data.split(";");

            int pokemonId = Integer.parseInt(values[0]);

            Pokemon pokemon = PokemonFactory.createPokemon(pokemonId);

            pokemon.showSummary();
        }
    }

    private void addPokemonToTeam() {

        System.out.println("\n===== POKEMON DATABASE =====");

        showAllPokemons();

        System.out.println("\nChoose a Pokemon:");

        int index = readOption(0,PokemonDatabase.POKEMONS.length - 1);

        try {

            //int numb = 1/0;
            player.addPokemon(PokemonFactory.createPokemon(index));
        }
        catch (TeamFullException e) {

            System.out.println("\nTeam rule error!");

            System.out.println(e.getMessage());
        }
        catch (Exception e) {

            System.out.println("\nUnexpected error!");
        }
        finally {

            System.out.println("Operation finished.");
        }
    }

    private int readOption(int min, int max) {

        int option;

        while (true) {

            System.out.print("Escolha: ");

            if (scanner.hasNextInt()) {

                option = scanner.nextInt();

                if (option >= min && option <= max) {
                    return option;
                }
            }
            else {
                scanner.next();
            }

            System.out.println("Opção inválida. Tente novamente.");
        }
    }
}
