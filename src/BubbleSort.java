import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};
        Random rand = new Random(42); // Fixed seed for same random numbers

        System.out.println("Algorithm: Bubble Sort");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");

        for (int size : sizes) {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = rand.nextInt(10000);
            }

            long startTime = System.nanoTime();
            bubbleSort(arr);
            long endTime = System.nanoTime();

            double timeMs = (endTime - startTime) / 1_000_000.0;
            System.out.printf("%-10d | %.2f%n", size, timeMs);
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
