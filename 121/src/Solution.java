public class Solution {
    public int maxProfit(int[] prices) {
    	if(prices == null || prices.length == 0){
    		return 0;
    	}
    	
    	int min = prices[0];
    	int maxProfit = 0;
    	
    	for(int i = 1; i < prices.length; i++){
    		min = min < prices[i] ? min : prices[i];
    		
    		maxProfit = prices[i] - min > maxProfit ? prices[i] - min : maxProfit;
    	}
    	
    	return maxProfit;        
    }
}