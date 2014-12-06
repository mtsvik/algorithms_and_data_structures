package CountingSort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 18.11.13
 */

public class CountingSortTest {
    @Test
    public void testSimpleArrayWith0() {
        NumericSort sorter = new CountingSort();
        int[] array = {5, 3, 1, 2, 4, 0};
        int[] expected = {0, 1, 2, 3, 4, 5};
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSimpleArrayWithNegative() {
        NumericSort sorter = new CountingSort();
        int[] array = {18, 98, 1, -5, 8, -2};
        int[] copy = array.clone();
        Arrays.sort(copy);
        sorter.sort(array);
        assertArrayEquals(copy, array);
    }

    @Test
    public void testEmptyArray() {
        int[] array = new int[0];
        NumericSort sorter = new CountingSort();
        sorter.sort(array);
        assertArrayEquals(new int[0], array);
    }

    @Test
    public void testSingleArray() {
        int[] array = {-99};
        int[] copy = array.clone();
        NumericSort sorter = new CountingSort();
        sorter.sort(array);
        assertArrayEquals(array, copy);
    }
}
