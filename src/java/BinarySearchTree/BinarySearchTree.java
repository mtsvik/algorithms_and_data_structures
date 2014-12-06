package BinarySearchTree;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 19.11.13
 */
public interface BinarySearchTree<K extends Comparable<K>, V> {

    List<Node<K, V>> getOrderedNodes();

    Node<K, V> find(K key);

    void insert(K key, V value);

    void remove(K key);

    interface Node<K extends Comparable<K>, V> {
        K getKey();
        V getValue();
    }

}
