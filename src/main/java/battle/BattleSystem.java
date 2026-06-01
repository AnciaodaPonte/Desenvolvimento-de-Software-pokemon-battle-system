package battle;

import pokemon.Pokemon;
import trainer.Trainer;

import java.util.Random;
import java.util.Scanner;

public class BattleSystem {

    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();

    public void startBattle(Trainer playerTrainer, Trainer enemyTrainer) {

        Pokemon player = playerTrainer.getFirstAlivePokemon();
        Pokemon enemy = enemyTrainer.getFirstAlivePokemon();

        System.out.println("\n===== BATTLE START =====");

        while (player != null && enemy != null) {

            System.out.println("\n====================");
            System.out.println(player.getName() + " VS " + enemy.getName());
            System.out.println("====================");
            System.out.println(player.getName() + " HP: " + player.getHp());
            System.out.println(enemy.getName() + " HP: " + enemy.getHp());

            System.out.println("\n1 - Attack");
            System.out.println("2 - Switch Pokemon");

            int option = readOption(1, 2);

            if (option == 2) {
                Pokemon newPokemon = playerTrainer.choosePokemon(scanner);

                if (newPokemon != null && !newPokemon.isFainted()) {
                    player = newPokemon;
                    System.out.println("Go " + player.getName() + "!");
                }

                continue;
            }

            player.showMoves();

            int playerMove = readOption(0, 3);

            boolean playerFirst = isPlayerFirst(player, enemy);

            if (playerFirst) {
                attackIfAlive(player, playerMove, enemy);

                if (!enemy.isFainted()) {
                    int enemyMove = random.nextInt(4);
                    attackIfAlive(enemy, enemyMove, player);
                }
            } else {
                int enemyMove = random.nextInt(4);
                attackIfAlive(enemy, enemyMove, player);

                if (!player.isFainted()) {
                    attackIfAlive(player, playerMove, enemy);
                }
            }

            if (player.isFainted()) {
                System.out.println(player.getName() + " fainted!");

                player = playerTrainer.getFirstAlivePokemon();

                if (player != null) {
                    System.out.println("Go " + player.getName() + "!");
                }
            }

            if (enemy.isFainted()) {
                System.out.println(enemy.getName() + " fainted!");

                enemy = enemyTrainer.getFirstAlivePokemon();

                if (enemy != null) {
                    System.out.println("Enemy sent " + enemy.getName() + "!");
                }
            }
        }

        if (player == null) {
            System.out.println("\nYou lost the battle!");
        } else {
            System.out.println("\nYou won the battle!");
        }
    }

    public boolean isPlayerFirst(Pokemon player, Pokemon enemy) {
        if (player.getSpeed() > enemy.getSpeed()) {
            return true;
        }

        if (enemy.getSpeed() > player.getSpeed()) {
            return false;
        }

        return random.nextBoolean();
    }

    public boolean isBattleOver(Pokemon player, Pokemon enemy) {
        return player.isFainted() || enemy.isFainted();
    }

    public Pokemon getWinner(Pokemon player, Pokemon enemy) {
        if (player.isFainted()) {
            return enemy;
        }

        if (enemy.isFainted()) {
            return player;
        }

        return null;
    }

    public void attackIfAlive(Pokemon attacker, int moveIndex, Pokemon target) {
        if (!attacker.isFainted()) {
            attacker.useMove(moveIndex, target);
        }
    }

    private int readOption(int min, int max) {

        int option;

        while (true) {

            System.out.print("> ");

            if (scanner.hasNextInt()) {

                option = scanner.nextInt();

                if (option >= min && option <= max) {
                    return option;
                }
            } else {
                scanner.next();
            }

            System.out.println("Invalid option.");
        }
    }
}