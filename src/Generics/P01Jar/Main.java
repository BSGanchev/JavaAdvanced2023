package Generics.P01Jar;

public class Main {
    public static void main(String[] args) {

        Jar<Integer> integerJar = new Jar<>();
        integerJar.add(700);
        integerJar.add(500);
        System.out.println( integerJar.remove());
    }
}
