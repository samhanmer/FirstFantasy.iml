import java.util.HashMap;

public class Inventory {
    private HashMap<String, Integer> item = new HashMap<>();

    public void addItem(String name, int quantity) { //adds items to inventory
        item.put(name, item.getOrDefault(name, 0) + quantity);
    }

    public int getQuantity(String name) {  //gets the quantity of items
        return item.getOrDefault(name, 0);
    }

    public void printInventory() {  //planning on implementing soon!
        System.out.println("Backpack:");
        item.forEach((key, value) ->System.out.println(key + ": " + value));
    }
}
