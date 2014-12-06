package MergeAndInsertionSort;

import junit.framework.TestCase;
import org.junit.Assert;
import MergeSort.Sort;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 05.10.13
 */
public class CombinedMergeSortTest extends TestCase {
    public void testSortEmptyArray() {
        Integer[] arr = {};
        Integer[] arrClone = arr.clone();
        Sort combinedMergeSort = new CombinedMergeSort();
        combinedMergeSort.sort(arr);
        Assert.assertArrayEquals(arrClone, arr);
    }

    public void testSortArray() {
        Integer arr[] = {1, 56, 234, 1212, 0, 4, 5};
        Integer[] arrClone = arr.clone();
        Arrays.sort(arrClone);
        Sort combinedMergeSort = new CombinedMergeSort();
        combinedMergeSort.sort(arr);
        Assert.assertArrayEquals(arrClone, arr);
    }

    public void testSortSameElementArray() {
        Integer[] arr = {5, 5, 5, 5, 5};
        Integer[] arrClone = arr.clone();
        Sort combinedMergeSort = new CombinedMergeSort();
        combinedMergeSort.sort(arr);
        Assert.assertArrayEquals(arrClone, arr);
    }

    public void testSortOneElement() {
        Integer[] arr = {1};
        Integer[] arrClone = arr.clone();
        Sort combinedMergeSort = new CombinedMergeSort();
        combinedMergeSort.sort(arr);
        Assert.assertArrayEquals(arrClone, arr);
    }

    public void testSortZeroElement() {
        Integer[] arr = {0};
        Integer[] arrClone = arr.clone();
        Sort combinedMergeSort = new CombinedMergeSort();
        combinedMergeSort.sort(arr);
        Assert.assertArrayEquals(arrClone, arr);
    }
}
