package za.co.wethinkcode.model;

public class Player {

    public enum PlayerRank {
        BRONZE,
        SILVER,
        GOLD,
        DIAMOND
    }

    // TODO: declare private fields:
    // id (int)
    // name (String)
    // level (int)
    // xp (int)
    // gold (int)
    // rank (PlayerRank)
    // inventory (Inventory)
    // equippedWeapon (Weapon)
    // equippedArmor (Armor)
    private int id;
    private String name;
    private int level;
    private int xp;
    private int gold;
    private PlayerRank rank;
    private Inventory inventory;
    private Weapon equippedWeapon;
    private Armor equippedArmor;

    // TODO: implement constructor:
    // Player(int id, String name)
    // - initialise level = 1
    // - xp = 0
    // - gold = 0
    // - rank = BRONZE
    // - inventory = new Inventory()
    public Player (int id, String name) {
        this.id = id;
        this.name = name;
        this.level = 1;
        this.xp = 0;
        this.gold = 0;
        this.rank = PlayerRank.BRONZE;
        this.inventory = new Inventory();
    }

    // TODO: implement getters:
    // int getId()
    // String getName()
    // int getLevel()
    // int getXp()
    // int getGold()
    // PlayerRank getRank()
    // Inventory inventory()
    public int getId() { return this.id; }
    public String getName() { return this.name; }
    public int getLevel() { return this.level; }
    public int getXp() { return this.xp; }
    public int getGold() { return this.gold; }
    public PlayerRank getRank() { return this.rank; }
    public Inventory inventory() { return this.inventory; }

    // TODO: implement addExperience(int xp)
    // - add xp
    // - call levelUp() when threshold reached
    public void addExperience(int xp) { 
        this.xp += xp;
        
        while(this.xp >= 100) {
            levelUp();
        }
    }

    // TODO: implement levelUp()
    // - increase level by 1
    // - reset or reduce xp appropriately (your design should be consistent with tests)
    public void levelUp() {
        level++;
        this.xp -= 100;
    }
    
    // TODO: implement addGold(int gold)
    // - increase gold
    public void addGold(int gold) { this.gold += gold; }

    // TODO: implement spendGold(int amount)
    // - throw IllegalArgumentException if insufficient gold
    public void spendGold(int amount) {
        if (this.gold < amount) {
            throw new IllegalArgumentException();
        }
        this.gold -= amount;
    }

    // TODO: implement equipWeapon(Weapon weapon)
    public void equipWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
    }

    // TODO: implement equipArmor(Armor armor)
    public void equipArmor(Armor armor) {
        this.equippedArmor = armor;
    }

    // TODO: implement updateRank(PlayerRank rank)
    public void updateRank(PlayerRank rank) {
        this.rank = rank;
    }

    // TODO: override toString()
    // Example:
    // Player: John (Level 3, Rank GOLD)
    @Override
    public String toString() {
        return "Player: " + getName() + " (Level " + getLevel() + ", Rank " + getRank() + ")";
    }
}