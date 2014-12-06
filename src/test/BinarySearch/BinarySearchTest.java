package BinarySearch;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 08.10.13
 */
public class BinarySearchTest extends TestCase {
    public void testFindIndexSortedList() {
        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5);
        Search<Integer> srch = new BinarySearch<>();
            int result1 = srch.findIndex(data, 4);
            int result2 = data.indexOf(4);
            assertEquals(result1, result2);

    }

    public void testFindIndexUnsortedList() {
        List<Integer> data = Arrays.asList(3, 5, 4, 7);
        Search<Integer> srch = new BinarySearch<>();
        try {
            srch.findIndex(data, 4);
            fail();
        } catch (IllegalArgumentException e) {
            // List not Sorted
        }
    }

    public void testFindIndexEmptyList() {
        List<Integer> data = new ArrayList<>();
        Search<Integer> srch = new BinarySearch<>();
            int result1 = srch.findIndex(data, 4);
            int result2 = data.indexOf(4);
            assertEquals(result1, result2);

    }

    public void testFindIndexOneElementList() {
        List<Integer> data = Arrays.asList(1);
        Search<Integer> srch = new BinarySearch<>();
            int result1 = srch.findIndex(data, 4);
            int result2 = data.indexOf(4);
            assertEquals(result1, result2);

    }

    public void testFindIndexSameElementList() {
        List<Integer> data = Arrays.asList(5, 5, 5, 5);
        Search<Integer> srch = new BinarySearch<>();
            int result1 = srch.findIndex(data, 4);
            int result2 = data.indexOf(4);
            assertEquals(result1, result2);

    }

    public void testFindIndexZeroElementList() {
        List<Integer> data = Arrays.asList(0);
        Search<Integer> srch = new BinarySearch<>();
            int result1 = srch.findIndex(data, 4);
            int result2 = data.indexOf(4);
            assertEquals(result1, result2);

    }

}
