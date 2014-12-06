package MultithreadSortBenchmark;

import java.util.Arrays;

/**
 Created with IntelliJ IDEA.
 User: mtsvik
 Date: 08.11.13
 */
public class ParallelSort implements Runnable {
    private Comparable[] items;
    private int threads;

    public ParallelSort(Comparable[] items, int threads) {
        this.items = items;
        this.threads = threads;
    }


    @Override
    public void run() {
        if (threads <= 1) {
            mergeSort(items);
        } else if (items.length >= 2) {
            Comparable[] left = Arrays.copyOfRange(items, 0, items.length / 2);
            Comparable[] right = Arrays.copyOfRange(items, items.length / 2, items.length);

            Thread lThread = new Thread(new ParallelSort(left, threads / 2));
            Thread rThread = new Thread(new ParallelSort(right, threads / 2));
            lThread.start();
            rThread.start();

            try {
                lThread.join();
                rThread.join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            merge(left, right, items);
        }
    }


    public static void mergeSort(Comparable[] items) {
        if (items.length >= 2) {
            Comparable[] left = Arrays.copyOfRange(items, 0, items.length / 2);
            Comparable[] right = Arrays.copyOfRange(items, items.length / 2, items.length);

            mergeSort(left);
            mergeSort(right);

            merge(left, right, items);
        }
    }

    public static void merge(Comparable[] left, Comparable[] right, Comparable[] items) {
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < items.length; i++) {
            if (i2 >= right.length || ((i1 < left.length) && (left[i1].compareTo(right[i2])) < 0)) {
                items[i] = left[i1];
                i1++;
            } else {
                items[i] = right[i2];
                i2++;
            }
        }
    }


}
