
public class Solution {	
	private int findMax(int[] prices,int left,int k){
		if(k == 0 || left >= prices.length){
			return 0;
		}

		int minPrice = prices[left];
		int maxPre = 0;
		int maxAll = 0;
		for(int i = left; i < prices.length; i++){
			if(prices[i] < minPrice){
				minPrice = prices[i];
			}
			
			if(prices[i] - minPrice > maxPre){
				maxPre = prices[i] - minPrice;
			}
			
			int tmp = maxPre + findMax(prices, i + 1, k - 1);
			
			if( tmp > maxAll){
				maxAll = tmp;
			}
		}

		return maxAll;
		
	}
	
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0 || prices.length == 1 || k <= 0){
        	return 0;
        }
        
        return findMax(prices, 0, k);        
    }
}