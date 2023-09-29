public class Player extends Creature {
    public static final float MAX_HEAL_RATIO = 0.3f;
    private int healCounter = 4;
    private final int maxHealth;
    private final int healValue;
    public Player(int attack, int defense, int health, int minDamage, int maxDamage) throws IllegalArgumentException {
        super(attack, defense, health, minDamage, maxDamage);
        maxHealth = health;
        healValue = Math.round(maxHealth * MAX_HEAL_RATIO);
    }

    public boolean canHeal() {
        return healCounter > 0;
    }

    public int heal() {
        int healValue = Math.min(maxHealth - health, this.healValue);
        if (canHeal()) {
            health += healValue;
            healCounter--;
            return healValue;
        }
        return 0;
    }

    public boolean isGoodTimeToHeal() {
        return maxHealth - health >= healValue;
    }
}
