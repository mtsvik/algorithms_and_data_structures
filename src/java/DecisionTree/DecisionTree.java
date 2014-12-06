package DecisionTree;

/**
 Author: Mikhail Tsvik (tsvik@me.com)
 Date: 06.03.14
 */

public interface DecisionTree<E extends Enum<E>> {

    E getCategory(Entity entity);

    public interface Factor {
        String name();
        boolean is(Entity entity);
    }

    public interface Entity {
        String getAttributeValue(String key);
    }

}