package IteratorsAndComparatorsExercise.P04Froggy;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Lake implements Iterable<Integer> {

    private Integer[] elements;

    public Lake(Integer... elements) {
        this.elements = elements;
    }

    public Integer[] getElements() {
        return elements;
    }

    public void setElements(Integer... elements) {
        this.elements = elements;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<Integer> {
        private int position;
        private int count;
        private int evenStartIndex;
        private int oddStartIndex;

        public Frog() {
            this.position = 0;
            this.count = 0;
            this.evenStartIndex = 0;
            this.oddStartIndex = 1;
        }

        public int getIndex() {
            int limit = elements.length / 2;
            if(elements.length % 2 == 0) {
                limit -=1;
            }
            if (count <= limit) {
                this.count++;
                this.position++;
                int index = this.evenStartIndex;
                this.evenStartIndex += 2;
                return index;
            }
            this.count++;
            this.position++;
            int index = this.oddStartIndex;
            this.oddStartIndex += 2;
            return index;
        }

        @Override
        public boolean hasNext() {
            return position < elements.length;
        }

        @Override
        public Integer next() {
            if (hasNext()) {
                return elements[getIndex()];

            } else {
                throw new NoSuchElementException();
            }
        }
    }
}
