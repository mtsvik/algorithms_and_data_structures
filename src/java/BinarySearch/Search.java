package BinarySearch;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 07.10.13
 */
public interface Search<T extends Comparable<T>> {
    int findIndex(List<T> data, T itemToFind);
}
