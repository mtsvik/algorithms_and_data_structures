package MergeAndInsertionSort;

import MergeAndInsertionSort.MergeSort;
import MergeAndInsertionSort.Sort;
import static MergeAndInsertionSort.InsertionSort.insertionSort;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 04.10.13
 */
public class CombinedMergeSort extends MergeSort implements Sort {
    private static final int LENGTH = 10;

    private void combinedMergeSort(Comparable[] items, int left, int right) {
        if (right - left <= LENGTH) {
            insertionSort(items, left, right);
        }

        else {
            int center = (left + right) / 2;
            combinedMergeSort(items, left, center);
            combinedMergeSort(items, center, right);
            merge(items, left, center, right);
        }
    }

    @Override
    public void sort(Comparable[] items) {
        combinedMergeSort(items, 0, items.length);
    }



}
