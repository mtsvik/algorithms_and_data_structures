package Clustering;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Author: Mikhail Tsvik (tsvik@me.com)
 * Date: 05.04.14
 */

public class EntityImpl implements ClusteringAlgorithm.Entity {

    private String name;
    private static AtomicLong id = new AtomicLong();
    private final double[] coords;

    public EntityImpl(double[] coords) {
        this.name = String.valueOf(id.incrementAndGet());
        this.coords = coords;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public double[] getCoordinates() {
        return coords;
    }
}
