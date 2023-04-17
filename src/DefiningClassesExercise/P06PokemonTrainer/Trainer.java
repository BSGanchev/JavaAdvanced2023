package DefiningClassesExercise.P06PokemonTrainer;

import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemonList;

    public Trainer(String name, List<Pokemon> pokemonList) {
        this.name = name;
        this.badges = 0;
        this.pokemonList = pokemonList;
    }

    public String getName() {
        return name;
    }

    public int getBadges() {
        return badges;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public boolean checkinForElement(String command) {
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getElement().equals(command)) {
                return true;
            }
        }
        return false;
    }

    public void action(String command) {
        if (checkinForElement(command)) {
            badges++;
        } else {
            for (int i = 0; i < pokemonList.size(); i++) {
                pokemonList.get(i).setHealth(pokemonList.get(i).getHealth() - 10);
                if(pokemonList.get(i).getHealth() <= 0){
                    pokemonList.remove(i);
                    i--;
                }
            }
        }
    }

    @Override
    public String toString() {
        return name + " " + badges + " " + pokemonList.size();
    }
}
