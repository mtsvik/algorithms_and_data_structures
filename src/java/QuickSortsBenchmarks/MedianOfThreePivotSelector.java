package QuickSortsBenchmarks;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 17.11.13
 */
public class MedianOfThreePivotSelector implements PivotSelector {
    @Override
    public int getPivotIndex(Comparable[] data, int leftIndex, int rightIndex) {
        int halfIndex = (rightIndex - leftIndex) / 2 + leftIndex;
        if (data[leftIndex].compareTo(data[halfIndex]) < 0) {
            if (data[leftIndex].compareTo(data[rightIndex]) < 0) {
                if (data[halfIndex].compareTo(data[rightIndex]) < 0) {
                    return halfIndex;
                } else {
                    return rightIndex;
                }
            } else {
                return leftIndex;
            }
        } else {
            if (data[leftIndex].compareTo(data[rightIndex]) < 0) {
                return leftIndex;
            } else {
                if (data[halfIndex].compareTo(data[rightIndex]) < 0) {
                    return rightIndex;
                } else {
                    return halfIndex;
                }
            }
        }
    }
}
