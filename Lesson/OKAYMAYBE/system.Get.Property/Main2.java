import java.io.*;
import java.util.*;

public class Main2{
	public static void main(String[] args){
		Properties p = new Properties();
		try(FileInputStream f = new FileInputStream("demo.properties")){
		p.load(f);
		} catch (IOException e){

		e.printStackTrace();
		}
		System.out.println("foo value: " + p.getProperty("foo"));
	}
}