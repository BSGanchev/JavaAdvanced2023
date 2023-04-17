package DefiningClassesExercise.P06PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static final String TOURNAMENT = "Tournament";
    public static final String END = "End";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Pokemon>> trainerMap = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals(TOURNAMENT)) {
            String[] data = input.split("\\s+");
            String name = data[0];
            String pokemonName = data[1];
            String pokemonElement = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            if (!trainerMap.containsKey(name)) {
                trainerMap.put(name, new ArrayList<>());
                trainerMap.get(name).add(pokemon);
            } else {
                trainerMap.get(name).add(pokemon);
            }
            input = scanner.nextLine();
        }

        List<Trainer> trainerList = trainerMap.entrySet().stream().
                map(e -> new Trainer(e.getKey(), e.getValue())).
                collect(Collectors.toList());

        input = scanner.nextLine();
        while (!input.equals(END)) {
            for (Trainer trainer : trainerList) {
                trainer.action(input);
            }
            input = scanner.nextLine();
        }
        trainerList.stream().sorted(Comparator.comparing(Trainer::getBadges).reversed()).
                forEach(e -> System.out.println(e));
        ;
    }
}
