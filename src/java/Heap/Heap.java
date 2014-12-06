package Heap;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 26.10.13
 */
public interface Heap<E extends Comparable<E>> {
    void insert(E element);

    E getMaximum();

    E extractMaximum();
}
