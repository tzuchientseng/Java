package IO;
import java.io.*;
import java.util.*;

import java.io.IOException;
import java.io.InputStreamReader;

public class Consle_IO {
    public static void main(String[] args) throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br  = new BufferedReader(isr);
        String s = "";
        while(Objects.nonNull(s)){
            s = br.readLine();
            System.out.println("Read: " + s);
            if("exit".equalsIgnoreCase(s)){
                System.exit(0);
            } else if ("ls".equalsIgnoreCase(s)){
                System.out.println("list");
            }
        }
    }
}
