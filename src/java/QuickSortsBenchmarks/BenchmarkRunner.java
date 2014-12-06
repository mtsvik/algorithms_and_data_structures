package QuickSortsBenchmarks;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 17.11.13
 */
public class BenchmarkRunner {
    //Требуется увеличить максимальный размер стека

    private static Integer[] generateRandomSequence() {

        Random rnd = new Random();
        Integer[] sequence = new Integer[20000];
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = rnd.nextInt(Integer.MAX_VALUE);
        }
        return sequence;
    }

    private static Integer[] generateIncreasingSequence() {
        Integer[] sequence = generateRandomSequence();
        Arrays.sort(sequence);
        return sequence;
    }

    private static Integer[] generateDecreasingSequence() {
        Integer[] sequence = generateRandomSequence();
        Arrays.sort(sequence, Collections.reverseOrder());
        return sequence;
    }

    private static void printResult(Integer[] sequence) {
        int[] numbers = {100, 1000, 5000, 10000, 20000};
        Benchmark bnc = new Benchmark();
        for(int var : numbers) {
            QuickSortBenchmark.BenchmarkResult result = bnc.compare(Arrays.copyOf(sequence, var), new CustomQuickSort(new RandomElementPivotSelector()),
                    new CustomQuickSort(new MedianOfThreePivotSelector()), new CustomQuickSort(new LastElementPivotSelector()));
            System.out.println("Size: " + result.getDataSetSize() + "   RandomSelector: " +
                    +result.getRandomAverageRunningTime() + "      MedianSelector: " +
                    +result.getMedianAverageRunningTime() + "      LastIndexSelector:" +
                    +result.getLastAverageRunningTime());
        }
        System.out.println();
    }

    public static void main(String[] args){
        printResult(generateRandomSequence());
        printResult(generateIncreasingSequence());
        printResult(generateDecreasingSequence());
    }
}
