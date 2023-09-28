import java.util.Random;

public abstract class Creature {
    public static final int MIN_ATTACK_DEFENSE_VALUE = 1;
    public static final int MAX_ATTACK_DEFENSE_VALUE = 30;

    protected int attack;
    protected int defense;
    protected int health;
    protected final int minDamage;
    protected final int maxDamage;
    protected Random random;

    public Creature(int attack, int defense, int health, int minDamage, int maxDamage) throws IllegalArgumentException {
        if (attack < MIN_ATTACK_DEFENSE_VALUE || attack > MAX_ATTACK_DEFENSE_VALUE) {
            throw new IllegalArgumentException("Attack is out of range");
        }
        if (defense < MIN_ATTACK_DEFENSE_VALUE || defense > MAX_ATTACK_DEFENSE_VALUE) {
            throw new IllegalArgumentException("Defense is out of range");
        }
        if (health <= 0) {
            throw new IllegalArgumentException("Health must be greater than zero");
        }
        if (minDamage <= 0) {
            throw new IllegalArgumentException("Minimal damage must be greater than zero");
        }
        if (maxDamage <= 0) {
            throw new IllegalArgumentException("Maximal damage must be greater than zero");
        }
        if (minDamage >= maxDamage) {
            throw new IllegalArgumentException("Minimal damage must be smaller than maximal damage");
        }
        random = new Random();
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public boolean hit(Creature enemy) {
        boolean success = false;
        int attackModifier = this.attack - enemy.getDefense() + 1;
        int i = 0;
        do {
            int cast = this.random.nextInt(6) + 1;
            if (cast >= 5) {
                enemy.takeDamage(this.minDamage + this.random.nextInt(this.maxDamage - this.minDamage + 1));
                success = true;
                break;
            }
            i++;
        } while(i < attackModifier);
        return success;
    }

    public void takeDamage(int damage) {
        health = Math.max(health - damage, 0);
    }

    public int getDefense() {
        return defense;
    }
}
