package ru.ifmo.enf.tsvik.t11;

import java.util.List;

/**
 * Author: Mikhail Tsvik (tsvik@me.com)
 * Date: 05.04.14
 */

public interface ClusteringAlgorithm {

    /**
     * Строит список кластеров из исходных сущностей
     * @param entities исходные сущности
     * @param distanceCalculator стратегия расчета расстояния между сущностями
     * @param maxClusters число кластеров, после которого необходимо останавливать формирование кластеров
     * @return список полученных кластеров
     */
    List<Cluster> getClusters(Iterable<Entity> entities,
                              DistanceCalculator distanceCalculator,
                              int maxClusters);

    interface Cluster {
        List<Entity> getEntities();
    }

    interface Entity {

        /**
         * @return название сущности
         */
        String name();

        /**
         * @return координаты сущности в пространстве
         */
        double[] getCoordinates();
    }

    interface DistanceCalculator {
        /**
         * @return расстояние между сущностями e1 и e2
         */
        double getDistance(Entity e1, Entity e2);
    }
}