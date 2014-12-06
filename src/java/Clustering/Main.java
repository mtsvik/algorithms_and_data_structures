package Clustering;

import java.util.ArrayList;

/**
 * Author: Mikhail Tsvik (tsvik@me.com)
 * Date: 19.04.14
 */

public class Main {
    public static void main(String[] args) {
        ArrayList<ClusteringAlgorithm.Entity> entities = new ArrayList<>();
        entities.add(new EntityImpl(new double[] {2, 0}));
        entities.add(new EntityImpl(new double[] {1, 2}));
        entities.add(new EntityImpl(new double[] {3, 1}));
        entities.add(new EntityImpl(new double[] {5, 4}));
        entities.add(new EntityImpl(new double[] {5, 5}));
        entities.add(new EntityImpl(new double[] {6, 5}));
        HierarchicalClustering clustering = new HierarchicalClustering();
        clustering.getClusters(entities, new DistanceCalculatorImpl(), 2);
    }
}
