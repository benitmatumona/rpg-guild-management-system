package za.co.wethinkcode.model;

public class Armor extends Item {

    private int defense;

    public Armor(int id, String name, int value, int defense){
        super(name, id, value);
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    public void upgradeDefense(int bonusDefense){
        if (bonusDefense < 0){
            throw new IllegalArgumentException(" bonusDefence cannot be negative");
        }
        defense += bonusDefense;
    }

    @Override
    public String itemType(){
        return "Armor";
    }

    @Override
    public String toString(){
        return "[" + itemType() + "]" + getName() + "(ID: " + getId() + ", Value: " + getValue() + ", Defence: " + getDefense() + ")";
    }

}