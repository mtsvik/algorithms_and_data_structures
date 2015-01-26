package SortedandBinaryHeapDynamicProgramming;

import java.util.Arrays;

/**
 * Author: Mikhail Tsvik (tsvik@me.com)
 * Date: 11.03.14
 */

public class SortedHeap<E extends Comparable<E>> implements Heap<E> {

    private E[] data;
    private int currentSize;

    /**
     * @param maxSize - size of heap.
     */
    @SuppressWarnings("unchecked")
    public SortedHeap(int maxSize) {
        this.data = (E[]) new Comparable[maxSize];
        this.currentSize = 0;
    }

    /**
     * It's adds an element to heap using binary search.
     * Is used here native method System.arraycopy because it works faster then cycle.
     *
     * @param elem - item to be added to heap.
     *
     * @throws java.lang.NullPointerException      if added element is null.
     * @throws java.lang.IndexOutOfBoundsException if heap is full.
     */
    @Override
    public void add(E elem) {
        if (elem == null) throw new NullPointerException("Added element shouldn't be null");
        if (currentSize == data.length) throw new IndexOutOfBoundsException("Heap is full");
        if (currentSize == 0) {
            data[0] = elem;
            currentSize++;
        } else {
            int index = -1 * (Arrays.binarySearch(data, 0, currentSize, elem) + 1);
            if (data[index] != null) {
                System.arraycopy(data, index, data, index + 1, currentSize - (index));
            }
            data[index] = elem;
            currentSize++;
        }
    }

    private boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * @return element with highest priority.
     * @throws java.lang.IllegalStateException if heap is empty.
     */
    @Override
    public E first() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        return data[0];
    }

    /**
     * It's checks contains element in array using binary search.
     *
     * @param elem - element which is checked.
     */
    @Override
    public boolean contains(E elem) {
        return (Arrays.binarySearch(data, 0, currentSize, elem)) != -1;
    }

    /**
     * It's returns element with highest priority and removes it from heap.
     * Is used here native method System.arraycopy because it works faster then cycle.
     *
     * @return element with highest priority.
     * @throws java.lang.IllegalStateException if heap is empty.
     */
    @Override
    public E retrieve() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        E result = data[0];
        System.arraycopy(data, 1, data, 0, currentSize - 1);
        data[--currentSize] = null;
        return result;
    }
}
