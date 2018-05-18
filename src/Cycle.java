import java.util.ArrayList;

public class Cycle {

    protected long lengthCycle;
    protected long sumMasOfElephantCycle;
    protected long minElephantMasForCycle;
    protected long minElephantMas;

    public Cycle() {

    }

    public Cycle(long lengthCycle, long sumMasOfElephantCycle, long minElephantMasForCycle, long minElephantMas) {
        this.lengthCycle = lengthCycle;
        this.sumMasOfElephantCycle = sumMasOfElephantCycle;
        this.minElephantMasForCycle = minElephantMasForCycle;
        this.minElephantMas = minElephantMas;
    }

    void findParameterOfCycle(int[] m, ArrayList inner, int min) {

        long sumMasOfElephantCycle = 0;
        int minElephantMasForCycle = 6500;

        for (int i = 0; i < inner.size(); i++) {
            sumMasOfElephantCycle = sumMasOfElephantCycle + m[Integer.parseInt(inner.get(i).toString()) - 1];

            if (minElephantMasForCycle > m[Integer.parseInt(inner.get(i).toString()) - 1]) {
                minElephantMasForCycle = m[Integer.parseInt(inner.get(i).toString()) - 1];
            }
        }
        this.lengthCycle = inner.size();
        this.sumMasOfElephantCycle = sumMasOfElephantCycle;
        this.minElephantMasForCycle = minElephantMasForCycle;
        this.minElephantMas = min;
    }
}