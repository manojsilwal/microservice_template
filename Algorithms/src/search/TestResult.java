package search;

import java.util.ArrayList;
import java.util.List;

public class TestResult {
    private List<Integer> resultIndex = new ArrayList<>();
    private long timeTaken;

    public List<Integer> getResultIndex() {
        return resultIndex;
    }

    public void setResultIndex(List<Integer> resultIndex) {
        this.resultIndex = resultIndex;
    }

    public long getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(long timeTaken) {
        this.timeTaken = timeTaken;
    }
}
