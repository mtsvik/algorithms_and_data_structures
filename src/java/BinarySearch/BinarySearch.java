package BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 07.10.13
 */
public class BinarySearch<T extends Comparable<T>> implements Search<T> {
    private static final int NOT_FOUND = -1;

    @Override
    public int findIndex(List<T> data, T itemToFind) {
        List data2 = new ArrayList(data);
        Collections.sort(data2);
        if (data.equals(data2)) {
            return findIndex(data, itemToFind, 0, data.size() - 1);
        }
        else {
            throw new IllegalArgumentException("List not sorted");
        }
    }

    private int findIndex(List<T> data, T itemToFind, int low, int high) {
        if (low > high) {
            return NOT_FOUND;
        }

        int mid = (low + high) / 2;

        if (data.get(mid).compareTo(itemToFind) < 0) {
            return findIndex(data, itemToFind, mid + 1, high);
        } else if (data.get(mid).compareTo(itemToFind) > 0) {
            return findIndex(data, itemToFind, low, mid - 1);
        } else {
            return mid;
        }
    }

}


