import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Elephants {

    public static void main(String[] args) throws FileNotFoundException {

        String filePath = "InputFiles/slo1.in"; //scieżka dla linuksa
        Scanner scanner = new Scanner(new File(filePath));
        //Scanner scanner = new Scanner(System.in);

        Input input = new Input();
        input.read(scanner);
        Map<Integer, Integer> permutation = input.generatePermutation();
        List<List<Integer>> permutationList = input.generateParse(permutation);
        int minMasElephant = input.findMin();
        long result = input.findResult(permutationList, minMasElephant);
        System.out.println(result);
    }
}