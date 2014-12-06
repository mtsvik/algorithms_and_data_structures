package QuickSortsBenchmarks;

import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 18.11.13
 */
public class RandomElementPivotSelectorTest {
    @Test
    public void testDiapason() {
        Integer[] array = {1, 8, 0, 4, 3, 7, 9, 9};
        PivotSelector selector = new RandomElementPivotSelector();
        for (int i = 0; i < 100; i++) {
            int index = selector.getPivotIndex(array, 0, array.length - 1);
            if (index < 0 || index > (array.length - 1)) {
                fail("IndexOutOfBounds");
            }
        }
    }
}
