package QueueAndStack;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 19.10.13
 */
public class QueueImpl<E> implements Queue<E> {
    private int head;
    private int tail;
    private int currentItems;
    private final E[] arr;

    public QueueImpl(E[] data) {
        this.arr = data;
        this.head = 0;
        this.tail = -1;
        this.currentItems = 0;
    }

    @Override
    public void enqueue(E element) {
        if (tail == arr.length - 1) {
            tail = 0;
        } else {
            tail++;
        }
        if (head == tail && currentItems > 1) {
            if (head == arr.length - 1) {
                head = 0;
            } else {
                head = tail + 1;
            }
        }
        arr[tail] = element;
        if (!isFull()) {
            currentItems++;
        }
    }

    @Override
    public E dequeue() {
        E element;
        if (isEmpty()) {
            throw new IllegalStateException();
        } else {
            if (head == arr.length - 1) {
                element = arr[head];
                arr[head] = null;
                head = 0;
            } else {
                element = arr[head];
                arr[head] = null;
                head++;
            }
            currentItems--;
            return element;
        }
    }

    public boolean isFull() {
        return currentItems == arr.length ? true : false;
    }

    public boolean isEmpty() {
        return currentItems == 0;
    }

    E[] getArray() {
        return arr;
    }
}
