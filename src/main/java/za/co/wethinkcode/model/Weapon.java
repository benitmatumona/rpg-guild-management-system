package za.co.wethinkcode.model;

public class Weapon extends Item {

    // TODO: declare private fields:
    // damage (int)
    private int damage;

    // TODO: implement constructor:
    // Weapon(int id, String name, int value, int damage)
    public Weapon(int id, String name, int value, int damage) {
        super(id, name, value);
        this.damage = damage;
    }

    // TODO: implement getters:
    // int getDamage()
    public int getDamage() { return this.damage; }

    // TODO: implement upgradeDamage(int bonusDamage)
    // - increase damage by bonusDamage
    // - throw IllegalArgumentException if bonusDamage < 0
    public void upgradeDamage(int bonusDamage) {
        if (bonusDamage < 0) {
            throw new IllegalArgumentException();
        }
        this.damage += bonusDamage;
    }

    // TODO: override itemType()
    // returns "Weapon"
    @Override
    public String itemType() { return "Weapon"; }

    // TODO: override toString()
    // Example:
    // [Weapon] Sword (ID: 1, Value: 150, Damage: 40)
    @Override
    public String toString() {
        return "[Weapon] " + getName() + " Sword (ID: " + getId() + ", Value: " + getValue() + ", Damage: " + getDamage() + ")";
    }
}