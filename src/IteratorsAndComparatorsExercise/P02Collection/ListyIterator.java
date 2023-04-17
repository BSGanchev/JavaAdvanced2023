package IteratorsAndComparatorsExercise.P02Collection;

import java.util.*;
import java.util.function.Consumer;

public class ListyIterator<T> implements Iterable<T> {
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

    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }

    private class LIterator implements Iterator<T> {
        private int iteratorIndex = 0;

        @Override
        public boolean hasNext() {
            return this.iteratorIndex < elements.size();
        }

        @Override
        public T next() {
            counter++;
            return elements.get(counter);
        }
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        while (this.elements.iterator().hasNext()) {
            this.elements.iterator().next();
        }
    }

    public boolean Move() {
        if (this.counter + 1 < this.elements.size()) {
            this.counter++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return this.counter + 1 < elements.size();
    }


    public void Print() {
        if (this.elements.size() == 0) {
            throw new NullPointerException("Invalid Operation!");
        } else {
            System.out.println(elements.get(counter));
        }
    }

    public void PrintAll() {
        if (this.elements.size() == 0) {
            throw new NullPointerException("Invalid Operation!");
        } else {
            elements.forEach(e -> System.out.printf("%s ", e));
            System.out.println();
        }

    }

}