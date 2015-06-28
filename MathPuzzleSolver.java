/**
 * @author Andreas Loizou
 * Date: 22 June 2015
 * Purpose: This program solves the problem shown below
 * Please note that this was written in a few minutes just to quickly solve the given problem.
 * It is *not optimised* and it can *not* be used as a showcase for the way I code.
 * The problem was presented here: http://city.sigmalive.com/article/11067/mathimatiko-pazl-poy-ehei-trelanei-goneis-kai-paidia
 */

/*
 * By using digits from 1 to 9, fill in the blank squares in a way that the result is 66
 __________           __________ __________ __________           __________           
|          |         |          |          |          |          |         |           
|          |         |          |          |          |          |         |           
|          |         |          |     -    |          |          |    66   |           
|          |         |          |          |          |          |         |           
|__________|         |_________ |__________|__________|          |_________|           
|          |         |          |          |          |          |         |           
|          |         |          |          |          |          |         |           
|     +    |         |    *     |          |    -     |          |    =    |           
|          |         |          |          |          |          |         |           
|          |         |          |          |          |          |         |           
|__________|         |__________|          |__________|          |_________|           
|          |         |          |          |          |          |         |           
|    13    |         |    12    |          |    11    |          |    10   |           
|          |         |          |          |          |          |         |           
|          |         |          |          |          |          |         |           
|__________|         |__________|          |__________|          |_________|           
|          |         |          |          |          |          |         |           
|    *     |         |    +     |          |     +    |          |    -    |           
|          |         |          |          |          |          |         |           
|          |         |          |          |          |          |         |           
|__________|         |__________|          |__________|          |_________|           
|          |         |          |          |          |          |         |           
|          |         |          |          |          |          |         |           
|          |         |          |          |          |          |         |           
|          |         |          |          |          |          |         |           
|          |         |          |          |          |          |         |           
|__________|_________|__________|          |__________|__________|_________|           
|          |         |          |          |          |          |         |           
|    /     |         |    +     |          |          |          |         |           
|          |         |          |          |     *    |          |    /    |           
|          |         |          |          |          |          |         |           
|__________|_________|__________|          |__________|__________|_________| 

*
*/

public class MathPuzzleSolver {

	/*Returns true, if all the numbers we used to solve the problem are different*/
	public static boolean allDifferent(int[] x) {
		for (int i = 0; i < x.length - 1; i++) {
			for (int j = i + 1; j < x.length; j++) {
				if (x[i] == x[j]) {
					return false;
				}
			}
		}
		return true;
	}

	/*Returns true if the numbers filled in result in the correct solution*/
	public static boolean isItTrue(int[] x) {
		return (x[0] + 13 * ((double) x[1]) / ((double) x[2]) + x[3] + 12 * x[4] - x[5] + x[6] * ((double) x[7]) / ((double) x[8])) == 87;
	}
	/*recursive function which tries to solve the problem by filling one digit at a time*/
	public static boolean solve(int[] x, int position, int start_value) throws Exception {
		if (position == 9) { //If this is the last digit see if we have a solution
			boolean solutionFound = isItTrue(x) && allDifferent(x);
			//A solution is found
			if (solutionFound) {
				throw new Exception("Solution Found");
			}
			return solutionFound;
		}
		//If we are not in the end, fill in a value. 
		//If the value results in a solution everything is fine.
		//If not, the next number in sequence is used.
		for (int i = start_value; i <= 9; i++) {
			x[position] = i;
			solve(x, position + 1, 1);
		}
		//If no solution is found return false
		return false;
	}

	//Print the solution
	public static void print(int[] x) {
		System.out.println(x[0] + " +13*" + x[1] + "/" + x[2] + "+" + x[3] + "+12*" + x[4] + "-" + x[5] + "+" + x[6] + "*" + x[7] + "/" + x[8] + "==87");
	}

	//Solve the problem
	public static void main(String[] args) {
		//Initialise the array of the values we have to find
		int[] x = new int[9]; 
		for (int i = 0; i < 9; i++) {
			x[i] = 10;
		}
		//Run MathPuzzleSolver. Begin from the first missing value (position 0 at x) 
		//and start from giving that cell the value 1
		try {
			MathPuzzleSolver.solve(x, 0, 1);
		} catch (Exception e) {
			MathPuzzleSolver.print(x); //A solution has been found
		} finally {

		}
	}
}
