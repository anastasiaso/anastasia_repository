package juice;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SortThread implements Runnable {
    
    public ArrayList<Definition> list = new ArrayList<>();
    
    @Override
    public void run() {
        try {  
            sort();
        } catch (IOException ioe) {
            System.out.println("Exception!");
        }
    }

    public void sort() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("juice.txt"));
        String s;
        Juice A = new Juice();
        while ((s = in.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(s, " ;");
            while (tokenizer.hasMoreTokens()) {
                s = tokenizer.nextToken();
                boolean find = false;
                for (Definition str : list) {
                    if (find = str.getComponents().equals(s)) {
                        break;
                    }
                }
                if (!find) {
                    list.add(new Definition(s));
                }
            }
        }
        Collections.sort(list, new Comparator<Definition>() {
            @Override
            public int compare(Definition o1, Definition o2) {
                return o1.getComponents().compareTo(o2.getComponents());
            }
        }
        );
        Iterator<Definition> it = list.iterator();
        Definition a;
        BufferedWriter out = new BufferedWriter(new FileWriter("juice2.txt"));
        while (it.hasNext()) {
            a = it.next();
            out.write(a.getComponents());
            out.newLine();
        }
        out.close();
    }
}
