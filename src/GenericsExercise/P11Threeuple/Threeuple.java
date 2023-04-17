package Threeuple;

public class Threeuple <K, U, V>{
    private K key;
    private U valueOne;
    private V valueTwo;

    public Threeuple(K key, U valueOne, V valueTwo) {
        this.key = key;
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public U getValueOne() {
        return valueOne;
    }

    public void setValueOne(U valueOne) {
        this.valueOne = valueOne;
    }

    public V getValueTwo() {
        return valueTwo;
    }

    public void setValueTwo(V valueTwo) {
        this.valueTwo = valueTwo;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", this.key, this.valueOne, this.valueTwo);
    }
}
