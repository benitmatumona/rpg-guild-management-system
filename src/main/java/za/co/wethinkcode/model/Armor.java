package za.co.wethinkcode.model;

public class Armor extends Item {

    // TODO: declare private fields:
    // defense (int)
    private int defense;

    // TODO: implement constructor:
    // Armor(int id, String name, int value, int defense)
    public Armor(int id, String name, int value, int defense) {
        super(id, name, value);
        this.defense = defense;
    }

    // TODO: implement getters:
    // int getDefense()
    public int getDefense() {  return this.defense; }

    // TODO: implement upgradeDefense(int bonusDefense)
    // - increase defense by bonusDefense
    // - throw IllegalArgumentException if bonusDefense < 0
    public void upgradeDefense(int bonusDefense) {
        if (bonusDefense < 0) {
            throw new IllegalArgumentException();
        }
        this.defense += bonusDefense;
    }

    // TODO: override itemType()
    // returns "Armor"
    @Override
    public String itemType() { return "Armor"; }

    // TODO: override toString()
    // Example:
    // [Armor] Shield (ID: 2, Value: 120, Defense: 30)
    @Override
    public String toString() {
        return itemType() + " Sword (ID: " + getId() + ", Value: " + getValue() + ", Damage: " + getDefense() + ")";
    }
}