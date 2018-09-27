import java.util.List;

public class Cycle {

    private long lengthCycle;
    private long sumMasOfElephantCycle;
    private long minElephantMasForCycle;
    private long minElephantMas;

    public void findParameterOfCycle(List m, List inner, int min) {

        long sumMasOfElephantCycle = 0;
        int minElephantMasForCycle = 6500;

        for (int i = 0; i < inner.size(); i++) {
            sumMasOfElephantCycle = sumMasOfElephantCycle + (Integer) m.get((Integer) inner.get(i) - 1);

            if (minElephantMasForCycle > (Integer) m.get((Integer) inner.get(i) - 1)) {
                minElephantMasForCycle = (Integer) m.get((Integer) inner.get(i) - 1);
            }
        }
        this.lengthCycle = inner.size();
        this.sumMasOfElephantCycle = sumMasOfElephantCycle;
        this.minElephantMasForCycle = minElephantMasForCycle;
        this.minElephantMas = min;

    }

    public long getLengthCycle() {
        return lengthCycle;
    }

    public long getSumMasOfElephantCycle() {
        return sumMasOfElephantCycle;
    }

    public long getMinElephantMasForCycle() {
        return minElephantMasForCycle;
    }

    public long getMinElephantMas() {
        return minElephantMas;
    }

}