package QuickSortsBenchmarks;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 17.11.13
 */
public class Benchmark implements QuickSortBenchmark {

    @Override
    public BenchmarkResult compare(Comparable[] dataSet, CustomQuickSort random, CustomQuickSort median, CustomQuickSort last) {
        return new Result(timeCounter(random, dataSet), timeCounter(median, dataSet), timeCounter(last, dataSet), dataSet.length);
    }

    private long timeCounter(CustomQuickSort candidate, Comparable[] dataSet) {
        long time = 0;
        for (int i = 0; i < 10; i++) {
            Comparable[] dataSetTest = dataSet.clone();
            long start = System.currentTimeMillis();
            candidate.sort(dataSetTest);
            long end = System.currentTimeMillis();
            time += (end - start);
        }
        return time / 10;
    }

    private static class Result implements BenchmarkResult {

        private final int dataSize;
        private final long randomAverageRunningTime;
        private final long medianAverageRunningTime;
        private final long lastAverageRunningTime;

        public Result(long time1, long time2, long time3, int size) {
            this.dataSize = size;
            this.randomAverageRunningTime = time1;
            this.medianAverageRunningTime = time2;
            this.lastAverageRunningTime = time3;
        }

        @Override
        public int getDataSetSize() {
            return this.dataSize;
        }

        @Override
        public double getRandomAverageRunningTime() {
            return this.randomAverageRunningTime;
        }

        @Override
        public double getLastAverageRunningTime() {
            return this.lastAverageRunningTime;
        }

        @Override
        public double getMedianAverageRunningTime() {
            return this.medianAverageRunningTime;
        }
    }
}
