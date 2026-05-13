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

    // TODO: implement constructor:
    // Player(int id, String name)
    // - initialise level = 1
    // - xp = 0
    // - gold = 0
    // - rank = BRONZE
    // - inventory = new Inventory()

    // TODO: implement getters:
    // int getId()
    // String getName()
    // int getLevel()
    // int getXp()
    // int getGold()
    // PlayerRank getRank()
    // Inventory inventory()

    // TODO: implement addExperience(int xp)
    // - add xp
    // - call levelUp() when threshold reached

    // TODO: implement levelUp()
    // - increase level by 1
    // - reset or reduce xp appropriately (your design should be consistent with tests)

    // TODO: implement addGold(int gold)
    // - increase gold

    // TODO: implement spendGold(int amount)
    // - throw IllegalArgumentException if insufficient gold

    // TODO: implement equipWeapon(Weapon weapon)

    // TODO: implement equipArmor(Armor armor)

    // TODO: implement updateRank(PlayerRank rank)

    // TODO: override toString()
    // Example:
    // Player: John (Level 3, Rank GOLD)
}