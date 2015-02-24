package juice;

import java.io.*;
import java.util.*;

public class Juice {

    public ArrayList<Definition> list = new ArrayList<>();
    public ArrayList<Juicer> juiceList = new ArrayList<>();

    public void readFile() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("juice.txt"));
        String s;
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
    }
    
    public void writeFile() throws IOException{
        Iterator<Definition> it = list.iterator();
        Definition a;
        BufferedWriter out = new BufferedWriter(new FileWriter("juice1.txt"));
        while (it.hasNext()) {
            a = it.next();
            out.write(a.getComponents());
            out.newLine();
        }
        out.close();
    }  
    
    public void counter() throws IOException{
        BufferedReader in = new BufferedReader(new FileReader("juice.txt"));
        String s;
        char [] array;
        
        while ((s = in.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(s, ";");
            while (tokenizer.hasMoreTokens()) {
                s = tokenizer.nextToken();               
                juiceList.add(new Juicer(s));
                boolean find = false;
                for (Juicer str : juiceList) {
                    if (find = str.getJuice().equals(s)) {
                        break;
                    }
                }
//                if (!find) {
//                    list.add(new Definition(s));
//                }
            }
        }
        Collections.sort(juiceList, new Comparator<Juicer>() {
            @Override
            public int compare(Juicer o1, Juicer o2) {
                return o1.getJuiceLength()-o2.getJuiceLength();
            }
        }
        );
        Iterator<Juicer> it = juiceList.iterator();
        Juicer a;
        int num = 1;
        BufferedWriter out = new BufferedWriter(new FileWriter("juice3.txt"));
        while (it.hasNext()) {
            a = it.next();
            out.write(a.getJuice());
            out.newLine();
            num++;
        }
        out.newLine();
        out.write(Integer.toString(num));
        out.close();
        
    }           
}
