package BasicAlgorithms;

import java.net.Inet4Address;
import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {

    private static int sum(int[] nums, int index) {
        if (index == nums.length - 1) {
            return nums[index];
        }
        return nums[index] + sum(nums, index + 1);
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        System.out.println(sum(input, 0));
    }
}
