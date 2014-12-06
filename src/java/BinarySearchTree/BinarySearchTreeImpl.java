package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 19.11.13
 */
public class BinarySearchTreeImpl<K extends Comparable<K>, V> implements BinarySearchTree<K, V> {

    protected Node root = null;

    public void insert(K key, V value) {
        addElement(key, value, root);
    }

    private void addElement(K key, V value, Node top) {
        if (root == null) {
            this.root = new Node(key, value);
        } else if (top.getKey().compareTo(key) >= 0) {
            if (top.left == null) {
                top.left = new Node(key, value);
            } else {
                addElement(key, value, top.left);
            }
        } else {
            if (top.right == null) {
                top.right = new Node(key, value);
            } else {
                addElement(key, value, top.right);
            }
        }
    }

    public BinarySearchTree.Node<K, V> find(K key) {
        return binarySearch(key, root);
    }

    protected BinarySearchTree.Node binarySearch(K key, Node top) {
        if (top == null) {
            return null;
        }
        if (key.compareTo((K) top.getKey()) == 0) {
            return top;
        } else if (key.compareTo((K) top.getKey()) < 0) {
            return binarySearch(key, top.left);
        } else {
            return binarySearch(key, top.right);
        }
    }

    public List<BinarySearchTree.Node<K, V>> getOrderedNodes() {
        List<BinarySearchTree.Node<K, V>> orderedArray = new ArrayList<>();
        spaceTree(orderedArray, root);
        return orderedArray;
    }

    private void spaceTree(List array, Node top) {
        if (top != null) {
            spaceTree(array, top.left);
            array.add(top);
            spaceTree(array, top.right);
        }
    }

    protected Node<K, V> maximum(Node top) {
        while (top.right != null) {
            top = top.right;
        }
        return top;
    }

    protected Node<K, V> getParent(Node node, Node root) {
        if (root.getKey().compareTo(node.getKey()) >= 0) {
            if (root.left.getKey() == node.getKey()) {
                return root;
            } else {
                return getParent(node, root.left);
            }
        } else {
            if (root.right.getKey() == node.getKey()) {
                return root;
            } else {
                return getParent(node, root.right);
            }
        }
    }

    public void remove(K key) {
        if (root.getKey() == key) {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                Node max = maximum(root.left);
                Node maxsParent = getParent(max, root);
                if (maxsParent.getKey().compareTo(max.getKey()) < 0) {
                    maxsParent.right = max.left;
                } else {
                    maxsParent.left = max.left;
                }
                max.left = root.left;
                max.right = root.right;
                root = max;
            }
        } else {
            Node<K, V> deletingElement = (Node) find(key);
            if (deletingElement == null) {
                return;
            }
            if (deletingElement.left == null) {
                Node parent = getParent(deletingElement, root);
                if (parent.getKey().compareTo(deletingElement.getKey()) < 0) {
                    parent.right = deletingElement.right;
                } else {
                    parent.left = deletingElement.right;
                }
            } else if (deletingElement.right == null) {
                Node parent = getParent(deletingElement, root);
                if (parent.getKey().compareTo(deletingElement.getKey()) < 0) {
                    parent.right = deletingElement.left;
                } else {
                    parent.left = deletingElement.left;
                }
            } else {
                Node max = maximum(deletingElement.left);
                Node maxsParent = getParent(max, root);
                if (maxsParent.getKey().compareTo(max.getKey()) < 0) {
                    maxsParent.right = max.left;
                } else {
                    maxsParent.left = max.left;
                }
                max.left = deletingElement.left;
                max.right = deletingElement.right;
                Node parent = getParent(deletingElement, root);
                if (parent.getKey().compareTo(deletingElement.getKey()) < 0) {
                    parent.right = max;
                } else {
                    parent.left = max;
                }
            }
        }
    }

    protected static class Node<K extends Comparable<K>, V> implements BinarySearchTree.Node {
        private final K key;
        private final V data;
        public Node left = null;
        public Node right = null;

        protected Node(K key, V data) {
            this.key = key;
            this.data = data;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return data;
        }
    }
}
