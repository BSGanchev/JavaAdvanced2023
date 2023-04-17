package IteratorsAndComparatorsExercise.P01ListyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListyIterator <T>{
    private List<T> elements;
    private int counter;

    public ListyIterator(T... elements) {
        this.setElements(elements);
    }

    public List<T> getElements() {
        return elements;
    }

    private void setElements(T... elements) {
        this.elements = new ArrayList<>(Arrays.asList(elements));
        this.counter = 0;
    }
    public boolean hasNext() {
        return this.counter + 1 < this.elements.size();
    }
    public boolean Move() {
        if(hasNext()) {
            this.counter++;
            return true;
        }
        return false;
    }
    public void Print(){
        if(this.elements.size() == 0){
            throw new NullPointerException("Invalid Operation!");
        }else {
            System.out.println(elements.get(counter));
        }
    }
}
