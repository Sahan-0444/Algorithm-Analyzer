import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};
        Random rand = new Random(42); // Fixed seed for same random numbers

        System.out.println("Algorithm: Binary Search");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");

        for (int size : sizes) {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = rand.nextInt(10000);
            }
            Arrays.sort(arr); // Sort the array first
            int target = arr[size - 1]; // Search for the last element

            long startTime = System.nanoTime();
            binarySearch(arr, target);
            long endTime = System.nanoTime();

            double timeMs = (endTime - startTime) / 1_000_000.0;
            System.out.printf("%-10d | %.2f%n", size, timeMs);
        }
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
