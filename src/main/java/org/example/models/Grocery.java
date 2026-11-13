package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public static void addItems(String input) {
        for (String raw : input.split(",")) {
            String item = raw.trim();
            if (!item.isEmpty() && !checkItemIsInList(item)) {
                groceryList.add(item);
            }
        }
        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        for (String raw : input.split(",")) {
            String item = raw.trim();
            groceryList.remove(item);
        }
        Collections.sort(groceryList);
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println(groceryList);
    }
}
