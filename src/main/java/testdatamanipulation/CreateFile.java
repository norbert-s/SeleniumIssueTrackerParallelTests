package testdatamanipulation;

import utility.Prop;

import javax.annotation.concurrent.ThreadSafe;
import java.io.*;

import java.util.Random;
public @ThreadSafe interface CreateFile extends Prop{



    //CreateFile cf = new CreateFile();
    String createFileNew = prop.getProperty("saveFileNew");
    String saveFileNew = prop.getProperty("saveFileNew");
    default  public String createData2(int num) throws IOException {
        Random number = new Random();
        int n = number.nextInt((1000-1)+1);
        Random character = new Random();
        File exists = new File(createFileNew+num+".txt");
        String b="";
        if(exists.exists()){
//            SubWord a = new SubWord();
//            a.getString(num);
            FileInputStream filereader = new FileInputStream(saveFileNew+num+".txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(filereader));
            String sor="";
            System.out.println("itt");

            while((sor=bufferedReader.readLine())!=null){
                b+=sor;
                System.out.println(sor);
            }
            System.out.println(b);

        }
        else{

            FileWriter file = new FileWriter(saveFileNew+num+".txt");
            char a,c;

            for(int i=0;i<num;i++){

                if(i%5==0){
                    c=(char)32;
                }
                else{
                    c = (char)(character.nextInt(26) + 'a');
                }

                b+= c;
            }
            System.out.println("b"+b);

            BufferedWriter output = new BufferedWriter(file);
            output.write(b);
//        output.flush();
            output.close();
        }


        return b;
    }
    default public String createData(int num) throws IOException {
        Random number = new Random();
        int n = number.nextInt((1000-1)+1);
        Random character = new Random();
        File exists = new File(saveFileNew+num+".txt");
        FileWriter file = new FileWriter(saveFileNew+num+".txt");
        char c;
        String b = "";
        for(int i=0;i<num;i++){

                if(i%5==0){
                    c=(char)32;
                }
                else{
                    c = (char)(character.nextInt(26) + 'a');
                }

                b+= c;
            }
            System.out.println("b"+b);
        BufferedWriter output = new BufferedWriter(file);
            output.write(b);
//        output.flush();
            output.close();
        return b;
    }

}
