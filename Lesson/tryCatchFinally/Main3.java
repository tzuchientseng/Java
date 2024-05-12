import java.io.*;

public class Main3{
	public static void main(String[] args){
		try{
			readFile(false);
			validateAge(-1);
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	public static void readFile(boolean b) throws FileNotFoundException,  IOException {
			if(!b){
				throw new IOException();
			}
	}
	public static void validateAge(int age){
		if(age<0){
			throw new IllegalArgumentException("Age cannot be negative");
		}

	}
}
