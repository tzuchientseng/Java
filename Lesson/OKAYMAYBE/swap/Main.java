//Launch single-file
public class Main{
	public static void main(String[] args){
		{
			var a = 10;
			var b = 20;	
			
			var temp = a;
			a = b;
			b = temp;
			System.out.println(a);
			System.out.println(b);
		}	
		{
			var obj = new Swap(10,20);
			System.out.println(obj.GetX());
			System.out.println(obj.GetY());
			System.out.println("Location = "+ obj);
		}
		
	}
}

class Swap{
	private int x;
	private int y;


	//Constructor
	public Swap(int i, int j){
		this.x = i;
		this.y = j;
	}

	public int GetX(){
		return this.y;
	}
	public int GetY(){
		return this.x;
	}

}

