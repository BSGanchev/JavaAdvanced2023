package GenericsExercise.P07CustomList;

import java.util.Scanner;

public class Main {
    public static final String END = "END";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String commandLine = scanner.nextLine();
        CustomList<String> customList = new CustomList<String>();
        while (!commandLine.equals(END)) {
            String[] command = commandLine.split("\\s+");
            switch (command[0]) {
                case "Add":
                    customList.add(command[1]);
                    break;
                case "Remove":
                    customList.remove(Integer.parseInt(command[1]));
                    break;
                case "Contains":
                    System.out.println(customList.contains(command[1]));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(command[1]);
                    int secondIndex = Integer.parseInt(command[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    System.out.println(customList.countGreaterThan(command[1]));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    for (String current : customList) {
                        System.out.println(current);
                    }
                    break;
                case "Sort":
                    Sorted.sort(customList);
                    break;
            }
            commandLine = scanner.nextLine();
        }
    }
}
