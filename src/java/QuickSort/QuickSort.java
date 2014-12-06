package QuickSort;

import MergeAndInsertionSort.Sort;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 11.10.13
 */
public class QuickSort implements Sort {

    private static void swap(Comparable[] items, final int first, final int second) {
        Comparable tmp = items[first];
        items[first] = items[second];
        items[second] = tmp;
    }

    protected static int partition(Comparable[] items, int left, int right) {
        Comparable pivot = items[right];
        int i = left - 1;
        for (int j = left; j <= right - 1; j++) {
            if (items[j].compareTo(pivot) < 0) {
                i++;
                swap(items, i, j);
            }
        }
        swap(items, i + 1, right);
        return i + 1;
    }

    private static void quickSort(Comparable[] items, int left, int right) {
        if (left < right) {
            int q = partition(items, left, right);
            quickSort(items, left, q - 1);
            quickSort(items, q + 1, right);
        }
    }

    @Override
    public void sort(Comparable[] items) {
        if (items == null) {
            throw new NullPointerException();
        }
        quickSort(items, 0, items.length - 1);
    }
}
