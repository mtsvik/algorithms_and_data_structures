package QueueAndStack;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 19.10.13
 */
public interface Queue<E> {
    void enqueue(E element);
    E dequeue();
}
