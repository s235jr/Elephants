import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadingInput {

    private String filePath;
    private int[] m;
    private int[] a;
    private int[] b;

    public ReadingInput(String filePath) {
        this.filePath = filePath;
    }

    public int[] getM() {
        return m;
    }

    public int[] getA() {
        return a;
    }

    public int[] getB() {
        return b;
    }

    public ReadingInput reading() {
        Scanner scaner = null;
        try {
            scaner = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int n = Integer.parseInt(scaner.next());

        m = new int[n];
        for (int i = 0; i < n; i++) {
            m[i] = Integer.parseInt(scaner.next());
        }
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(scaner.next());
        }
        b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(scaner.next());
        }
        return this;
    }
}