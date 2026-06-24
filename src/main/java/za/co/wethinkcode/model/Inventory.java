package za.co.wethinkcode.model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    // TODO: declare private fields:
    // items (List<Item>)
    private List<Item> items;

    // TODO: implement constructor:
    // Inventory()
    // - initialise items as new ArrayList<>()
    public Inventory() {
        this.items = new ArrayList<>();
    }

    // TODO: implement addItem(Item item)
    // - add item to list
    public void addItem(Item item) {
        this.items.add(item);
    }

    // TODO: implement removeItemById(int itemId)
    // - remove item with matching id
    // - return true if removed, false otherwise
    public boolean removeItemById(int itemId) {
        for (Item item : items) {
            if (item.getId() == itemId) {
                items.remove(item);
                return true;
            }
        }
        return false;
    }

    // TODO: implement getItemById(int itemId)
    // - return Item if found, else null
    public Item getItemById(int itemId) {
        for (Item item : items) {
            if (item.getId() == itemId) {
                return item;
            }
        }
        return null;
    }


    // TODO: implement getItems()
    // - return defensive copy of list
    public List<Item> getItems() { return new ArrayList<>(items); }

    // TODO: implement getTotalValue()
    // - sum of all item values
    public int getTotalValue() {
        int total = 0;

        for (Item item : items) {
            total += item.getValue();
        }
        return total;
    }

    // TODO: implement getTotalItems()
    // - return size of inventory
    public int getTotalItems() { return items.size(); }

    // TODO: implement containsItem(String itemName)
    // - return true if any item matches name
    public boolean containsItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                return true;
            }
        }
        return false;
    }

    // TODO: override toString()
    // Example:
    // Inventory:
    // - Sword (ID: 1)
    // - Shield (ID: 2)
}