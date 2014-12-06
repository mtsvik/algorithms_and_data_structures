package InsertionRBTree;

import BinarySearchTree.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 20.11.13
 */
public class InsertionRBTree<K extends Comparable<K>, V> implements BinarySearchTree<K, V>, Rotable<K> {
    protected NodeImpl<K, V> root;
    protected NodeImpl leave = new NodeImpl(null, null);

    public InsertionRBTree() {
        this.root = null;
    }

    @Override
    public List<Node<K, V>> getOrderedNodes() {
        List<Node<K, V>> list = new ArrayList<Node<K, V>>();
        inOrderTreeWalk(list, root);
        return list;
    }

    private void inOrderTreeWalk(List<Node<K, V>> list, NodeImpl<K, V> node) {
        if (node != null) {
            inOrderTreeWalk(list, node.getLeft());
            list.add(node);
            inOrderTreeWalk(list, node.getRight());
        }
    }

    @Override
    public NodeImpl find(Comparable key) {
        NodeImpl x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                return x;
            }
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return null;
    }

    @Override
    public void insert(Comparable key, Object value) {
        NodeImpl<K, V> x = root;
        NodeImpl<K, V> y = null;
        NodeImpl inserted = new NodeImpl(key, value);
        while (x != null) {
            y = x;
            if (inserted.getKey().compareTo(x.getKey()) < 0) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }
        inserted.setParent(y);
        if (y == null) {
            setRoot(inserted);
        } else if (inserted.getKey().compareTo(y.getKey()) < 0) {
            y.setLeft(inserted);
        } else {
            y.setRight(inserted);
        }
        insertFix(inserted);
    }

    private void insertFix(NodeImpl inserted) {
        inserted.setColor(Color.RED);
        while ((inserted != root) && (inserted.getParent().getColor() == Color.RED)) {
            if (inserted.getParent() == inserted.getGrandParent().getLeft()) {
                NodeImpl z = inserted.getGrandParent().getRight();
                if ((z != null) && (z.getColor() == Color.RED)) {
                    inserted.getParent().setColor(Color.BLACK);
                    z.setColor(Color.BLACK);
                    inserted.getGrandParent().setColor(Color.RED);
                    inserted = inserted.getGrandParent();
                } else {
                    if (inserted.equals(inserted.getParent().getRight())) {
                        inserted = inserted.getParent();
                        rotateLeft(inserted.getKey());

                    }

                    inserted.getParent().setColor(Color.BLACK);
                    inserted.getGrandParent().setColor(Color.RED);
                    rotateRight(inserted.getGrandParent().getKey());
                }
            } else {
                NodeImpl z = inserted.getGrandParent().getLeft();
                if ((z != null) && (z.getColor() == Color.RED)) {
                    inserted.getParent().setColor(Color.BLACK);
                    z.setColor(Color.BLACK);
                    inserted.getGrandParent().setColor(Color.RED);
                    inserted = inserted.getGrandParent();
                } else {
                    if (inserted.equals(inserted.getParent().getLeft())) {
                        inserted = inserted.getParent();
                        rotateRight(inserted.getKey());

                    }
                    inserted.getParent().setColor(Color.BLACK);
                    inserted.getGrandParent().setColor(Color.RED);
                    rotateLeft(inserted.getGrandParent().getKey());
                }
            }
        }
        root.setColor(Color.BLACK);
    }

    @Override
    public void remove(Comparable key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void rotateLeft(Comparable key) {
        NodeImpl x = find(key);
        if (x.getRight() != null) {
            NodeImpl y = x.getRight();
            x.setRight(y.getLeft());
            if (y.getLeft() != null) {
                y.getLeft().setParent(x);
            }
            y.setParent(x.getParent());
            if (x.getParent() == null) {
                setRoot(y);
            } else {
                if (x == x.getParent().getLeft()) {
                    x.getParent().setLeft(y);
                } else {
                    x.getParent().setRight(y);
                }
            }
            y.setLeft(x);
            x.setParent(y);
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public void rotateRight(Comparable key) {
        NodeImpl x = find(key);
        if (x.getLeft() != null) {
            NodeImpl y = x.getLeft();
            x.setLeft(y.getRight());
            if (y.getRight() != null) {
                y.getRight().setParent(x);
            }
            y.setParent(x.getParent());
            if (x.getParent() == null) {
                setRoot(y);
            } else {
                if (x == x.getParent().getRight()) {
                    x.getParent().setRight(y);
                } else {
                    x.getParent().setLeft(y);
                }
            }
            y.setRight(x);
            x.setParent(y);
        } else {
            throw new IllegalStateException();
        }
    }

    public String toString() {
        int lev = levels(root);
        StringBuilder[] values = new StringBuilder[lev + 1];
        StringBuilder[] dashes = new StringBuilder[lev + 1];
        toStringHelper(values, dashes, root, 0, max().toString().length(), lev);
        StringBuilder result = new StringBuilder(values[0]);
        for (int i = 1; i <= lev - 1; i++) {
            result.append("\n" + dashes[i] + "\n" + values[i]);
        }
        return result.toString();
    }

    private void toStringHelper(StringBuilder[] values, StringBuilder[] dashes, NodeImpl x, int line, int max, int levels) {
        int k = (int) Math.pow(2, levels - line - 1);
        StringBuilder space = new StringBuilder();
        for (int i = 1; i <= max; i++) {
            space.append(" ");
        }
        if (dashes[line] == null) {
            dashes[line] = new StringBuilder();
            values[line] = new StringBuilder();
            for (int i = 1; i <= k; i++) {
                dashes[line].append(space.toString());
                values[line].append(space.toString());
            }
        }
        if (line < levels) {
            if (x != null) {
                toStringHelper(values, dashes, x.getLeft(), line + 1, max, levels);
                StringBuilder btwSpace = new StringBuilder();
                while ((btwSpace.toString() + x.toString()).length() < max) {
                    btwSpace.append(" ");
                }
                values[line].append(btwSpace.toString());
                values[line].append(x.toString());
                dashes[line].append(btwSpace.toString());
                if (x.getParent() != null) {
                    if (x == x.getParent().getLeft()) {
                        for (int i = 3; i <= max; i++) {
                            dashes[line].append(" ");
                        }
                        dashes[line].append("/");
                    } else {
                        dashes[line].append("\\");
                        for (int i = 3; i <= max; i++) {
                            dashes[line].append(" ");
                        }
                    }
                }

                for (int i = 1; i <= k * 2 - 1; i++) {
                    values[line].append(space.toString());
                    dashes[line].append(space.toString());
                }
                toStringHelper(values, dashes, x.getRight(), line + 1, max, levels);
            } else {
                NodeImpl node = new NodeImpl(null, null);
                node.setLeft(null);
                node.setRight(null);
                toStringHelper(values, dashes, node.getLeft(), line + 1, max, levels);
                StringBuilder btwSpace = new StringBuilder();
                while (btwSpace.length() < max) {
                    btwSpace.append(" ");
                }
                values[line].append(btwSpace.toString());
                dashes[line].append(btwSpace.toString());
                for (int i = 1; i <= k * 2 - 1; i++) {
                    values[line].append(space.toString());
                    dashes[line].append(space.toString());
                }
                toStringHelper(values, dashes, node.getRight(), line + 1, max, levels);
            }
        }
    }

    private int levels(NodeImpl node) {
        if (node != null) {
            return 1 + Math.max(levels(node.getLeft()), levels(node.getRight()));
        } else return 0;
    }

    public NodeImpl max() {
        NodeImpl node = root;
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }

    public NodeImpl<K, V> getRoot() {
        return root;
    }

    public void setRoot(NodeImpl node) {
        this.root = node;
    }

    protected enum Color {
        RED, BLACK
    }

    protected class NodeImpl<K extends Comparable<K>, V> implements Node {
        private K key;
        private V value;
        private Color color;
        protected NodeImpl left;
        protected NodeImpl right;
        private NodeImpl parent;


        public NodeImpl(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public NodeImpl getLeft() {
            return left;
        }

        public void setLeft(NodeImpl node) {
            left = node;
        }

        public NodeImpl getRight() {
            return right;
        }

        public void setRight(NodeImpl node) {
            right = node;
        }

        public NodeImpl getParent() {
            return parent;
        }

        public void setParent(NodeImpl node) {
            parent = node;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color c) {
            color = c;
        }

        public NodeImpl getGrandParent() {
            assert parent != null;
            assert parent.parent != null;
            return parent.parent;
        }

        public String toString() {
            if (color == Color.BLACK) {
                return value.toString() + ", Black";
            } else {
                return value.toString() + ", Red";
            }
        }
    }
}

