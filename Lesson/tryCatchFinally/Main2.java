public class Main2{
	public static void main(String[] args){
		try{
			int[] numbers = {1,2,3};
			System.out.println(numbers[7]);
		} catch(ArrayIndexOutOfBoundsException | NullPointerException ex){
			System.out.println("Catch: " + ex.getMessage());
		}
	}
}