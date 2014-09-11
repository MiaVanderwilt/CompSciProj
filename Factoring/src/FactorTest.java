import java.util.ArrayList;
import static java.util.Arrays.asList;

import org.junit.Assert;
import org.junit.Test;

//Test of Assignment One

public class FactorTest {
	
	public ArrayList<Integer> factors;
	
	@Test
	public void testInput(){
		//test double, int, int outside params, "quit" case-insensitive
		//test second input scenarios (see above)
	}
	
	@Test
	public void testFactorSize(){
		factors = Factor.factor(100);
		Assert.assertEquals("Correct size of array", 9, factors.size());
		
		//Assert.assertEquals("Greatest Common Denominator", actual)
	}
	
	@Test
	public void testFactorContents(){
		List<Integer> testCase = asList(1, 100, 2, 50, 4, 25, 5, 20);
		factors.containsAll(list);
	}
	
	@Test
	public void testGCD(){
		//ArrayList<Integer> factors = 
	}
}

/* test: input, list size, list content, two int input
 * 
 * parse first input
 * parse second
 * then act
 * 
 * 
 * 
 */
