package za.co.wethinkcode;

import za.co.wethinkcode.model.Item;
import za.co.wethinkcode.model.Weapon;
import za.co.wethinkcode.model.Armor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

    @Test
    void testWeaponCreation() {
        Weapon weapon = new Weapon(1, "Sword", 100, 25);

        assertEquals(1, weapon.getId());
        assertEquals("Sword", weapon.getName());
        assertEquals(100, weapon.getValue());
        assertEquals(25, weapon.getDamage());
        assertEquals("Weapon", weapon.itemType());
    }

    @Test
    void testArmorCreation() {
        Armor armor = new Armor(2, "Shield", 80, 15);

        assertEquals(2, armor.getId());
        assertEquals("Shield", armor.getName());
        assertEquals(80, armor.getValue());
        assertEquals(15, armor.getDefense());
        assertEquals("Armor", armor.itemType());
    }

    @Test
    void testUpgradeWeaponDamage() {
        Weapon weapon = new Weapon(1, "Axe", 120, 30);
        weapon.upgradeDamage(10);

        assertEquals(40, weapon.getDamage());
    }

    @Test
    void testUpgradeArmorDefense() {
        Armor armor = new Armor(2, "Helmet", 60, 10);
        armor.upgradeDefense(5);

        assertEquals(15, armor.getDefense());
    }

    @Test
    void testInvalidWeaponUpgrade() {
        Weapon weapon = new Weapon(1, "Bow", 90, 20);

        assertThrows(IllegalArgumentException.class, () -> {
            weapon.upgradeDamage(-5);
        });
    }

    @Test
    void testInvalidArmorUpgrade() {
        Armor armor = new Armor(2, "Chestplate", 110, 40);

        assertThrows(IllegalArgumentException.class, () -> {
            armor.upgradeDefense(-10);
        });
    }
}