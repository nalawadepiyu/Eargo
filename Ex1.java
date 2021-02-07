import java.util.*;

public class Ex1 {
	/*
	 * The function will return list, vector or collection of numbers representing
	 * the number of quarters(25), dimes(10), nickels (5), pennies (1) that would
	 * yield the correct change.
	 * 
	 * Time Complexity = O(totalAmount * n) where n iterations 
	 * Space Complexity = O(totalAmount)
	 */

	/*
	 * It is bottom up approach - compute all min counts for amount upto i Every i
	 * iteration , F[i] = min (j = 0 to n-1) F(i - coin[j] ) + 1
	 */
	public static Map<Integer, Integer> minimumCoinRequired(int totalCents, int coins[]) {
		Map<Integer, Integer> coinToCounts = new HashMap<>();

		if (totalCents <= 0 || coins.length <= 0)
			return coinToCounts;

		// set default count to 0
		coinToCounts.put(25, 0);
		coinToCounts.put(10, 0);
		coinToCounts.put(5, 0);
		coinToCounts.put(1, 0);

		int total[] = new int[totalCents + 1];
		int coinsUsed[] = new int[totalCents + 1];
		total[0] = 0;

		// set default values to -1
		for (int i = 1; i <= totalCents; i++) {
			total[i] = Integer.MAX_VALUE - 1;
			coinsUsed[i] = -1;
		}

		for (int j = 0; j < coins.length; j++) {
			for (int i = 1; i <= totalCents; i++) {
				if (i >= coins[j]) {
					if (total[i - coins[j]] + 1 < total[i]) {
						total[i] = 1 + total[i - coins[j]];
						// store all coins used to make total
						coinsUsed[i] = j;
					}
				}
			}
		}

		// get counts of each type coins from coinsUsed array and store it map(coin,
		// counts)
		if (coinsUsed[coinsUsed.length - 1] == -1) {
			System.out.print("No solution is possible");
			return coinToCounts;
		}
		int start = coinsUsed.length - 1;
		while (start != 0) {
			int j = coinsUsed[start];
			start = start - coins[j];

			// put coin => key and val => count of coins used to make totalCents
			if (coinToCounts.containsKey(coins[j])) {
				int val = coinToCounts.get(coins[j]);
				coinToCounts.put(coins[j], val + 1);
			} else {
				coinToCounts.put(coins[j], 1);
			}
		}

		return coinToCounts;
	}

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		int totalCents = 30;
		/*
		 * Use Test Cases : Test 1 : 83 cents - For 83¢,3 quarters,0 dimes, 1 nickel,
		 * and 3 pennies.
		 * 
		 * Test 2 : 0 cents - For 0¢,0 quarters,0 dimes, 0 nickel, and 0 pennies.
		 * 
		 * Test 3 : For 100¢,4 quarters,0 dimes, 0 nickel, and 0 pennies.
		 *
		 * Test 4 : For 30¢,1 quarters,0 dimes, 1 nickel, and 0 pennies.
		 */
		// represents quarters, nickel, dime, cents values in coins array
		int coins[] = { 25, 10, 5, 1 };
		int quarterCount = 0;
		int dimeCount = 0;
		int nickelCount = 0;
		int penniesCount = 0;

		Map<Integer, Integer> result = minimumCoinRequired(totalCents, coins);

		if (result == null)
			System.out.print("No combination possible !");
		else {

			for (Map.Entry<Integer, Integer> entry : result.entrySet()) {

				if (entry.getKey() == 25) {
					quarterCount = entry.getValue();
				} else if (entry.getKey() == 10) {
					dimeCount = entry.getValue();
				} else if (entry.getKey() == 5) {
					nickelCount = entry.getValue();
				} else if (entry.getKey() == 1) {
					penniesCount = entry.getValue();
				}
			}

			sb.append("For " + totalCents + "¢," + quarterCount + " quarters," + dimeCount + " dimes, " + nickelCount
					+ " nickel, and " + penniesCount + " pennies.");

		}

		System.out.println(sb.toString());
	}

}
