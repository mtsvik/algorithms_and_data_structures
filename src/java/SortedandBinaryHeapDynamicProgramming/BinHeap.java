package SortedandBinaryHeapDynamicProgramming;

import java.util.Arrays;

/**
 * Author: Mikhail Tsvik (tsvik@me.com)
 * Date: 11.03.14
 */

public class BinHeap<E extends Comparable<E>> implements Heap<E> {

    private final E[] data;
    private int currentSize;

    /**
     * @param maxSize - size of heap.
     */
    @SuppressWarnings("unchecked")
    public BinHeap(int maxSize) {
        this.data = (E[]) new Comparable[maxSize];
        this.currentSize = 0;
    }

    private int parent(int index) {
        return index / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private boolean isEmpty() {
        return currentSize == 0;
    }

    private void swap(int first, int second) {
        E tmp = data[first];
        data[first] = data[second];
        data[second] = tmp;
    }

    /**
     * It's supports property of heap.
     *
     * @param index - index at which to begin support.
     */
    private void minHeapify(int index) {
        int left = leftChild(index);
        int right = rightChild(index);
        int pointer = index;

        if (left < currentSize && data[left].compareTo(data[pointer]) < 0) {
            pointer = left;
        }
        if (right < currentSize && data[right].compareTo(data[pointer]) < 0) {
            pointer = right;
        }
        if (pointer != index) {
            swap(index, pointer);
            minHeapify(pointer);
        }
    }

    /**
     * It's raises element at the given index.
     *
     * @param index - index which rises up.
     */
    public void raiseUp(int index) {
        if (index != 0) {
            if (data[index].compareTo(data[parent(index)]) < 0) {
                swap(index, parent(index));
                index = parent(index);
                raiseUp(index);
            }
        }
    }

    /**
     * It's adds an element to heap.
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
        data[++currentSize - 1] = elem;
        raiseUp(currentSize - 1);
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
        return (Arrays.binarySearch(data, elem)) != -1;
    }

    /**
     * It's returns element with highest priority and removes it from heap.
     *
     * @return element with highest priority.
     * @throws java.lang.IllegalStateException if heap is empty.
     */
    @Override
    public E retrieve() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        E popped = first();
        data[0] = data[currentSize - 1];
        data[currentSize-- - 1] = null;
        minHeapify(0);
        return popped;
    }
}