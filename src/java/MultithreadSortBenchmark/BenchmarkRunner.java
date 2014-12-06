package MultithreadSortBenchmark;

/**
 Created with IntelliJ IDEA.
 User: mtsvik
 Date: 09.11.13
 */
public class BenchmarkRunner {
    private static Comparable[] generateArray(int size) {
        Comparable[] arr = new Comparable[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }
        return arr;
    }

    public static void main(String[] args) {
        MyBenchmark bench = new MyBenchmark();
        for (int num : new int[] {1000, 10000, 20000, 30000, 40000, 50000}) {
            Comparable[] array = generateArray(num);
            MyBenchmark.Result resultOneThread = bench.launch(array, new MergeSort(), 1);
            MyBenchmark.Result resultCoresThread = bench.launch(array, new MergeSort(), Runtime.getRuntime().availableProcessors());
            MyBenchmark.Result result64Thread = bench.launch(array, new MergeSort(), 64);
            System.out.println(num + " items:" + " 1 thread - " + resultOneThread.getAverageRunningTime() + " ms.");
            System.out.println(num + " items:" + " 4 thread - " + resultCoresThread.getAverageRunningTime() + " ms.");
            System.out.println(num + " items:" + " 64 thread - " + result64Thread.getAverageRunningTime() + " ms.");
            System.out.println();
        }

    }
}
