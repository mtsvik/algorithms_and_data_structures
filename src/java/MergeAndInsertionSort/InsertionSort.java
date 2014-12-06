package MergeAndInsertionSort;

import MergeAndInsertionSort.Sort;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 04.10.13
 */
public class InsertionSort implements Sort {

    protected static void insertionSort(Comparable[] items, int left, int right) {
        for (int i = left; i < right; i++) {
            Comparable newValue = items[i];
            int j = i;
            while (j > 0 && (items[j - 1].compareTo(newValue) > 0)) {
                items[j] = items[j - 1];
                j--;
            }
            items[j] = newValue;
        }
    }

    @Override
    public void sort(Comparable[] items) {
        insertionSort(items, 0, items.length);
    }
}
