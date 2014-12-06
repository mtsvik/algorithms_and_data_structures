package RadixSort;

import org.junit.Test;
import CountingSort.NumericSort;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 18.11.13
 */
public class RadixSortTest {
    @Test
    public void testSimpleArrayWith0() {
        NumericSort sorter = new RadixSort();
        int[] array = {5, 3, 111, 2, 48, 0};
        int[] expected = array.clone();
        Arrays.sort(expected);
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }
    @Test
    public void testSimpleArray() {
        NumericSort sorter = new RadixSort();
        int[] array = {5, 3, 1, 2, 4, 0};
        int[] expected = array.clone();
        Arrays.sort(expected);
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }
    @Test
    public void testEmptyArray() {
        int[] array = new int[0];
        NumericSort sorter = new RadixSort();
        sorter.sort(array);
        assertArrayEquals(new int[0], array);
    }
    @Test
    public void testSingleArray() {
        int[] array = {88};
        int[] copy = array.clone();
        NumericSort sorter = new RadixSort();
        sorter.sort(array);
        assertArrayEquals(array, copy);
    }
    @Test
    public void testSimpleArrayWithNegative() {
        NumericSort sorter = new RadixSort();
        int[] array = {-2, 0, -1, 0};
        int[] copy = array.clone();
        Arrays.sort(copy);
        sorter.sort(array);
        assertArrayEquals(copy, array);
    }

}
