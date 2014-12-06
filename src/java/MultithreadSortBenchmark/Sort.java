package MultithreadSortBenchmark;

/**
 Created with IntelliJ IDEA.
 User: mtsvik
 Date: 08.11.13
 */
public interface Sort {
    public void sort(Comparable[] items, int threads);
}
