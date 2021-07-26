package pojos;

import java.util.List;

public class CountSetsPojo {
    private List<int[]> sets;
    private int count;

    public CountSetsPojo(List<int[]> sets, int count) {
        this.sets = sets;
        this.count = count;
    }

    public List<int[]> getSets() {
        return sets;
    }

    public void setSets(List<int[]> sets) {
        this.sets = sets;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
