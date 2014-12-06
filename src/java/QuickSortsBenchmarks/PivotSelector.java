package QuickSortsBenchmarks;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 17.11.13
 */
public interface PivotSelector {
    int getPivotIndex(Comparable[] data, int startIndex, int endIndex);
}