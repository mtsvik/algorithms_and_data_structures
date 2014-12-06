package QuickSortsBenchmarks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 18.11.13
 */
public class MedianOfThreePivotSelectorTest {
    @Test
    public void testSimpleSelect() {
        Integer[] array = {1, 8, 0, 4, 3, 7, 9, 9};
        PivotSelector selector = new MedianOfThreePivotSelector();
        assertEquals(3, selector.getPivotIndex(array, 0, array.length - 1));
    }
    @Test
    public void testNotAllArray() {
        Integer[] array = {1, 8, 0, 4, 3, 7, 9, 9};
        PivotSelector selector = new MedianOfThreePivotSelector();
        assertEquals(4, selector.getPivotIndex(array, 2, 6));
    }
}
