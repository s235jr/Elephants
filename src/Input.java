import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Input {

    private int n;
    private List<Integer> m;
    private List<Integer> a;
    private List<Integer> b;

    public Input() {
        this.m = new ArrayList<>();
        this.a = new ArrayList<>();
        this.b = new ArrayList<>();
    }

    public Input read(Scanner scanner) {

        this.n = Integer.parseInt(scanner.next());

        for (int i = 0; i < n; i++) {
            m.add(Integer.parseInt(scanner.next()));
        }
        for (int i = 0; i < n; i++) {
            a.add(Integer.parseInt(scanner.next()));
        }
        for (int i = 0; i < n; i++) {
            b.add(Integer.parseInt(scanner.next()));
        }
        return this;
    }

    public Map<Integer, Integer> generatePermutation() {
        Map<Integer, Integer> permutation = new HashMap<>();
        for (int i = 0; i < this.n; i++) {
            permutation.put(this.b.get(i), this.a.get(i));
        }
        return permutation;
    }

    public List<List<Integer>> generateParse(Map<Integer, Integer> permutation) {

        Map<Integer, Boolean> isCorrectPosition = new HashMap<>();
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> inner;

        for (int i = 1; i < this.a.size(); i++) {
            if (!(isCorrectPosition.getOrDefault(i, false))) {
                inner = new ArrayList<>();
                int x = i;
                while (!(isCorrectPosition.getOrDefault(x, false))) {
                    isCorrectPosition.put(x, true);
                    inner.add(permutation.get(x));
                    x = permutation.get(x);
                }
                outer.add(inner);
            }
        }
        return outer;
    }

    public int findMin() {

        int minMasElephant = m.get(0);
        for (int i = 0; i < this.m.size(); i++) {
            if (this.m.get(i) < minMasElephant) {
                minMasElephant = this.m.get(i);
            }
        }
        return minMasElephant;
    }

    public long findResult(List outer, int min) {

        long result = 0;

        for (int i = 0; i < outer.size(); i++) {

            Cycle cycle = new Cycle();
            cycle.findParameterOfCycle(this.m, (ArrayList) outer.get(i), min);
            long methodOne = cycle.getSumMasOfElephantCycle() + (cycle.getLengthCycle() - 2) * cycle.getMinElephantMasForCycle();
            long methodTwo = cycle.getSumMasOfElephantCycle() + cycle.getMinElephantMasForCycle() + (cycle.getLengthCycle() + 1) * cycle.getMinElephantMas();
            result = result + Math.min(methodOne, methodTwo);
        }
        return result;
    }
}