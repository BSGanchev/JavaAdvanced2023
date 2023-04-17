package IteratorsAndComparatorsExercise.P08PetClinics;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Pet> petMap = new LinkedHashMap<>();
        Map<String, Clinic> clinicMap = new LinkedHashMap<>();
        while (n -- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String command = data[0];
            switch (command) {
                case "Create":
                    if (data[1].equals("Pet")) {
                        String name = data[2];
                        int age = Integer.parseInt(data[3]);
                        String kind = data[4];
                        Pet pet = new Pet(name, age, kind);
                        petMap.put(name, pet);
                    } else {
                        String name = data[2];
                        int rooms = Integer.parseInt(data[3]);
                        try {
                            Clinic clinic = new Clinic(rooms);
                            clinicMap.put(name, clinic);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case "Add":
                    System.out.println(clinicMap.get(data[2]).add(petMap.get(data[1])));
                    break;
                case "Release":
                    System.out.println(clinicMap.get(data[1]).release());
                    break;
                case "HasEmptyRooms":
                    System.out.println(clinicMap.get(data[1]).hasEmptyRooms());
                    break;
                case "Print":
                    if (data.length == 2) {
                        System.out.println(clinicMap.get(data[1]).print());
                    } else {
                        System.out.println(clinicMap.get(data[1]).print(Integer.parseInt(data[2])));
                    }
                    break;
            }
        }
    }
}
