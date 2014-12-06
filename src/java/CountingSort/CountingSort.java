package CountingSort;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 18.11.13
 */
public class CountingSort implements NumericSort {

    @Override
    public void sort(int[] items) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < items.length; i++) {
            if (items[i] > max) {
                max = items[i];
            }
            if (items[i] < min) {
                min = items[i];
            }
        }
        countingSort(items, min, max);
    }

    private void countingSort(int[] items, int lower, int upper) {
        int[] numbers = new int[upper - lower + 1];
        for (int i = 0; i < items.length; i++) {
            numbers[items[i] - lower]++;
        }
        for (int i = 1; i < numbers.length; i++) {
            numbers[i] += numbers[i - 1];
        }
        int[] sortedItems = new int[items.length];
        for (int i = items.length - 1; i >= 0; i--) {
            sortedItems[numbers[items[i] - lower] - 1] = items[i];
            numbers[items[i] - lower]--;
        }
        System.arraycopy(sortedItems, 0, items, 0, sortedItems.length);
    }
}
