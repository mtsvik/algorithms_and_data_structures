package QueueAndStack;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 17.10.13
 */
public interface Stack<E> {
    void push(E element);
    E pop();
    boolean isEmpty();
}
