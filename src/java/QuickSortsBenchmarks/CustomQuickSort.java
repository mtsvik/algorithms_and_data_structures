package QuickSortsBenchmarks;

import MergeAndInsertionSort.Sort;
import QuickSort.QuickSort;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 17.11.13
 */
public class CustomQuickSort extends QuickSort implements Sort {
    //Требуется увеличить максимальный размер стека
    private final PivotSelector selector;

    public CustomQuickSort(PivotSelector selector) {
        this.selector = selector;
    }

    @Override
    public void sort(Comparable[] items) {
        quickSort(items, 0, items.length - 1);
    }

    protected void quickSort(Comparable[] items, int begin, int end) {
        if (begin < end) {
            int indexOfPivot = selector.getPivotIndex(items, begin, end);
            Comparable var = items[end];
            items[end] = items[indexOfPivot];
            items[indexOfPivot] = var;
            int div = partition(items, begin, end);
            quickSort(items, begin, div - 1);
            quickSort(items, div + 1, end);
        }
    }
}
