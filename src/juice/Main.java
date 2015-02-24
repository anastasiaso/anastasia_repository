package juice;

import java.io.*;

public class Main {
        
    public static void main(String[] args) throws IOException {
        Juice A = new Juice();
        A.readFile();
        A.writeFile();
        SortThread r = new SortThread();
        Thread t = new Thread(r);
        t.start();
        A.counter();
    }
}
