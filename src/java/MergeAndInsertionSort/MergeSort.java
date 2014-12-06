package MergeAndInsertionSort;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 28.09.13
 */

public class MergeSort implements Sort {

    protected static void merge(Comparable[] items, int leftPos, int rightPos, int rightEnd) {
        Comparable[] tmpArray = new Comparable[items.length];
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (items[leftPos].compareTo(items[rightPos]) <= 0) {
                tmpArray[tmpPos++] = items[leftPos++];
            } else {
                tmpArray[tmpPos++] = items[rightPos++];
            }
        }

        while (leftPos <= leftEnd) {
            tmpArray[tmpPos++] = items[leftPos++];
        }

        while (rightPos <= rightEnd) {
            tmpArray[tmpPos++] = items[rightPos++];
        }

        for (int i = 0; i < numElements; i++, rightEnd--) {
            items[rightEnd] = tmpArray[rightEnd];
        }

    }

    @Override
    public void sort(Comparable[] items) {
        mergeSort(items, 0, items.length - 1);
    }

    private void mergeSort(Comparable[] items, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(items, left, center);
            mergeSort(items, center + 1, right);
            merge(items, left, center + 1, right);
        }
    }
}


