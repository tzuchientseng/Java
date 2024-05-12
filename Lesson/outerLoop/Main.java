public class Main {
	public static void main(String[] args){ 
		outerLoop: for (int i = 1; i <= 3; i++) {
		innerLoop: for (int j = 1; j <= 3; j++) { 
			if (i == 2 && j == 2) {
				continue outerLoop;
				}
			if (i == 3 && j == 1) { 
				break innerLoop;
				}

			System.out.println("outer:" + i + ", inner:" + j);
			}
		}
	}
}