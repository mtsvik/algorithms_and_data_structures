package QueueAndStack;

import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 18.10.13
 */
public class StackImplTest {

    @Test
    public void testStack() {
        Integer[] arr = new Integer[5];
        Stack<Integer> stack = new StackImpl<>(arr);
        for (int i = 1; i < 6; i++) {
            stack.push(i);
        }
        Integer[] expected = {5, 4, 3, 2, 1};
        Integer[] myArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            myArr[i] = stack.pop();
        }
        assertArrayEquals(expected, myArr);
    }

    @Test
    public void testPopEmptyStack() {
        Stack<Integer> stack = new StackImpl<>(new Integer[5]);
        try {
            stack.pop();
            fail("Stack is empty");
        } catch (EmptyStackException e) {
        }
    }

    @Test
    public void testIsEmpty() {
        Stack<Integer> stack = new StackImpl<>(new Integer[1]);
        assertEquals(true, stack.isEmpty());
        Stack<Integer> stack1 = new StackImpl<>(new Integer[1]);
        stack1.push(1);
        assertEquals(false, stack1.isEmpty());
    }


}
