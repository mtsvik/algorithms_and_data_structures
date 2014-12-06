package QueueAndStack;

import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 23.10.13
 */
public class QueueImplTest {

    @Test
    public void testDequeueEmptyQueue() {
        QueueImpl<String> queue = new QueueImpl<>(new String[3]);
        try {
            queue.dequeue();
            fail("Queue is empty!");
        } catch (IllegalStateException e) {
        }
    }

    @Test
    public void testDequeue() {
        QueueImpl<Integer> queue = new QueueImpl<>(new Integer[3]);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        assertEquals((Integer) 2, queue.dequeue());
    }

    @Test
    public void testEnqueue() {
        QueueImpl<Integer> queue = new QueueImpl<>(new Integer[3]);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        Integer[] expected = {4, 2, 3};
        assertArrayEquals(expected, queue.getArray());
    }

    @Test
    public void testSlipperyHeadManipulations() {
        Queue<Integer> queue = new QueueImpl<>(new Integer[2]);
        queue.enqueue(2);
        assertEquals(new Integer(2), queue.dequeue());
    }


}
