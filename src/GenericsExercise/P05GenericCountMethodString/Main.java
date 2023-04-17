package GenericsExercise.P05GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        List<Box<Double>> list = new ArrayList<>();
        while(count -- > 0) {
            Double input = Double.parseDouble(scanner.nextLine());
            Box<Double> box = new Box<>(input);
            list.add(box);
        }
        Box<Double> criteria = new Box<>(Double.parseDouble(scanner.nextLine()));
        int result = 0;
        for (Box box : list) {
            int res = box.compareTo(criteria);
            if ( res > 0 ) {
                result ++;
            }
        }
        System.out.println(result);

    }
}
