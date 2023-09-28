import java.util.Random;

public abstract class Creature {
    public static final int MIN_ATTACK_DEFENSE_VALUE = 1;
    public static final int MAX_ATTACK_DEFENSE_VALUE = 30;

    protected int attack;
    protected int defense;
    protected int health;
    protected int damage;
    protected Random random;

    public Creature(int N, int M) {
        if (N <= 0) {
            throw new IllegalArgumentException("N must be greater than zero");
        }
        if (M <= 0) {
            throw new IllegalArgumentException("M must be greater than zero");
        }
        if (M >= N) {
            throw new IllegalArgumentException("N must be greater than M");
        }
        random = new Random();
        attack = random.nextInt(MAX_ATTACK_DEFENSE_VALUE) + MIN_ATTACK_DEFENSE_VALUE;
        defense = random.nextInt(MAX_ATTACK_DEFENSE_VALUE) + MIN_ATTACK_DEFENSE_VALUE;
        damage = random.nextInt(N - M) + M;
        health = random.nextInt(N + 1);
    }

    public void hit(Creature enemy) {
        int attackModifier = this.attack - enemy.getDefense() + 1;
    }

    public int getDefense() {
        return defense;
    }
}
