package QuickSortsBenchmarks;

import org.junit.Test;
import MergeSort.Sort;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 18.11.13
 */
public class CustomQuickSortTest {
    @Test
    public void testSorterWithLEPS() {
        Integer[] array = {1, 8, 0, 4, 3, 7, 9, 46};
        Sort sorter = new CustomQuickSort(new LastElementPivotSelector());
        Integer[] expected = array.clone();
        Arrays.sort(expected);
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSorterWithMOTPS() {
        Integer[] array = {1, 8, 0, 4, 3, 7, 9, 46};
        Sort sorter = new CustomQuickSort(new MedianOfThreePivotSelector());
        Integer[] expected = array.clone();
        Arrays.sort(expected);
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSorterWithREPS() {
        Integer[] array = {1, 8, 0, 4, 3, 7, 9, 46};
        Sort sorter = new CustomQuickSort(new RandomElementPivotSelector());
        Integer[] expected = array.clone();
        Arrays.sort(expected);
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }
}
