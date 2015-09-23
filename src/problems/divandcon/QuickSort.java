package problems.divandcon;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by yuwei on 15/9/17.
 * Project: CodingProblems
 */
public class QuickSort {
    public static <T extends Comparable<T>>
    void quickSort(T[] items) {
        Random random = new Random();
        quickSort(items, 0, items.length, random);
    }

    private static <T extends Comparable<T>>
    void quickSort(T[] items, int lower, int upper,
                                  Random random) {
        if (upper <= lower + 1) {
            return;
        }
//        int pivot = lower;
        int pivot = random.nextInt(upper - lower) + lower;
        pivot = partition(items, lower, upper, pivot);
        quickSort(items, lower, pivot, random);
        quickSort(items, pivot + 1, upper, random);
    }

    private static <T extends Comparable<T>> int partition(T[] items, int lower, int upper, int pivot) {
        T pivotVal = items[pivot];
//        System.out.println(Arrays.toString(items) + ", pivot=" + pivotVal);

        int i = lower;
        int j = upper - 1;

        while (true) {
            while (items[i].compareTo(pivotVal) < 0) {
                i++;
            }
            while (items[j].compareTo(pivotVal) > 0) {
                j--;
            }
            if (i < j) {
                T temp = items[i];
                items[i] = items[j];
                items[j] = temp;
//                System.out.println(Arrays.toString(items));
            } else {
                return j;
            }
        }
    }
}
