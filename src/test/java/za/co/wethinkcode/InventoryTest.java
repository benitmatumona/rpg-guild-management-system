// FILE: src/test/java/za/co/wethinkcode/InventoryTest.java

package za.co.wethinkcode;

import za.co.wethinkcode.model.Inventory;
import za.co.wethinkcode.model.Weapon;
import za.co.wethinkcode.model.Armor;
import za.co.wethinkcode.model.Item;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {

    @Test
    void testAddItem() {
        Inventory inventory = new Inventory();

        Weapon sword = new Weapon(1, "Sword", 100, 20);
        inventory.addItem(sword);

        assertEquals(1, inventory.getTotalItems());
        assertEquals(100, inventory.getTotalValue());
    }

    @Test
    void testGetItemById() {
        Inventory inventory = new Inventory();

        inventory.addItem(new Weapon(1, "Sword", 100, 20));

        Item item = inventory.getItemById(1);

        assertNotNull(item);
        assertEquals("Sword", item.getName());
    }

    @Test
    void testRemoveItemById() {
        Inventory inventory = new Inventory();

        inventory.addItem(new Weapon(1, "Sword", 100, 20));

        boolean removed = inventory.removeItemById(1);

        assertTrue(removed);
        assertEquals(0, inventory.getTotalItems());
    }

    @Test
    void testRemoveItemNotFound() {
        Inventory inventory = new Inventory();

        boolean removed = inventory.removeItemById(999);

        assertFalse(removed);
    }

    @Test
    void testContainsItem() {
        Inventory inventory = new Inventory();

        inventory.addItem(new Armor(2, "Shield", 80, 10));

        assertTrue(inventory.containsItem("Shield"));
        assertFalse(inventory.containsItem("Sword"));
    }

    @Test
    void testGetItemsDefensiveCopy() {
        Inventory inventory = new Inventory();

        inventory.addItem(new Weapon(1, "Sword", 100, 20));

        List<Item> items = inventory.getItems();
        items.clear(); // try to break internal state

        assertEquals(1, inventory.getTotalItems());
    }

    @Test
    void testTotalValueMultipleItems() {
        Inventory inventory = new Inventory();

        inventory.addItem(new Weapon(1, "Sword", 100, 20));
        inventory.addItem(new Armor(2, "Shield", 50, 10));

        assertEquals(150, inventory.getTotalValue());
    }
}