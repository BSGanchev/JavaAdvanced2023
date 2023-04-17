package SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Double>> productShopMap = new TreeMap<>();

        while (!input.equals("Revision")) {
            String shopName = input.split(", ")[0];
            String productName = input.split(", ")[1];
            Double productPrice = Double.parseDouble(input.split(", ")[2]);

            if (!productShopMap.containsKey(shopName)) {
                productShopMap.put(shopName, new LinkedHashMap<>());
                productShopMap.get(shopName).put(productName, productPrice);
            } else {
                productShopMap.get(shopName).put(productName, productPrice);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Double>> entry : productShopMap.entrySet()) {
            System.out.printf("%s->%n", entry.getKey());
            for (Map.Entry<String, Double> stringDoubleEntry : entry.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", stringDoubleEntry.getKey(), stringDoubleEntry.getValue());
            }
        }
    }
}
