package juice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Definition {
    
    private String components;
    
    public Definition(String str){
        this.components = str;
    }

    public String getComponents() {
        return components;
    }
    
    public int getComponentsLength() {
        return components.length();
    }

    public void setComponents(String components) {
        this.components = components;
    }
    
    
 
}
