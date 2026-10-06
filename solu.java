import java.util.HashMap;
import java.util.Map;

public class InventoryManager {

    public static Object updateInventory(Map<String, Integer> inventory, Map<String, Integer> purchases) {
        for (Map.Entry<String, Integer> entry : purchases.entrySet()) {
            String item = entry.getKey();
            int qty = entry.getValue();

            if (inventory.containsKey(item) && inventory.get(item) >= qty) {
                inventory.put(item, inventory.get(item) - qty);
            } else {
                return "Error: Not enough stock for " + item;
            }
        }
        return inventory;
    }

    public static void main(String[] args) {
        Map<String, Integer> inventory1 = new HashMap<>();
        inventory1.put("Laptop", 10);
        inventory1.put("Phone", 5);

        Map<String, Integer> purchases1 = new HashMap<>();
        purchases1.put("Laptop", 3);
        purchases1.put("Phone", 2);

        System.out.println(updateInventory(inventory1, purchases1));
        // Expected: {Laptop=7, Phone=3}

        Map<String, Integer> inventory2 = new HashMap<>();
        inventory2.put("Laptop", 2);

        Map<String, Integer> purchases2 = new HashMap<>();
        purchases2.put("Laptop", 5);

        System.out.println(updateInventory(inventory2, purchases2));
        // Expected: Error: Not enough stock for Laptop
    }
}
