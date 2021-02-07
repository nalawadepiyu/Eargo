# Eargo

<b> Exercise 1 - </b>
The function will return list, vector or collection of numbers representing the number of quarters(25), dimes(10), nickels (5), pennies (1) that would yield the correct change.
 <br>
 Time Complexity = O(totalAmount * n) where n iterations
<br>
  Space Complexity = O(totalAmount)
   <br>
    <b> Test cases - </b>
    <br>
      Test 1 : 83 cents - For 83¢,3 quarters,0 dimes, 1 nickel, and 3 pennies.
    <br>
		  Test 2 : </b> 0 cents - For 0¢,0 quarters,0 dimes, 0 nickel, and 0 pennies.
    <br>
		 Test 3 : </b> For 100¢,4 quarters,0 dimes, 0 nickel, and 0 pennies.
    <br>
		 Test 4 : </b> For 30¢,1 quarters,0 dimes, 1 nickel, and 0 pennies.
    <br>
  <br>
  <br>
  <br>
     
<b> Exercise 2 - </b>
SQL -
<br>
 --- Idea is to get count of all non-zero records per each column and replace ‘??’ in Output_table for each pageType.
<br>

SET @homeCount = (select COUNT(NULLIF(Home_Page,0)) as Home_PAGE_COUNT from Input_table);
<br>
SET @productCount = (select COUNT(NULLIF(Product_Page,0)) as Product_PAGE_COUNT from Input_table);
<br>
SET @warrantyCount = (select COUNT(NULLIF(Warranty_Page,0)) as Warranty_PAGE_COUNT from Input_table);
<br>

Update Output_table SET counts = @homeCount where Page like '%Home_Page%';
<br>
Update Output_table SET counts = @productCount where Page like '%Product_Page%';
<br>
Update Output_table SET counts = @warrantyCount where Page like '%Warranty_Page%';
<br>


<b> Exercise 3 - </b>

Part A - 
Function to find out the best Buying and Selling day for maximum gain from daily stock prices of the last 10 days.
  1. Buy first
  2. You can only buy once and sell once
 <br>
 *  Time complexity = O(n) stock_prices length
 <br>
 *  Space Complexity = O(1) min_price, maxProfit variables used.
 <br>
 <br>
 <b> Test Cases : </b>
 <br>
  Test 1 - {1,2,3,4} buy at 0(1), sell at 3(4)
  <br>
  Test 2 - {7,6,4,3,1} No combination for buy and sell day
	<br>
  Test 3 - {3, 8, 8, 55, 38, 1, 7, 42, 54, 53} - buy at 5(1), sell at 8(54)
  <br>
  Test 4 - { 100, 170, 250, 300, 30, 525, 685 } - buy at 4(30), sell at 6(685)
	<br>
  <br>
  <br>
  <br>
  
 <b> Part B - </b> 
 <br>
 Function to find out the best Buying and Selling day for maximum gain from daily stock prices of the last 10 days. <br>
	  1. You buy first and then sell 
    <br>
    2. Buy and sell as many times as possible. Goal is to maximize profit.
	 <br>
   <br>
    * 	Time complexity = O(n) stock_prices length
   <br>
	  *  Space Complexity = O(1) min_price, maxProfit variables 
   <br>
   <br>
   <b> Test Cases : </b> <br>
    Test 1- {1,2,3,4} 
    <br>
		Buy on day =0 (1) & Sell on day =3 (4)
    <br>
    <br>
		Test 2 - {7,6,4,3,1} 
    <br>
		There is no way to buy and sell stocks to make max profit!!
    <br>
    <br>
		Test 3 - {3, 8, 8, 55, 38, 1, 7, 42, 54, 53} 
    <br>
		Buy on day =0 (3) & Sell on day =3 (55) 
    <br>
		Buy on day =5 (1) & Sell on day =8 (54)
    <br>
    <br>
		Test 4 - { 100, 170, 250, 300, 30, 525, 685 } - 
    <br>
		Buy on day =0 (100) & Sell on day =3 (300) 
    <br>
		Buy on day =4 (30) & Sell on day =6 (685)
		 
   
   
	 
     
     
		 
