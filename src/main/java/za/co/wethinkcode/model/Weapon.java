package za.co.wethinkcode.model;

public class Weapon extends Item {

    private int damage;


    public Weapon(int id, String name, int value, int damage){
        super(name, id, value);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void upgradeDamage(int bonusDamage){
        if (bonusDamage < 0){
            throw new IllegalArgumentException("bonus Damage can not be negative");
        }
        damage += bonusDamage;
    }
    // TODO: override itemType()
    // returns "Weapon"
    @Override
    public String itemType(){
        return "Weapon";
    }

    @Override
    public String toString(){
        return "[Weapon] " + getName() + " (ID: " + getId() + ", Value: " + getValue() + ", Damage: " + getDamage() + ")";
    }
    //
}