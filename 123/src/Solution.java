

public class Solution {
    public int maxProfit(int[] prices) {
    	if(prices == null || prices.length == 0){
    		return 0;
    	}
    	
    	int[] before = new int[prices.length];
    	int[] after = new int[prices.length];
    	
    	int lowest = prices[0];
    	for(int i = 1; i < prices.length; i++){
    		lowest = lowest < prices[i] ? lowest : prices[i];
    		before[i] = prices[i] - lowest > before[i - 1] ? prices[i] - lowest : before[i - 1];
    	}
    	
    	int ret  = 0;
    	
    	int highest = prices[prices.length - 1];
    	for(int i = prices.length - 2; i >= 0; i--){
    		highest = highest > prices[i] ? highest : prices[i];
    		after[i] = highest - prices[i] > after[i + 1] ? highest - prices[i] : after[i + 1];
    		
    		ret = ret > before[i] + after[i] ? ret : before[i] + after[i];
    	}
    	
    	
     	return ret;
    }
}