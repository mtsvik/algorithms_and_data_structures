package MultithreadSortBenchmark;

/**
 Created with IntelliJ IDEA.
 User: mtsvik
 Date: 09.11.13
 */
public class MyBenchmark implements Benchmark {
    private long avgTime(Comparable[] dataSet, Sort candidate, int threads) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            candidate.sort(dataSet, threads);
        }
        long finish = System.currentTimeMillis();
        return (finish - start) / 10;
    }

    @Override
    public Result launch(Comparable[] dataSet, Sort candidate, int threads) {
        long time = avgTime(dataSet, candidate, threads);
        return new Result(time, dataSet.length);
    }

    protected class Result implements Benchmark.Result {
        private long time;
        private int size;

        public Result(long time, int size) {
            this.size = size;
            this.time = time;
        }

        @Override
        public int getDataSetSize() {
            return size;
        }

        @Override
        public int getAverageRunningTime() {
            return (int) time;
        }
    }
}
