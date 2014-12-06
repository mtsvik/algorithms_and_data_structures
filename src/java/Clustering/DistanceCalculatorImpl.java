package Clustering;

import static com.google.common.base.Preconditions.checkState;

/**
 * Author: Mikhail Tsvik (tsvik@me.com)
 * Date: 05.04.14
 */

public class DistanceCalculatorImpl implements DistanceCalculator {

    @Override
    public double getDistance(Entity e1, Entity e2) {
        checkState(e1.getCoordinates().length == e2.getCoordinates().length, "Number of component not equals");
        double summ = 0;
        for (int i = 0; i < e1.getCoordinates().length ; i++) {
            summ += Math.pow((e1.getCoordinates()[i] - e2.getCoordinates()[i]), 2);
        }
        return Math.sqrt(summ);
    }
}
