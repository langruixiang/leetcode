public class Solution {
    public int maxProfit(int[] prices) {
    	if(prices == null || prices.length == 0){
    		return 0;
    	}
    	
    	int profit = 0;
    	int buy = prices[0];
    	
    	int sell = 0;
    	
    	int index = 1;
    	while(true){
    		while(index < prices.length && prices[index] <= buy){
    			buy = prices[index];
    			index++;
    		}
    		
    		if(index == prices.length){
    			break;
    		}
    		
    		sell = prices[index];
    		index++;
    		while(index < prices.length && prices[index] >= sell){
    			sell = prices[index];
    			index++;
    		}
    		
    		profit += (sell - buy);
    		
    		if(index == prices.length){
    			break;
    		}
    		buy = prices[index];
    		index++;
    	}
        
    	return profit;
    }
}