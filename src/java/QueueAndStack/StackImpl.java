package QueueAndStack;

import java.util.EmptyStackException;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 17.10.13
 */
public class StackImpl<E> implements Stack<E> {
    private int top;
    private final E[] arr;

    public StackImpl(E[] data) {
        this.arr = data;
        this.top = -1;
    }

    @Override
    public void push(E element) {
        arr[++top] = element;
    }

    @Override
    public E pop() {
        if (isEmpty()){
            throw new EmptyStackException();
        }
        E element = arr[top--];
        arr[--top] = null;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return (top == -1);
    }

}
