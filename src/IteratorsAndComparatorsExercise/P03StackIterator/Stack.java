package IteratorsAndComparatorsExercise.P03StackIterator;

import javax.naming.OperationNotSupportedException;
import java.util.*;

public class Stack<T> implements Iterable<T> {
    private List<T> elements;
    int currentIndex = 0;

    public Stack(T... elements) {
        this.elements = new ArrayList<>();
    }

    public void Push(T currentElement) {

        this.elements.add(this.currentIndex, currentElement);
        currentIndex++;
    }

    public T Pop() throws OperationNotSupportedException {
        try {
            T popElement = this.elements.get(currentIndex - 1);
            this.elements.remove(currentIndex - 1);
            currentIndex--;
            return popElement;
        } catch (IndexOutOfBoundsException e) {
            throw new OperationNotSupportedException();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
        private int index = currentIndex;

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public T next() {
            if (hasNext()) {
                index--;
            }
            return elements.get(index);
        }
    }

}
