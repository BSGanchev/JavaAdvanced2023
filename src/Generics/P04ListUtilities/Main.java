package Generics.P04ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        Collections.addAll(integerList, 1, 2, 4, 6, 8,11, 200, 0);

        System.out.println(ListUtils.getMin(integerList));
        System.out.println(ListUtils.getMax(integerList));

    }
}
