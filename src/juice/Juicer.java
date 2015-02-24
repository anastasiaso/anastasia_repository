package juice;

public class Juicer {
    private String juice;
    
    public Juicer (String str){
        this.juice = str;
    }
    
    public String getJuice() {
        return juice;
    }
    
    public int getJuiceLength() {
        return juice.length();
    }

    public void setJuice(String juice) {
        this.juice = juice;
    }
}
