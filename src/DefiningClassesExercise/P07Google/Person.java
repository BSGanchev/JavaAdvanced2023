package DefiningClassesExercise.P07Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Car car;
    private Company company;
    private List<Parents> parentsList;
    private List<Children> childrenList;
    private List<Pokemon> pokemonList;

    public Person(Car car, Company company, List<Parents> parentsList, List<Children> childrenList, List<Pokemon> pokemonList) {
        this.car = car;
        this.company = company;
        this.parentsList = parentsList;
        this.childrenList = childrenList;
        this.pokemonList = pokemonList;
    }

    public Person() {
        this.pokemonList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
        this.parentsList = new ArrayList<>();
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Parents> getParentsList() {
        return parentsList;
    }

    public void setParentsList(List<Parents> parentsList) {
        this.parentsList = parentsList;
    }

    public List<Children> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<Children> childrenList) {
        this.childrenList = childrenList;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Company:").append(System.lineSeparator());
        if(company != null) {
            stringBuilder.append(company).append(System.lineSeparator());
        }
        stringBuilder.append("Car:").append(System.lineSeparator());
        if(car != null) {
            stringBuilder.append(car).append(System.lineSeparator());
        }
        stringBuilder.append("Pokemon:").append(System.lineSeparator());
        for (Pokemon pokemon : pokemonList) {
            stringBuilder.append(pokemon).append(System.lineSeparator());
        }
        stringBuilder.append("Parents:").append(System.lineSeparator());
        for (Parents parents : parentsList) {
            stringBuilder.append(parents).append(System.lineSeparator());
        }
        stringBuilder.append("Children:").append(System.lineSeparator());
        for (Children children : childrenList) {
            stringBuilder.append(children).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
