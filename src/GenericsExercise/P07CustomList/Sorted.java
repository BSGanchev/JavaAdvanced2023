package GenericsExercise.P07CustomList;

public class Sorted {

    public static <E extends Comparable <E>> void sort(CustomList<E> list) {
        for (int i = 0; i < list.size(); i++) {
            E current = list.getIndex(i);
            for (int j = i + 1; j < list.size(); j++) {
                if (current.compareTo(list.getIndex(j)) > 0) {
                    list.swap(i, j);
                }
            }
        }
    }
}
