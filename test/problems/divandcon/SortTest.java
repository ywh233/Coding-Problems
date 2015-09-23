package problems.divandcon;

import org.junit.Test;

import java.util.function.Consumer;

import static org.junit.Assert.*;

public class SortTest {

    @Test
    public void testQuickSort() throws Exception {
        testSort(QuickSort::quickSort);
    }

    private static void testSort(Consumer<Integer[]> sorter) {
        Integer[] array1 = {};
        Integer[] array2 = {1};
        Integer[] array3 = {1,2};
        Integer[] array4 = {2,1};
        Integer[] array5 = {1,2,3,4,5};
        Integer[] array6 = {1,2,3,4,5,6};
        Integer[] array7 = {5,4,3,2,1};
        Integer[] array8 = {6,5,4,3,2,1};
        Integer[] array9 = {3,2,5,1,4};
        Integer[] array10 = {6,1,4,5,3,2};
        Integer[] array11 = {3,2,3,1,4,5,1};

        Integer[] array1s = {};
        Integer[] array2s = {1};
        Integer[] array3s = {1,2};
        Integer[] array4s = {1,2};
        Integer[] array5s = {1,2,3,4,5};
        Integer[] array6s = {1,2,3,4,5,6};
        Integer[] array7s = {1,2,3,4,5};
        Integer[] array8s = {1,2,3,4,5,6};
        Integer[] array9s = {1,2,3,4,5};
        Integer[] array10s = {1,2,3,4,5,6};
        Integer[] array11s = {1,1,2,3,3,4,5};

        sorter.accept(array1);
        sorter.accept(array2);
        sorter.accept(array3);
        sorter.accept(array4);
        sorter.accept(array5);
        sorter.accept(array6);
        sorter.accept(array7);
        sorter.accept(array8);
        sorter.accept(array9);
        sorter.accept(array10);
//        sorter.accept(array11);

        assertArrayEquals(array1s, array1);
        assertArrayEquals(array2s, array2);
        assertArrayEquals(array3s, array3);
        assertArrayEquals(array4s, array4);
        assertArrayEquals(array5s, array5);
        assertArrayEquals(array6s, array6);
        assertArrayEquals(array7s, array7);
        assertArrayEquals(array8s, array8);
        assertArrayEquals(array9s, array9);
        assertArrayEquals(array10s, array10);
//        assertArrayEquals(array11s, array11);
    }
}