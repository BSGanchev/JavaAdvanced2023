package GenericsExercise.P07CustomList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomList <E extends Comparable<E>> implements Iterable<E>{

    private List<E> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public void add(E element) {
        this.data.add(element);
    }

    public E remove(int index) {
        if (index < 0 && index >= this.data.size()) {
            throw new IndexOutOfBoundsException();
        } else {
            return this.data.remove(index);
        }
    }

    public boolean contains(E element){
        return this.data.contains(element);
    }
    public void swap(int firstIndex, int secondIndex) {
        E firstElement = this.data.get(firstIndex);
        E secondElement = this.data.get(secondIndex);
        this.data.set(firstIndex, secondElement);
        this.data.set(secondIndex, firstElement);
    }

    public int countGreaterThan(E element){
        int counter = 0;
        for (E current : this.data) {
            if (element.compareTo(current) < 0) {
                counter ++;
            }
        }
        return counter;
    }

    public E getMax(){
        if (this.data.isEmpty()) {
            throw new IllegalStateException();
        }
        E max = this.data.get(0);
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).compareTo(max) > 0) {
                max = this.data.get(i);
            }
        }
        return max;
    }

    public E getMin(){
        if(this.data.isEmpty()) {
            throw new IllegalStateException();
        }
        E min = this.data.get(0);
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).compareTo(min) < 0) {
                min = this.data.get(i);
            }
        }
        return min;
    }
    public int size() {
        return this.data.size();
    }
    public E getIndex(int index) {
        return this.data.get(index);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;


            @Override
            public boolean hasNext() {
                return index < data.size();
            }

            @Override
            public E next() {
                return data.get(index++);
            }
        };
    }
}