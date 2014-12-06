package Clustering;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Mikhail Tsvik (tsvik@me.com)
 * Date: 05.04.14
 */

public class ClusterImpl implements Cluster {

    private List<Entity> entities = new ArrayList<>();

    public ClusterImpl(Entity entity) {
        entities.add(entity);
    }

    @Override
    public List<Entity> getEntities() {
        return entities;
    }
}
