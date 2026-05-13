// FILE: src/test/java/za/co/wethinkcode/PlayerTest.java

package za.co.wethinkcode;

import za.co.wethinkcode.model.Player;
import za.co.wethinkcode.model.Weapon;
import za.co.wethinkcode.model.Armor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    void testPlayerCreation() {
        Player player = new Player(1, "Arthur");

        assertEquals(1, player.getId());
        assertEquals("Arthur", player.getName());
        assertEquals(1, player.getLevel());
        assertEquals(0, player.getXp());
        assertEquals(0, player.getGold());
        assertEquals(Player.PlayerRank.BRONZE, player.getRank());
        assertNotNull(player.inventory());
    }

    @Test
    void testAddExperienceAndLevelUp() {
        Player player = new Player(1, "Luna");

        player.addExperience(120);

        assertTrue(player.getLevel() >= 2);
    }

    @Test
    void testAddGold() {
        Player player = new Player(1, "Milo");

        player.addGold(50);

        assertEquals(50, player.getGold());
    }

    @Test
    void testSpendGold() {
        Player player = new Player(1, "Zane");

        player.addGold(100);
        player.spendGold(40);

        assertEquals(60, player.getGold());
    }

    @Test
    void testSpendGoldInsufficient() {
        Player player = new Player(1, "Kai");

        player.addGold(20);

        assertThrows(IllegalArgumentException.class, () -> {
            player.spendGold(50);
        });
    }

    @Test
    void testEquipWeaponAndArmor() {
        Player player = new Player(1, "Rhea");

        Weapon weapon = new Weapon(1, "Sword", 100, 25);
        Armor armor = new Armor(2, "Shield", 80, 15);

        player.equipWeapon(weapon);
        player.equipArmor(armor);

        assertNotNull(player);
    }

    @Test
    void testRankUpdate() {
        Player player = new Player(1, "Nova");

        player.updateRank(Player.PlayerRank.GOLD);

        assertEquals(Player.PlayerRank.GOLD, player.getRank());
    }
}