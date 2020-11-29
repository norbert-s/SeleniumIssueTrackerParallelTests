package testdatamanipulation;

import utility.Prop;

import javax.annotation.concurrent.ThreadSafe;
import java.io.*;

public @ThreadSafe interface SubWord extends Prop{
    
    String newFile = prop.getProperty("saveFileNew");
    public default String getString(int a) throws IOException {
        FileInputStream is = new FileInputStream(newFile+a+".txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String str;
        String szo="";
        while ((str = br.readLine()) != null)   {
            szo += str;
        }
        return szo;
    }
}
