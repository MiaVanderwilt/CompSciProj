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
			
			//TODO: a parsing method with scanner passed to it that returns a boolean for (in)valid input
			
			if (scanner.hasNextInt()) {
				int input = scanner.nextInt();
				if (input >= MIN_VALUE && input <= MAX_VALUE){
					ArrayList<Integer> factors = factor(input);
					int [] sorted = sortArrList(factors);
					System.out.println(Arrays.toString(sorted) + "\n");//TODO: not required
					//Accounts for second input
					if (scanner.hasNextInt()) {
						int inputTwo = scanner.nextInt();
						int gCD = greatestDenom(factors, inputTwo);
						System.out.println ("Greatest Common Denominator: " + gCD + "\n");
					}
				} else {
					System.out.println("Error: Integer must be between " + MIN_VALUE + " and " + MAX_VALUE + ".\n");
				}
			} else {
				if (scanner.next().equalsIgnoreCase("quit"))
					run = false; //Stops running program
				else 
					System.out.println("Error: Input must be of type integer. \n");
				//error message
			}
		} while (run);
		scanner.close();
		//parse input
		//factor, quit, or error message
		
		
		
		/* Attempting to rewrite main method so that FactorTest may thoroughly test the functionality:
		
		do {
		 	System.out.println("Input integer between " + MIN_VALUE + "-" + MAX_VALUE + ": ");
		 	
		 	if (scanner.hasNext()){ //If there is ANY input
		 		if (parse(scanner.next()){//If the input is an INT
		 			
		 */
	}
	
	
	/*Different Parsing Method!!!!
	 * 
	
	//Parses a line of input; returns true if the input is valid
	public static boolean parseInput (String in) {
		try { //All integers
			int input = Integer.parseInt(in);
			if (input < MIN_VALUE && input > MAX_VALUE){
				System.out.println("Error: Integer must be between " + MIN_VALUE + " and " + MAX_VALUE + ".\n");
				return false;
			}
			return true;
		} catch (NumberFormatException e) {
			System.out.println("Error: Input must be of type integer. \n");
			return false;
		}
		
	} */
	
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
		//System.out.println("All CDs: " + Arrays.toString(commonFacs));
		return commonFacs[commonFacs.length - 1];
	} 
}
