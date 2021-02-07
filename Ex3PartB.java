import java.util.*;

class BuySellPair {
	int buy, sell;
}

public class Ex3PartB {
	/*
	 * Function to find out the best Buying and Selling day for maximum gain from
	 * daily stock prices of the last 10 days.
	 * 
	 * Part B: 1. You buy first and then sell 2. Buy and sell as many times as
	 * possible. Goal is to maximize profit.
	 * 
	 * 	Time complexity = O(n) stock_prices length
	 *  Space Complexity = O(1) min_price, maxProfit variables 
	 *
	 * 
	 */
	static int countWaysToBuySell = 0;
	public static List<BuySellPair> maxProfitBuySellMultipleTimes(int[] stock_prices) {

		List<BuySellPair> pairList = new ArrayList<BuySellPair>();

		int len = stock_prices.length;
	
		if (len == 1)
			return pairList;

		int index = 0;
		while (index < len - 1) {
			// find minimal value first
			while ((index < len - 1) && stock_prices[index + 1] <= stock_prices[index])
				index++;

			// if reach till end of stock_prices break
			if (index == len - 1)
				break;

			BuySellPair buySellPair = new BuySellPair();
			// Store index as buy day
			buySellPair.buy = index;
			index++;

			// find maximal value now
			while ((index < len) && (stock_prices[index] >= stock_prices[index - 1]))
				index++;

			// store index as sell day
			buySellPair.sell = index - 1;
			pairList.add(buySellPair);

			// increment count
			countWaysToBuySell++;
		}
		
		return pairList;
	}

	public static void main(String[] args) {

		int[] stock_prices = new int[] { 100, 170, 250, 300, 30, 525, 685 };
		
		/*
		 * Use test cases - test 1- {1,2,3,4} 
		 * Buy on day =0 (1) & Sell on day =3 (4)
		 * 
		 * test 2 - {7,6,4,3,1} 
		 * There is no way to buy and sell stocks to make max profit!!
		 * 
		 * test 3 - {3, 8, 8, 55, 38, 1, 7, 42, 54, 53} 
		 * Buy on day =0 (3) & Sell on day =3 (55) 
		 * Buy on day =5 (1) & Sell on day =8 (54)
		 * 
		 * test 4 - { 100, 170, 250, 300, 30, 525, 685 } - 
		 * Buy on day =0 (100) & Sell on day =3 (300) 
		 * Buy on day =4 (30) & Sell on day =6 (685)
		 * 
		 */

		System.out.println(" **********************maxProfitBuySellMultipleTimes pairList ************************** ");
		List<BuySellPair> pairList = maxProfitBuySellMultipleTimes(stock_prices);
		
		if (countWaysToBuySell == 0) {
			System.out.println("There is no way to buy and sell stocks to make max profit!!");
		} else {
			for (int i = 0; i < countWaysToBuySell; i++) {
				System.out.println("Buy on day =" + pairList.get(i).buy + " (" + stock_prices[pairList.get(i).buy]
						+ ") " + "& Sell on day =" + pairList.get(i).sell + " (" + stock_prices[pairList.get(i).sell]
						+ ")");
				;
			}
		}
		
	}

}
