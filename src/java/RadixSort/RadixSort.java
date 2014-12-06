package RadixSort;

import CountingSort.NumericSort;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 18.11.13
 */
public class RadixSort implements NumericSort {
    @Override
    public void sort(int[] items) {
        radixSort(items, maxAbsOfNumbers(items));
    }

    public int maxAbsOfNumbers(int[] items) {
        int maxCount = Integer.MIN_VALUE;
        for (int var : items) {
            if (Math.abs(var) > maxCount) {
                maxCount = Math.abs(var);
            }
        }
        return maxCount;
    }

    private void radixSort(int[] items, int d) {
        int h = 1;
        for (int j = 0; j <= String.valueOf(d).length(); j++) {
            int[] numbers = new int[10];
            for (int var : items) {
                numbers[(var + d) / h % 10]++;
            }
            for (int i = 1; i < numbers.length; i++) {
                numbers[i] += numbers[i - 1];
            }
            int[] sortedItems = new int[items.length];
            for (int i = items.length - 1; i >= 0; i--) {
                numbers[(items[i] + d) / h % 10]--;
                sortedItems[numbers[(items[i] + d) / h % 10]] = items[i];
            }
            System.arraycopy(sortedItems, 0, items, 0, sortedItems.length);
            h *= 10;
        }
    }
}
