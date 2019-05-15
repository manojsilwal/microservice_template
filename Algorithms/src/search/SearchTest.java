package search;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class SearchTest {

    HashMap<String, TestResult> testResultHashMap = new HashMap<>();

    @Test
    public void searchAllElements() throws Exception {
        List<Integer> param1 = Arrays.asList(1, 2, 3, 4);
            for (int i = 0; i < param1.size(); i++) {
                HashMap<String, Integer> integerHashMap = testResult(param1, param1.get(i));
                Set<Map.Entry<String, Integer>> entries = integerHashMap.entrySet();
                for (Map.Entry<String, Integer> m: entries){
                    assertEquals(m.getValue().intValue(), i);
                }
            }
        }

    @Test
    public void searchLowerBoundValue() throws Exception {
        List<Integer> param1 = Arrays.asList(1, 2, 3, 4);
        HashMap<String, Integer> integerHashMap = testResult(param1, 0);
        Set<Map.Entry<String, Integer>> entries = integerHashMap.entrySet();
        for (Map.Entry<String, Integer> m: entries){
            assertEquals(m.getValue().intValue(), -1);
        }
    }

    @Test
    public void searchUpperBoundValue() throws Exception {
        List<Integer> param1 = Arrays.asList(1, 2, 3, 4);
        HashMap<String, Integer> integerHashMap = testResult(param1, 5);
        Set<Map.Entry<String, Integer>> entries = integerHashMap.entrySet();
        for (Map.Entry<String, Integer> m: entries){
            assertEquals(m.getValue().intValue(), -1);
        }
    }

    private HashMap<String, Integer> testResult(List<Integer> list, Integer value) throws Exception {

        SearchInterface search = new Search();
        Method[] allMethods = SearchInterface.class.getDeclaredMethods();
        HashMap<String, Integer> integerHashMap = new HashMap<>();
        for (Method m : allMethods) {
            String mName = m.getName();
            System.out.printf("invoking %s()%n", mName);
            Method method = Search.class.getDeclaredMethod(mName, List.class, Integer.class);
            integerHashMap.put(mName, (Integer) method.invoke(search, list, value));
        }
        return integerHashMap;
    }
}
