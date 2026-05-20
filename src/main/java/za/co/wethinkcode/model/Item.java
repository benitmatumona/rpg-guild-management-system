package za.co.wethinkcode.model;

public abstract class Item {
    private int id;
    private String name;
    private int value;

    public Item(String name, int id, int value) {
        this.name = name;
        this.id = id;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void updateValue(int newValue) {
        if (newValue < 0) {
        throw new IllegalArgumentException("The value cannot be negative");
        }
    }

    public abstract String itemType();

    @Override
    public String toString(){
        return "[" + itemType() + "]" + getName() + " (ID: " + getId() + ", Value: " + getValue() +")";
    }

}