package sum_to;

import java.util.List;

public class CountSets {
    private List<int[]> sets;
    private long count;

    public CountSets(List<int[]> sets, long count) {
        this.sets = sets;
        this.count = count;
    }

    public List<int[]> getSets() {
        return sets;
    }

    public void setSets(List<int[]> sets) {
        this.sets = sets;
    }

    public long getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
