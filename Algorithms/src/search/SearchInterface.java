package search;

import java.util.List;

public interface SearchInterface {
    int linearSearch(List<Integer> list, Integer value);
    int binarySearch(List<Integer> list, Integer value);
}
