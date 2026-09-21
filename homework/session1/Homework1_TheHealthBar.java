/*
 * Category C Assignment - Problem 1: The Health Bar
 * Health is private, clamped between 0 and a final maximum; the only
 * mutators are takeDamage() and heal(), both computed-then-clamped.
 */
public class Homework1_TheHealthBar {
    public static void main(String[] args) {
        GameCharacter c = new GameCharacter(100);
        c.takeDamage(30);
        System.out.println(c.getHealth());
        c.heal(50);
        System.out.println(c.getHealth());
        c.takeDamage(150);
        System.out.println(c.getHealth());
    }
}

class GameCharacter {
    private final int maxHealth;
    private int health;

    GameCharacter(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    void takeDamage(int amount) {
        health = Math.max(0, health - amount);
    }

    void heal(int amount) {
        health = Math.min(maxHealth, health + amount);
    }

    int getHealth() {
        return health;
    }
}
