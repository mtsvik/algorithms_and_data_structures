package QuickSortsBenchmarks;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 17.11.13
 */
public class RandomElementPivotSelector implements PivotSelector {
    @Override
    public int getPivotIndex(Comparable[] data, int leftIndex, int rightIndex) {
        Random rnd = new Random();
        return rnd.nextInt(rightIndex - leftIndex + 1) + leftIndex;
    }
}
