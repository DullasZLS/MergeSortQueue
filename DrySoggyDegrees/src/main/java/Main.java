// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) {
        ArrayDeque<Integer> dequeue = new ArrayDeque<Integer>();
        dequeue.add(54);
        dequeue.add(21);
        dequeue.add(626);
        dequeue.add(-24);
        dequeue.add(96);
        dequeue.add(90);

        System.out.println("Original ArrayDequeue: " + dequeue);

        int[] numbers = dequeue.stream().mapToInt(Integer::intValue).toArray();

        System.out.println("Original Array: " + Arrays.toString(numbers));

        mergeSort(numbers, 0, numbers.length - 1);

        System.out.println("Sorted Array: " + Arrays.toString(numbers));

        // Convert into ArrayDequeue

        ArrayDeque<Integer> sortedDequeue = new ArrayDeque<>(Arrays.asList(Arrays.stream(numbers).boxed().toArray(Integer[]::new)));

        System.out.println("Sorted ArrayDequeue: " + sortedDequeue);

        sortedDequeue.add(998);
        sortedDequeue.add(999);
        sortedDequeue.add(1000);

        System.out.println("Sorted ArrayDequeue w/ added integers: " + sortedDequeue);
    }

    // Merge Sort function
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            // Repeatedly sort the left and right halves
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            // Merge the sorted halves
            merge(array, left, middle, right);
        }
    }

    // Merge function
    public static void merge(int[] array, int left, int middle, int right) {

        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data into temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[middle + 1 + j];
        }

        // Initial indexes of the left and right arrays
        int i = 0, j = 0;

        // Initial index for merged array
        int k = left;

        // Merge the temporary arrays back into the original array
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

}