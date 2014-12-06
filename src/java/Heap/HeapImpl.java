package Heap;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 26.10.13
 */
public class HeapImpl<E extends Comparable<E>> implements Heap<E> {

    private E[] array;
    private int size = 0;

    public HeapImpl(E[] array) {
        this.array = array;
        this.size = array.length;
        buildMaxHeap();
    }

     protected int parent(int index) {
        return index / 2;
    }

    private int left(int index) {
        return 2 * index + 1;
    }

    private int right(int index) {
        return 2 * index + 2;
    }

    private void maxHeapify(int index) {
        int left = left(index);
        int right = right(index);
        int largest = index;

        if (left < size && array[left].compareTo(array[largest]) > 0) {
            largest = left;
        }
        if (right < size && array[right].compareTo(array[largest]) > 0) {
            largest = right;
        }
        if (largest != index) {
            swap(index, largest);
            maxHeapify(largest);
        }
    }

    private void buildMaxHeap() {
        for (int i = size / 2; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    private void swap(int indexOne, int indexTwo) {
        E temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }

    @Override
    public void insert(E element) {
        if (size == array.length) {
            throw new IndexOutOfBoundsException("Heap is full");
        }
        size++;
        int i = size - 1;
        array[i] = element;
        while (i > 0 && array[parent(i)].compareTo(array[i]) < 0) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    @Override
    public E getMaximum() {
        return array[0];
    }

    @Override
    public E extractMaximum() {
        if (size == 0) {
            throw new NullPointerException("Heap is empty");
        }
        E max = array[0];
        array[0] = array[size - 1];
        size--;
        maxHeapify(0);
        array[size] = null;
        return max;
    }

    public E[] getArray() {
        return array;
    }

    public int getSize() {
        return size;
    }


}
