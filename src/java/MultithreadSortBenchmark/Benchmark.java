package MultithreadSortBenchmark;

/**
 Created with IntelliJ IDEA.
 User: mtsvik
 Date: 09.11.13
 */
public interface Benchmark {
    public Result launch(final Comparable[] dataSet, final Sort candidate, final int threads);

    static interface Result {
        int getDataSetSize();

        int getAverageRunningTime(); // Average of 10 results
    }
}

