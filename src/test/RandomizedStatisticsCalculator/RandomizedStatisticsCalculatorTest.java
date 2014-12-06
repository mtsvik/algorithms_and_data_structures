package RandomizedStatisticsCalculator;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 Author: Mikhail Tsvik (tsvik@me.com)
 Date: 27.02.14.
 */

public class RandomizedStatisticsCalculatorTest {


    @Test
    public void testGetStatistics() {
        Integer[] arr = {6, 5, 7, 8, 9, 3, 2, 1};
        Integer[] arr2 = arr.clone();
        RandomizedStatisticsCalculator<Integer> test = new RandomizedStatisticsCalculator<>(arr, 30L);
        Arrays.sort(arr2);
        int statistics = 6;
        assertEquals(arr2[statistics - 1], test.getStatistics(statistics));
    }

    @Test
    public void testGetStatisticsSameElementArray() {
        Integer[] arr = {5, 5, 5, 5, 5, 5, 5, 5};
        Integer[] arr2 = arr.clone();
        RandomizedStatisticsCalculator<Integer> test = new RandomizedStatisticsCalculator<>(arr, 30L);
        Arrays.sort(arr2);
        int statistics = 4;
        assertEquals(arr2[statistics - 1], test.getStatistics(statistics));
    }

    @Test(expected = IllegalArgumentException.class) // array is empty
    public void testGetStatisticsEmptyArray() throws IllegalArgumentException {
        Integer[] arr = {};
        Integer[] arr2 = arr.clone();
        RandomizedStatisticsCalculator<Integer> test = new RandomizedStatisticsCalculator<>(arr, 30L);
        Arrays.sort(arr2);
        int statistics = 4;
        test.getStatistics(statistics);

    }

    @Test(expected = IllegalArgumentException.class)// array is too small for this order statistics
    public void testGetStatisticsOneELementArray() throws IllegalArgumentException {
        Integer[] arr = {5};
        Integer[] arr2 = arr.clone();
        RandomizedStatisticsCalculator<Integer> test = new RandomizedStatisticsCalculator<>(arr, 30L);
        Arrays.sort(arr2);
        int statistics = 2;
        test.getStatistics(statistics);
    }

    @Test(expected = NullPointerException.class) // array is null
    public void testGetStatisticsNullArray() throws NullPointerException {
        Integer[] arr = null;
        Integer[] arr2 = null;
        RandomizedStatisticsCalculator<Integer> test = new RandomizedStatisticsCalculator<>(arr, 30L);
        int statistics = 4;
        test.getStatistics(statistics);
    }

    @Test
    public void testGetStatisticsSortArray() {
        Integer[] arr = {6, 5, 7, 8, 9, 3, 2, 1};
        Integer[] arr2 = arr.clone();
        Arrays.sort(arr2);
        Arrays.sort(arr);
        RandomizedStatisticsCalculator<Integer> test = new RandomizedStatisticsCalculator<>(arr, 30L);
        int statistics = 4;
        assertEquals(arr2[statistics - 1], test.getStatistics(statistics));
    }

    @Test(expected = IllegalArgumentException.class) // order statistics must be positive
    public void testGetStatisticsIndexOutLeft() throws IllegalArgumentException {
        Integer[] arr = {6, 5, 7, 8, 9, 3, 2, 1};
        Integer[] arr2 = arr.clone();
        Arrays.sort(arr2);
        RandomizedStatisticsCalculator<Integer> test = new RandomizedStatisticsCalculator<>(arr, 30L);
        int statistics = -4;
        test.getStatistics(statistics);
    }

    @Test
    public void twoItemsReversed() {
        Integer[] arr = {99, 77};
        RandomizedStatisticsCalculator<Integer> test = new RandomizedStatisticsCalculator<>(arr, 30L);
        assertEquals((Integer) 77, test.getStatistics(1));
        assertEquals((Integer) 99, test.getStatistics(2));
    }


}
