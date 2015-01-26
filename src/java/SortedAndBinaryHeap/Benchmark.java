package SortedandBinaryHeapDynamicProgramming;

import java.lang.reflect.InvocationTargetException;

/**
 * Author: Mikhail Tsvik (tsvik@me.com)
 * Date: 11.03.14
 */

public class Benchmark {
    private Heap<Integer> heap;

    /**
     * This constructor dynamically loads class with the desired implementation
     * of heap and evaluates performance of basic operations.≤
     *
     * @param heapImplementation - name of class of heap implementation.
     * @param sizeOfHeap         - size of heap.
     */
    @SuppressWarnings("unchecked")
    public Benchmark(String heapImplementation, int sizeOfHeap) {
        try {
            Class<Heap> heapImpl = (Class<Heap>) Class.forName(heapImplementation);
            heap = heapImpl.getConstructor(int.class).newInstance(sizeOfHeap);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println(heap.getClass().getSimpleName() + ":");

        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < sizeOfHeap; i++) heap.add(i);
        long timeEnd = System.currentTimeMillis();
        System.out.println("Added " + sizeOfHeap + " elements in " + (timeEnd - timeStart) + " ms");

        timeStart = System.currentTimeMillis();
        for (int i = 0; i < sizeOfHeap; i++) heap.retrieve();
        timeEnd = System.currentTimeMillis();
        System.out.println("Removed " + sizeOfHeap + " elements in " + (timeEnd - timeStart) + " ms" + "\n");

    }

}
