package InsertionRBTree;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 20.11.13
 */
public interface Rotable<K extends Comparable<K>> {

    void rotateLeft(K key);

    void rotateRight(K key);
}

