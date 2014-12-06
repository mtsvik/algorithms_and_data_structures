package QuickSort;

import org.junit.*;
import MergeSort.Sort;
import java.util.Arrays;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 12.10.13
 */
public class QuickSortTest {
    @Test
    public void testSortEmptyArray() {
        Integer[] arr = {};
        Integer[] arrClone = arr.clone();
        Sort qSort = new QuickSort();
        qSort.sort(arr);
        assertArrayEquals(arrClone, arr);
    }

    @Test
    public void testSortArray() {
        Integer arr[] = {1, 56, 234, 1212, 0, 4, 5};
        Integer[] arrClone = arr.clone();
        Arrays.sort(arrClone);
        Sort qSort = new QuickSort();
        qSort.sort(arr);
        assertArrayEquals(arrClone, arr);
    }

    @Test
    public void testSortSameElementArray() {
        Integer[] arr = {5, 5, 5, 5, 5};
        Integer[] arrClone = arr.clone();
        Sort qSort = new QuickSort();
        qSort.sort(arr);
        assertArrayEquals(arrClone, arr);
    }

    @Test
    public void testSortOneElement() {
        Integer[] arr = {1};
        Integer[] arrClone = arr.clone();
        Sort qSort = new QuickSort();
        qSort.sort(arr);
        assertArrayEquals(arrClone, arr);
    }

    @Test
    public void testSortZeroElement() {
        Integer[] arr = {0};
        Integer[] arrClone = arr.clone();
        Sort qSort = new QuickSort();
        qSort.sort(arr);
        assertArrayEquals(arrClone, arr);
    }
}
