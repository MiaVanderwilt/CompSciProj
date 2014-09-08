import java.util.ArrayList;
import java.util.Scanner;

//Assignment One

public class Factor {
	
	public static final int MIN_VALUE = 1;
	public static final int MAX_VALUE = 100;
	
	public static void main (String[] args){
		
		//prompt input
		Scanner scanner = new Scanner(System.in);
		
		boolean run = true;
		
		do {
			System.out.println("Input integer between " + MIN_VALUE + "-" + MAX_VALUE + ": ");
			//TODO: account for other types of input
			if (scanner.hasNextInt()) {
				int input = scanner.nextInt();
				if (input >= MIN_VALUE && input <= MAX_VALUE){
					factor(input);
				} else {
					System.out.println("Error: Integer must be between " + MIN_VALUE + " and " + MAX_VALUE);
				}
			} else {
				if (scanner.next().equalsIgnoreCase("quit"))
					run = false;
				else 
					System.out.println("Error: Input type must be an integer \n");
				//error message
			}
		} while (run);
		//parse input
		//factor, quit, or error message
		
	}
	
	//Factor method: take int and divide
	public static void factor (int input){
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for (int i = 1; i <= Math.sqrt(input); i++){
			if (input % i == 0){
				factors.add(i);
				//Accounts for square roots
				if (input / i != Math.sqrt(input))
					factors.add(input / i);
			}
		}
		//TODO: Sort ArrayList
		//Object[] sorted = factors.toArray();
		//sorted.
		
		System.out.println(factors.toString() + "\n");
	}
}
