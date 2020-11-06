import java.util.*;
import java.io.*;
public class Test {

    public static void main(String[] args){

        //读入
        File file = new File(args[0]);
        BufferedReader r;
        StringBuilder in = null;
        try{
            r = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
            in = new StringBuilder(r.readLine());
        }catch(IOException e){
            e.printStackTrace();
        }

        OperaterFirst a = new OperaterFirst(in.toString());
        a.OperaterFirstMethod();

    }

}
