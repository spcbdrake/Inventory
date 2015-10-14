import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by benjamindrake on 10/12/15.
 */
public class Inventory {
    public static void main(String [] args) {
        ArrayList<InventoryItem> inventory = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        String[] responses = new String[]{
                    "You dun goofed",
                    "Sweet Jesus,",
                    "What the fuck man?",
                    "What the shit Vladimir?"
        };

        Random newRandom = new Random();

        while (true) {
            if (inventory.size() == 0) {
                System.out.println("Nothing in inventory");
            } else {
                for (InventoryItem invItem : inventory) {
                    System.out.println(String.format("[%d] %s %s", invItem.quantity, invItem.text,invItem.category));
                }
            }

            System.out.println("Options :");
            System.out.println("[1] Create a new item");
            System.out.println("[2] Remove an item");
            System.out.println("[3] Update an item's quantity");

            String option = scanner.nextLine();
            int optionNum= Integer.valueOf(option);

            if (optionNum == 1) {
                InventoryItem item = null;
                System.out.println("Please enter item name.");
                String name = scanner.nextLine();
                System.out.println("Please enter quantity.");
                String qua = scanner.nextLine();
                int quaNum = Integer.valueOf(qua);
                String cat = "";
                boolean isValid = false;
                while (!isValid)
                {
                    System.out.println("Please enter item category");
                    cat = scanner.nextLine();
                    if (cat.toLowerCase().equals("cars")) {
                        item = new Cars(name, quaNum);
                        isValid = true;
                    } else if (cat.toLowerCase().equals("shoes")) {
                        item= new Shoes(name, quaNum);
                        isValid = true;
                    } else if (cat.toLowerCase().equals("guns")) {
                        item = new Guns(name, quaNum);
                        isValid = true;
                    } else if (cat.toLowerCase().equals("beer")) {
                        item = new Beer(name, quaNum);
                        isValid = true;
                    } else if (cat.toLowerCase().equals("movies")) {
                        item = new Movies(name, quaNum);
                        isValid = true;
                    }
                    else {
                        System.out.println(responses[newRandom.nextInt(responses.length)]);
                    }
                }
                inventory.add(item);
            }

            else if (optionNum == 2) {
                System.out.println("Please enter the line number of the item you wish to remove.");
                String remove = scanner.nextLine();
                try {
                    int removeNum = Integer.valueOf(remove);
                    InventoryItem item = inventory.get(removeNum - 1);
                    inventory.remove(item);
                } catch (Exception e) {
                    System.out.println("An error occured");
                }

            }
            else if (optionNum == 3) {
                System.out.println("Enter the line number of the item you wish to update");
                for (InventoryItem updateQua : inventory) {
                    System.out.println(updateQua.quantity + updateQua.text);
                }
                String update = scanner.nextLine();
                try {
                    int updateNum = Integer.valueOf(update);
                    InventoryItem item = inventory.get(updateNum - 1);
                    System.out.println("Enter updated quantity");
                    String updateamount = scanner.nextLine();
                    int updateamountNum = Integer.valueOf(updateamount);
                    item.quantity = updateamountNum;
                } catch (Exception e) {
                    System.out.println("An error occured");
                }
            }

        }


    }
}
