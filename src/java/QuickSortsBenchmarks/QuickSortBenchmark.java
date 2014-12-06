package QuickSortsBenchmarks;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 17.11.13
 */
public interface QuickSortBenchmark {

    BenchmarkResult compare(final Comparable[] dataSet, final CustomQuickSort random, CustomQuickSort median, CustomQuickSort last);

    public interface BenchmarkResult {
        int getDataSetSize();

        double getRandomAverageRunningTime();

        double getLastAverageRunningTime();

        double getMedianAverageRunningTime();
    }
}

