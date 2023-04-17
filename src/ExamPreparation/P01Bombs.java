package ExamPreparation;

import java.util.*;

public class P01Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> effectQueue = new ArrayDeque<>();
        List<Integer> casingStack = new ArrayList<>();
        Map<String, Integer> bombs = new TreeMap<>(Map.of("Cherry Bombs", 0,
                "Datura Bombs", 0, "Smoke Decoy Bombs", 0));

        Integer[] effect = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).toArray(Integer[]::new);
        Collections.addAll(effectQueue, effect);
        Integer[] casing = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).toArray(Integer[]::new);
        Collections.addAll(casingStack, casing);

        while (!effectQueue.isEmpty() && !casingStack.isEmpty() && !bombsReady(bombs)) {
            int bomb = effectQueue.peek() + casingStack.get(casingStack.size() - 1);

            if (bomb == 40) {
                effectQueue.pop();
                casingStack.remove(casingStack.size() - 1);
                bombs.put("Datura Bombs", bombs.get("Datura Bombs") + 1);
            } else if (bomb == 60) {
                effectQueue.pop();
                casingStack.remove(casingStack.size() - 1);
                bombs.put("Cherry Bombs", bombs.get("Cherry Bombs") + 1);
            } else if (bomb == 120) {
                effectQueue.pop();
                casingStack.remove(casingStack.size() - 1);
                bombs.put("Smoke Decoy Bombs", bombs.get("Smoke Decoy Bombs") + 1);
            } else {
                casingStack.set(casingStack.size() - 1, casingStack.get(casingStack.size() - 1) - 5);
            }

        }
        if (!bombsReady(bombs)) {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        } else {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }
        System.out.print("Bomb Effects: ");
        if (effectQueue.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println(effectQueue.toString().replaceAll("[\\[\\]]", ""));
        }
        System.out.print("Bomb Casings: ");
        if (casingStack.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println(casingStack.toString().replaceAll("[\\[\\]]", ""));
        }
        for (Map.Entry<String, Integer> entry : bombs.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }
    private static boolean bombsReady(Map<String, Integer> bombsMap) {
        return bombsMap.get("Cherry Bombs") >= 3 &&
                bombsMap.get("Datura Bombs") >= 3 &&
                bombsMap.get("Smoke Decoy Bombs") >= 3;
    }
}
