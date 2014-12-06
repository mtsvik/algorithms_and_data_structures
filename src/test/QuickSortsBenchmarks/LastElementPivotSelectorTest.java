package QuickSortsBenchmarks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 18.11.13
 */
public class LastElementPivotSelectorTest {
    @Test
    public void testSimpleSelect() {
        PivotSelector selector = new LastElementPivotSelector();
        assertEquals(7, selector.getPivotIndex(new Integer[]{1, 8, 0, 4, 3, 7, 9, 9}, 0, 7));
    }
}
