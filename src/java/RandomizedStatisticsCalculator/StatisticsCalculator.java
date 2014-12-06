package RandomizedStatisticsCalculator;

/**
 Author: Mikhail Tsvik (tsvik@me.com)
 Date: 26.02.14.
 */

public interface StatisticsCalculator<E extends Comparable<E>> {
    E getStatistics(int k);
}