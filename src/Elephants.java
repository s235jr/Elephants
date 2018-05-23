import java.util.ArrayList;

public class Elephants {

    private int[] m;
    private int[] a;
    private int[] b;

    public Elephants(int[] m, int[] a, int[] b) {
        this.m = m;
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {


        String filePath = "/home/s235jr/workspace/Elephants/InputFiles/slo1.in"; //scieżka dla linuksa
        
        ReadingInput readingInput = new ReadingInput(filePath).reading();
        int[] m = readingInput.getM();
        int[] a = readingInput.getA();
        int[] b = readingInput.getB();

        Elephants impiCode = new Elephants(m, a, b);
        int[] permutation = impiCode.generatePermutation();
        ArrayList<ArrayList<Integer>> outer = impiCode.generateParse(permutation);

        int min = impiCode.findMin();
        long wynik = impiCode.findResult(outer, min);
        System.out.println(wynik);

    }

    int[] generatePermutation() {

        int[] permutation = new int[this.a.length];

        for (int i = 0; i < this.a.length; i++) {
            permutation[this.b[i] - 1] = this.a[i];
        }
        return permutation;
    }

    ArrayList<ArrayList<Integer>> generateParse(int[] permutation) {

        boolean[] isCorrectElephant = new boolean[this.a.length];
        ArrayList<ArrayList<Integer>> outer = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> inner = new ArrayList<Integer>();

        for (int i = 0; i < this.a.length; i++) {

            if (!(isCorrectElephant[i])) {
                inner = new ArrayList<Integer>();
                int x = i;
                while (!(isCorrectElephant[x])) {
                    isCorrectElephant[x] = true;
                    inner.add(x + 1);
                    x = permutation[x] - 1;
                }
                outer.add(inner);
            }
        }
        return outer;
    }

    int findMin() {

        int min = this.m[0];

        for (int i = 0; i <= this.m.length - 1; i++) {
            if (this.m[i] < min) {
                min = this.m[i];
            }
        }
        return min;
    }

    long findResult(ArrayList outer, int min) {

        long wynik = 0;

        for (int i = 0; i < outer.size(); i++) {

            Cycle cycle = new Cycle();
            cycle.findParameterOfCycle(this.m,(ArrayList) outer.get(i), min);
            long metoda1 = cycle.sumMasOfElephantCycle + (cycle.lengthCycle - 2) * cycle.minElephantMasForCycle;
            long metoda2 = cycle.sumMasOfElephantCycle + cycle.minElephantMasForCycle + (cycle.lengthCycle + 1) * cycle.minElephantMas;
            wynik = wynik + Math.min(metoda1, metoda2);
        }
        return wynik;
    }

}