package za.co.wethinkcode.model;

public abstract class Item {

    // TODO: declare private fields:
    // id (int)
    // name (String)
    // value (int)
    private int id;
    private String name;
    private int value;

    // TODO: implement constructor:
    // Item(int id, String name, int value)
    public Item (int id, String name, int value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    // TODO: implement getters:
    // int getId()
    // String getName()
    // int getValue()
    public int getId() { return this.id; }

    public String getName() { return this.name; }

    public int getValue() { return this.value; }

    // TODO: implement updateValue(int newValue)
    // Throws IllegalArgumentException if newValue < 0
    public void updateValue(int newValue) {
        if (newValue < 0) {
            throw new IllegalArgumentException();
        }
        this.value = newValue;
    }

    // TODO: implement abstract method:
    // String itemType()
    public abstract String itemType();

    // TODO: override toString()
    // Example:
    // [Weapon] Sword (ID: 1, Value: 150)
    public String toString() {
        return "[Weapon] " + getName() + " (ID: " + getId() + ", Value: " + getValue() + ")";
    }
}