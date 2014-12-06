package Heap;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 01.11.13
 */
public class HeapImplTest {


    @Test
    public void testInsert() {
        Integer[] arr = {1, 5, 7, 18, -5};
        HeapImpl<Integer> heap = new HeapImpl<>(arr);
        heap.extractMaximum();
        heap.insert(8);
        for (int i = heap.getSize() - 1; i < 0; i--) {
            if (heap.getArray()[i].compareTo(heap.getArray()[heap.parent(i)]) > 0)
                fail("Heap error");
        }
    }

    @Test
    public void testGetMaximum() {
        Integer[] arr = {1, 5, 7, 18, -5};
        HeapImpl<Integer> heap = new HeapImpl<>(arr);
        assertEquals(heap.getMaximum(), (Integer) 18);

    }

    @Test
    public void testExtractMaximum() {
        Integer[] arr = {1, 5, 7, 18, -5};
        HeapImpl<Integer> heap = new HeapImpl<>(arr);
        assertEquals(heap.extractMaximum(), (Integer) 18);
        for (int i = heap.getSize() - 1; i < 0; i--) {
            if (heap.getArray()[i].compareTo(heap.getArray()[heap.parent(i)]) > 0)
                fail("Extract error");
        }
    }

    @Test
    public void testInsertFullHeap() {
        Integer[] arr = {1, 5, 7, 18, -5};
        HeapImpl<Integer> heap = new HeapImpl<>(arr);
        try {
            heap.insert(9);
        } catch (IndexOutOfBoundsException e) {
            // Exception
        }
    }

    @Test
    public void testExtractMaximumEmptyHeap() {
        Integer[] arr = {};
        HeapImpl<Integer> heap = new HeapImpl<>(arr);
        try {
            heap.extractMaximum();
        } catch (NullPointerException e) {
            // Exception
        }
    }
}
