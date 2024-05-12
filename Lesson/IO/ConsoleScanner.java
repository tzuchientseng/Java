package IO;
import java.io.*;
import java.util.*;

public class ConsoleScanner {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        while(true){
            String str = s.next();
            System.out.println("Input: " + str);
            if("exit".equalsIgnoreCase(str)){
                break;
            }
        }
        s.close();
    }
}
