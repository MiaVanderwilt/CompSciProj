import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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
			//TODO: account for input of 2 integers --- GCD
			if (scanner.hasNextInt()) {
				int input = scanner.nextInt();
				if (input >= MIN_VALUE && input <= MAX_VALUE){
					ArrayList<Integer> factors = factor(input);
					System.out.println(factors.toString() + "\n");
					if (scanner.hasNextInt()) {
						greatestDenom(factors, scanner.nextInt());
					}
				} else {
					System.out.println("Error: Integer must be between " + MIN_VALUE + " and " + MAX_VALUE + ".\n");
				}
				//TODO:Account for second int
			} else {
				if (scanner.next().equalsIgnoreCase("quit"))
					run = false;
				else 
					System.out.println("Error: Input must be of type integer. \n");
				//error message
			}
		} while (run);
		scanner.close();
		//parse input
		//factor, quit, or error message
	}
	
	//Factor method: take int and divide
	
	public static ArrayList<Integer> factor (int input){//Made "static" so that it could be referenced in main
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for (int i = 1; i <= Math.sqrt(input); i++){
			if (input % i == 0){
				factors.add(i);
				//Accounts for square roots
				if (input / i != Math.sqrt(input))
					factors.add(input / i);
			}
		}
		//Integer[] sorted = factors.toArray(new Integer[factors.size()]);
		
		return factors;
	}
	
	private static int[] sortArrList (ArrayList<Integer> arrList) {
		//TODO: Decide if/where to sort output array 
		int index = 0;
		int[] sorted = new int[arrList.size()]; 
		for (int i : arrList) {
			sorted[index] = i;
			index++;
		}
		Arrays.sort(sorted);
		return sorted;
	}
	
	public static int greatestDenom (ArrayList<Integer> factA, int inputB){
		ArrayList<Integer> factB = factor(inputB);
		boolean alterA = factA.retainAll(factB);//removes all factors in A not contained in B
		int[] commonFacs = sortArrList(factA);
		System.out.println("All CDs: " + Arrays.toString(commonFacs));//ERASE
		System.out.println ("GCD: " +commonFacs[commonFacs.length - 1]);//ERASE
		return commonFacs[commonFacs.length - 1];
	} 
}
