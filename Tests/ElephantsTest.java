import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElephantsTest {

    @Test
    void checkResult01() throws Exception {

        String filePathInput = "C:\\git\\Elephants\\InputFiles\\slo1.in";
        String filePathResult = "C:\\git\\Elephants\\InputFiles\\slo1.out";
        test(filePathInput, filePathResult);
    }

    @Test
    void checkResult02() throws Exception {

        String filePathInput = "C:\\git\\Elephants\\InputFiles\\slo2.in";
        String filePathResult = "C:\\git\\Elephants\\InputFiles\\slo2.out";
        test(filePathInput, filePathResult);
    }

    @Test
    void checkResult03() throws Exception {

        String filePathInput = "C:\\git\\Elephants\\InputFiles\\slo3.in";
        String filePathResult = "C:\\git\\Elephants\\InputFiles\\slo3.out";
        test(filePathInput, filePathResult);
    }

    @Test
    void checkResult04() throws Exception {

        String filePathInput = "C:\\git\\Elephants\\InputFiles\\slo4.in";
        String filePathResult = "C:\\git\\Elephants\\InputFiles\\slo4.out";
        test(filePathInput, filePathResult);
    }

    @Test
    void checkResult05() throws Exception {

        String filePathInput = "C:\\git\\Elephants\\InputFiles\\slo5.in";
        String filePathResult = "C:\\git\\Elephants\\InputFiles\\slo5.out";
        test(filePathInput, filePathResult);
    }

    @Test
    void checkResult06() throws Exception {

        String filePathInput = "C:\\git\\Elephants\\InputFiles\\slo6.in";
        String filePathResult = "C:\\git\\Elephants\\InputFiles\\slo6.out";
        test(filePathInput, filePathResult);
    }

    @Test
    void checkResult07() throws Exception {

        String filePathInput = "C:\\git\\Elephants\\InputFiles\\slo7.in";
        String filePathResult = "C:\\git\\Elephants\\InputFiles\\slo7.out";
        test(filePathInput, filePathResult);
    }

    @Test
    void checkResult08() throws Exception {

        String filePathInput = "C:\\git\\Elephants\\InputFiles\\slo1ocen.in";
        String filePathResult = "C:\\git\\Elephants\\InputFiles\\slo1ocen.out";
        test(filePathInput, filePathResult);
    }

    @Test
    void checkResult09() throws Exception {

        String filePathInput = "C:\\git\\Elephants\\InputFiles\\slo2ocen.in";
        String filePathResult = "C:\\git\\Elephants\\InputFiles\\slo2ocen.out";
        test(filePathInput, filePathResult);
    }

    @Test
    void checkResult10() throws Exception {

        String filePathInput = "C:\\git\\Elephants\\InputFiles\\slo3ocen.in";
        String filePathResult = "C:\\git\\Elephants\\InputFiles\\slo3ocen.out";
        test(filePathInput, filePathResult);
    }

    @Test
    void checkResult11() throws Exception {

        String filePathInput = "C:\\git\\Elephants\\InputFiles\\slo3ocen.in";
        String filePathResult = "C:\\git\\Elephants\\InputFiles\\slo3ocen.out";
        test(filePathInput, filePathResult);
    }

    @Test
    void checkResult12() throws Exception {

        String filePathInput = "C:\\git\\Elephants\\InputFiles\\slo8a.in";
        String filePathResult = "C:\\git\\Elephants\\InputFiles\\slo8a.out";
        test(filePathInput, filePathResult);
    }

    @Test
    void checkResult13() throws Exception {

        String filePathInput = "C:\\git\\Elephants\\InputFiles\\slo8b.in";
        String filePathResult = "C:\\git\\Elephants\\InputFiles\\slo8b.out";
        test(filePathInput, filePathResult);
    }

    @Test
    void checkResult14() throws Exception {

        String filePathInput = "C:\\git\\Elephants\\InputFiles\\slo9a.in";
        String filePathResult = "C:\\git\\Elephants\\InputFiles\\slo9a.out";
        test(filePathInput, filePathResult);
    }

    @Test
    void checkResult15() throws Exception {

        String filePathInput = "C:\\git\\Elephants\\InputFiles\\slo9b.in";
        String filePathResult = "C:\\git\\Elephants\\InputFiles\\slo9b.out";
        test(filePathInput, filePathResult);
    }
    @Test
    void checkResult16() throws Exception {

        String filePathInput = "C:\\git\\Elephants\\InputFiles\\slo10a.in";
        String filePathResult = "C:\\git\\Elephants\\InputFiles\\slo10a.out";
        test(filePathInput, filePathResult);
    }

    @Test
    void checkResult17() throws Exception {

        String filePathInput = "C:\\git\\Elephants\\InputFiles\\slo10b.in";
        String filePathResult = "C:\\git\\Elephants\\InputFiles\\slo10b.out";
        test(filePathInput, filePathResult);
    }


    private void test(String filePathInput, String filePathResult) throws FileNotFoundException {
        Scanner scaner = null;
        ReadingInput readingInput = new ReadingInput(filePathInput).reading();
        int[] m = readingInput.getM();
        int[] a = readingInput.getA();
        int[] b = readingInput.getB();

        Elephants impiCode = new Elephants(m, a, b);
        int[] permutation = impiCode.generatePermutation();
        ArrayList<ArrayList<Integer>> outer = impiCode.generateParse(permutation);
        int min = impiCode.findMin();
        long wynik = impiCode.findResult(outer, min);
        Scanner scanerResult = null;
        scanerResult = new Scanner(new File(filePathResult));
        long resultExpected = Long.parseLong(scanerResult.next());
        assertEquals(resultExpected, wynik);
    }
}