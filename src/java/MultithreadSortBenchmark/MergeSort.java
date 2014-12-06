package MultithreadSortBenchmark;

/**
 Created with IntelliJ IDEA.
 User: mtsvik
 Date: 09.11.13
 */
public class MergeSort implements Sort {
    @Override
    public void sort(Comparable[] items, int threads) {
        ParallelSort sort = new ParallelSort(items, threads);
        sort.run();
    }
}
