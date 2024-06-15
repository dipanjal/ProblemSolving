package com.dipanjal.breadit.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author dipanjal
 * @since 6/2/2021
 */

public class Test2 {

    private static class Item {
        private String type;
        private String name;

        public Item(String type, String name) {
            this.type = type;
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void process(List<Item> itemList) {
        Map<String, List<Item>> data = itemList
                .stream()
                .collect(Collectors.groupingBy(Item::getType));
        TreeMap<String, List<Item>> sorted = new TreeMap<>(data);
        sorted.forEach((key, items) -> {
            System.out.println(String.format("-Type=%s", key));
            items.forEach(item -> System.out.println(String.format("\t-Name=%s", item.getName())));
        });

    }

    public static void main(String[] args) {
        process(List.of(
                new Item("Fruit", "Orange"),
                new Item("Fruit", "Apple"),
                new Item("Fruit", "Banana"),
                new Item("Animal", "Tiger"),
                new Item("Animal", "Dog"),
                new Item("Vehicle", "Car"),
                new Item("Vehicle", "Boat"),
                new Item("Vehicle", "Plane")
        ));
    }


}
