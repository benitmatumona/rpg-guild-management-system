package za.co.wethinkcode.model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Item> items;



    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item){
        items.add(item);
    }


    public boolean removeItemById(int itemId){
        return items.removeIf(item -> item.getId() == itemId);
    }

    public Item  getItemById(int itemId){
        for (Item item: items){
            if (item.getId() == itemId){
                return item;
            }
            }
        return null;
    }

    public List<Item> getItems(){
        return new ArrayList<>(this.items);
    }

    public int getTotalValue(){
        int sum_values = 0;
        for(Item item: items){
            sum_values += item.getValue();
        }
        return sum_values;
    }

    public int getTotalItems(){
        return items.size();
    }

    public boolean containsItem(String itemName){
        for (Item item: items){
            if(item.getName().equals(itemName)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Inventory:\n");
        if (items.isEmpty()) {
            sb.append(" (empty)");
        } else {
            for (Item item : items) {
                sb.append(" - ").append(item.getName()).append(" (ID: ").append(item.getId()).append(")\n");
            }
        }
        return sb.toString().trim();
    }
    }