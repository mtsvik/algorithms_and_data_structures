package Clustering;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Author: Mikhail Tsvik (tsvik@me.com)
 * Date: 05.04.14
 */

public class HierarchicalClustering implements ClusteringAlgorithm {

    private List<Cluster> createClusters(Iterable<Entity> entities) {
        List<Cluster> clusters = new ArrayList<>();
        for (Entity entity : entities) {
            clusters.add(new ClusterImpl(entity));
        }
        return clusters;
    }

    private Map<Cluster, Map<Cluster, Double>> calcDistances(List<Cluster> clusters, DistanceCalculator distanceCalculator) {
        Map<Cluster, Map<Cluster, Double>> distances = new HashMap<>();
        for (Cluster cluster1 : clusters) {
            Map<Cluster, Double> distancesFromClusterToAllClusters = new HashMap<>();
            for (Cluster cluster2 : clusters) {
                distancesFromClusterToAllClusters.put(cluster2, distanceCalculator.getDistance(cluster1.getEntities().get(0), cluster2.getEntities().get(0)));
            }
            distances.put(cluster1, distancesFromClusterToAllClusters);
        }
        return distances;
    }

    private void changeDistances(Map<Cluster, Map<Cluster, Double>> distances, Cluster newCluster, Cluster deletedCluster) {
        Map<Cluster, Double> newClusterDistances = distances.get(newCluster);
        Map<Cluster, Double> deletedClusterDistances = distances.get(deletedCluster);
        double dist = 0;
        for (Cluster cluster : newClusterDistances.keySet()) {
            dist = (newClusterDistances.get(cluster) + deletedClusterDistances.get(cluster)) / 2;
            newClusterDistances.put(cluster, dist);
            distances.get(cluster).put(newCluster, dist);
        }
        distances.remove(deletedCluster);
        for (Cluster cluster : distances.keySet()) {
            distances.get(cluster).remove(deletedCluster);
            distances.get(cluster).put(newCluster, newClusterDistances.get(cluster));
        }
    }

    private void mergeClusters(Map<Cluster, Map<Cluster, Double>> distances, List<Cluster> clusters) {
        double minDistance = Double.MAX_VALUE;
        double distance = 0;
        Cluster[] mergeClusters = new Cluster[2];
        for (Cluster cluster1 : clusters) {
            for (Cluster cluster2 : distances.get(cluster1).keySet()) {
                distance = distances.get(cluster1).get(cluster2);
                if (distance < minDistance && !cluster1.equals(cluster2)) {
                    minDistance = distance;
                    mergeClusters[0] = cluster1;
                    mergeClusters[1] = cluster2;
                }
            }
        }
        mergeClusters[0].getEntities().addAll(mergeClusters[1].getEntities());
        clusters.remove(mergeClusters[1]);
        changeDistances(distances,mergeClusters[0], mergeClusters[1]);
    }

    @Override
    public List<Cluster> getClusters(Iterable<Entity> entities, DistanceCalculator distanceCalculator, int maxClusters) {
        List<Cluster> clusters = createClusters(entities);
        checkArgument(clusters.size() != 0, "Number of clusters is 0");
        checkArgument(maxClusters > 0, "Number of maximum clusters must be larger then 0");
        checkNotNull(distanceCalculator);
        while (clusters.size() > maxClusters) {
            mergeClusters(calcDistances(clusters, distanceCalculator), clusters);
        }
        return clusters;
    }
}