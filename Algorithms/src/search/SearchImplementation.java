package search;

import java.util.Arrays;
import java.util.List;

public class SearchImplementation {

    public static void main(String[] args) {
        Search search = new Search();

        Long start1 = System.nanoTime();
        List<Integer> list = Arrays.asList(1,2,3,4);
        System.out.println(System.nanoTime() - start1);
        System.out.println(search.linearSearch(list, 4));


        Long start2 = System.nanoTime();
        System.out.println(System.nanoTime() - start2);
        System.out.println(search.binarySearch(list, 4));
    }
}
