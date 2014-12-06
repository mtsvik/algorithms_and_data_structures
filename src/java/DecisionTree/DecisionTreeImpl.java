package DecisionTree;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Author: Mikhail Tsvik (tsvik@me.com)
 * Date: 06.03.14
 */

public class DecisionTreeImpl<E extends Enum<E>> implements DecisionTree {
    private final Node<E> root;

    /**
     * @param root - root node of tree.
     *
     * @throws java.lang.NullPointerException if root is null.
     */
    public DecisionTreeImpl(Node<E> root) {
        this.root = checkNotNull(root);
    }

    /**
     * @param entity - object - data structure stores the attributes of entities.
     *
     * @return result category satisfying attributes.
     */
    @Override
    public E getCategory(Entity entity) {
        Node<E> current = root;
        while (current.hasChild()) {
            if (current.factor.is(entity)) {
                current = current.trueChild;
            } else {
                current = current.falseChild;
            }
        }
        return current.resultCategory;
    }

    @Override
    public String toString() {
        StringBuilder tree = new StringBuilder();
        recursivePrintTree(root, tree, new StringBuilder(), "");
        return tree.toString();
    }

    /**
     * It's method for recursive printing of tree. Using in toString().
     *
     * @param node   - start node, and then recursively transmitted his children.
     * @param tree   - basic string builder for tree.
     * @param tabs   - special string builder for tabs.
     * @param branch - pointer to the true or false branch.
     */
    public void recursivePrintTree(Node node, StringBuilder tree, StringBuilder tabs, String branch) {
        tree.append(tabs.toString()).append(branch);
        tabs.append("    ");
        if (node.isNotLeaf()) {
            tree.append(node).append("\n");
        } else {
            tree.append(node).append("\n");
            return;
        }
        recursivePrintTree(node.falseChild, tree, tabs, "F:");
        tabs.delete(0, 4);
        recursivePrintTree(node.trueChild, tree, tabs, "T:");
        tabs.delete(0, 4);

    }

    protected static class Node<E> {
        private Node<E> falseChild;
        private Node<E> trueChild;
        private Factor factor;
        private E resultCategory;

        /**
         * It's  constructor if node is node.
         *
         * @param trueChild  - link to true child.
         * @param falseChild - link to false child.
         * @param factor     - particular attribute of node.
         *
         * @throws java.lang.NullPointerException if node doesn't have child or if factor is null.
         */
        public Node(Node<E> trueChild, Node<E> falseChild, Factor factor) {
            this.falseChild = checkNotNull((falseChild), "Node should have child");
            this.trueChild = checkNotNull((trueChild), "Node should have child");
            this.factor = checkNotNull((factor), "Factor shouldn't be null");
        }

        /**
         * It's constructor if node is leaf.
         *
         * @param resultCategory - result category of tree (leaf).
         *
         * @throws java.lang.NullPointerException if category is null.
         */
        public Node(E resultCategory) {
            this.resultCategory = checkNotNull((resultCategory), "Category shouldn't be null");
        }

        /**
         * This method checks that node is not leaf.
         *
         * @return true if node is node or returns false if node is leaf.
         */
        public boolean isNotLeaf() {
            return (resultCategory == null);
        }

        /**
         * This method prints node or leaf.
         *
         * @return string representation of node.
         */
        @Override
        public String toString() {
            if (resultCategory == null) {
                return factor.name();
            } else return (resultCategory.toString());
        }

        /**
         * @return true if node has child or false if not.
         */
        public boolean hasChild() {
            return ((falseChild != null) && (trueChild != null));
        }
    }

    protected static class FactorImpl implements Factor {
        private String name;
        private String value;

        /**
         * @param factorName  - name of factor.
         * @param factorValue - value of factor.
         *
         * @throws java.lang.IllegalArgumentException if name or value is empty strings.
         */
        public FactorImpl(String factorName, String factorValue) {
            this.name = factorName;
            this.value = factorValue;

            checkArgument(!(name.isEmpty()), "Name field shouldn't be empty");
            checkArgument(!(value.isEmpty()), "Value field shouldn't be empty");
        }

        @Override
        public String name() {
            return name + " " + value + "?";
        }

        /**
         * @param entity - object - data structure stores the attributes of entities.
         *
         * @return true if attribute of entity is equal factor.
         */
        @Override
        public boolean is(Entity entity) {
            return value.compareTo(entity.getAttributeValue(name)) == 0;
        }
    }

    protected static class EntityImpl implements Entity {
        private Map<String, String> entityData = new HashMap<>();

        /**
         * @param entityData - data structure that stores a set of attributes
         */
        public EntityImpl(Map<String, String> entityData) {
            this.entityData = entityData;
        }

        /**
         * @param key - name of attribute
         *
         * @return value of attribute
         * @throws java.lang.IllegalArgumentException if data is empty
         */
        @Override
        public String getAttributeValue(String key) {
            checkArgument(!(entityData.isEmpty()), "Entity data shouldn't be empty");
            return entityData.get(key);
        }
    }
}
