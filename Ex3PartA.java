
import java.util.*;

/* Function to find out the best Buying and Selling day for maximum gain from daily stock
 * prices of the last 10 days.
 * 
 * Part A:
 *  1. Buy first
 *  2. You can only buy once and sell once
 * 
 * 	Time complexity = O(n) stock_prices length
 *   Space Complexity = O(1) min_price, maxProfit variables 
 * */

class BuySellPair {
	int buy, sell;
}

public class Ex3PartA {
	// Idea is find smallest value and largest value and find max profit
	public static List<BuySellPair> maxProfitBuyOnceSellOnce(int[] stock_prices) {
		List<BuySellPair> pairList = new ArrayList<BuySellPair>();

		int len = stock_prices.length;
		int min_price = Integer.MAX_VALUE;
		int maxProfit = 0;
		BuySellPair pair = new BuySellPair();

		if (len == 0) {
			return pairList;
		}

		for (int i = 0; i < len; i++) {
			if (stock_prices[i] < min_price) {
				min_price = stock_prices[i];
				pair.buy = i;
			} else if (stock_prices[i] - min_price > maxProfit) {
				maxProfit = stock_prices[i] - min_price;
				pair.sell = i;
			}
		}

		if (pair.buy < pair.sell)
			pairList.add(pair);
		return pairList;
	}

	public static void main(String[] args) {
		int[] stock_prices = new int[] { 100, 170, 250, 300, 30, 525, 685 };

		/*
		 * Use test cases - test 1- {1,2,3,4} buy at 0(1), sell at 3(4)
		 * 
		 * test 2 - {7,6,4,3,1} No combination for buy and sell day
		 * 
		 * test 3 - {3, 8, 8, 55, 38, 1, 7, 42, 54, 53} - buy at 5(1), sell at 8(54)
		 * 
		 * test 4 - { 100, 170, 250, 300, 30, 525, 685 } - buy at 4(30), sell at 6(685)
		 * 
		 */

		System.out.println(" **********************maxProfitBuyOnceSellOnce pairList ************************** ");
		List<BuySellPair> pairList = maxProfitBuyOnceSellOnce(stock_prices);

		if (pairList == null || pairList.isEmpty())
			System.out.println("No combination for buy and sell day");

		for (BuySellPair pair : pairList) {
			System.out.println("pair buy at " + pair.buy + "(" + stock_prices[pair.buy] + ")," + " sell at " + pair.sell
					+ "(" + stock_prices[pair.sell] + ")");
		}

	}
}
