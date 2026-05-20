package za.co.wethinkcode.model;

public class Player {

    public enum PlayerRank {
        BRONZE,
        SILVER,
        GOLD,
        DIAMOND
    }
    private int id;
    private String name;
    private int level;
    private  int xp;
    private int gold;
    private  PlayerRank rank;
    private  Inventory inventory;
    private Weapon equippedWeapon;
    private Armor equippedArmor;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        this.level = 1;
        this.xp = 0;
        this.rank = PlayerRank.BRONZE;
        this.inventory = new Inventory();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getXp() {
        return xp;
    }

    public int getGold() {
        return gold;
    }

    public PlayerRank getRank() {
        return rank;
    }

    public Inventory inventory() {
        return inventory;
    }

    public Weapon equipWeapon() {
        return equippedWeapon;
    }

    public Armor equipArmor() {
        return equippedArmor;
    }


    public void  addExperience(int xp){
        this.xp += xp;
        while (this.xp >= 100){
            LevelUp();
        }
    }

    // - call levelUp() when threshold reached

    public void LevelUp() {
        this.level += 1;
        this.xp -= 100;
    }



    // TODO: implement levelUp()
    // - increase level by 1
    // - reset or reduce xp appropriately (your design should be consistent with tests)

    public void addGold(int gold) {
        this.gold += gold;
    }

    public void spendGold(int amount){
        if(amount > gold){
            throw new IllegalArgumentException("insufficient gold");
        }
        this.gold -= amount;
    }

    public void equipWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
    }

    public void equipArmor(Armor armor) {
        this.equippedArmor = armor;
    }

    public void updateRank(PlayerRank rank) {
        this.rank = rank;
    }
    @Override
    public String toString(){
        return "Player: " + this.name + " (" + "Level " + this.level + ", Rank " + this.rank + ")";
    }

    // TODO: override toString()
    // Example:
    // Player: John (Level 3, Rank GOLD)
}