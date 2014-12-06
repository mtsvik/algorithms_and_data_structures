package RandomizedStatisticsCalculator;

import java.util.Random;

/**
 Author: Mikhail Tsvik (tsvik@me.com)
 Date: 26.02.14.
 */

public class RandomizedStatisticsCalculator<E extends Comparable<E>> implements StatisticsCalculator {

    private final E[] array;
    private final Random rnd;

    public RandomizedStatisticsCalculator(E[] array, long seed) {
        rnd = new Random(seed);
        this.array = array.clone();
    }

    private void swap(E[] array, final int first, final int second) {
        E tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }

    private int partition(final int left, final int right) {
        int ind = rnd.nextInt(right - left + 1) + left;
        if (left != right) swap(array, ind, right);
        E pivot = array[right];
        int i = left - 1;
        for (int j = left; j <= right - 1; j++) {
            if (array[j].compareTo(pivot) < 0) swap(array, ++i, j);
        }
        swap(array, i + 1, right);
        return i + 1;
    }

    private E randomizeSelect(final int left,final int right,final int k) {
        if (left == right) {
            return array[left];
        }
        int separator = partition(left, right);
        int leftArraySize = separator - left + 1;
        if (k <= leftArraySize) {
            return randomizeSelect(left, separator, k);
        } else {
            return randomizeSelect(separator + 1, right, k - leftArraySize);
        }
    }

    @Override
    public E getStatistics(int k) {
        if (k <= 0) throw new IllegalArgumentException("Order statistic k must be positive");
        if (array == null) throw new NullPointerException("Array is null");
        if (array.length == 0) throw new IllegalArgumentException("Array is empty");
        if (k > array.length) throw new IllegalArgumentException("Array is too small");
        return randomizeSelect(0, array.length - 1, k);
    }

}
