package QuickSortsBenchmarks;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 17.11.13
 */
public class LastElementPivotSelector implements PivotSelector {
    @Override
    public int getPivotIndex(Comparable[] data, int leftIndex, int rightIndex) {
        return rightIndex;
    }
}
