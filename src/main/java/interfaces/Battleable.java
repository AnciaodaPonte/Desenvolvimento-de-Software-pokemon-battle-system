package interfaces;

public interface Battleable {

    void useMove(int moveIndex, Battleable target);

    void receiveDamage(int damage);

    boolean isFainted();

    int getSpeed();

    String getName();
}