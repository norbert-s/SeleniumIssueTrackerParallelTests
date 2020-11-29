package testdatamanipulation;

import utility.Prop;

import javax.annotation.concurrent.ThreadSafe;
import java.io.*;
import java.util.Properties;
import java.util.Random;

public @ThreadSafe interface ReadTxt extends Prop{



    public default String returnRandomLineNumberOfIds() throws IOException {
        properties();
        String readFileFrom = prop.getProperty("txtlocation");
        System.out.println(readFileFrom);
        FileReader file = new FileReader(readFileFrom);
        BufferedReader reader = new BufferedReader(file);
        Random random = new Random();
        int max = 9;
        int min = 1;
        int lineNumber = (int) ((Math.random() * ((max - min) + 1)) + min);
//        lineNumber = 2;
        System.out.println("linenumber"+lineNumber);
        String line = "";
        for(int i=1;i<=lineNumber;i++){
            line = reader.readLine();
        }
        return line;
    }
}
