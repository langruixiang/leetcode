import java.util.Arrays;

public class Solution {
	
    public int coinChange(int[] coins, int amount) {
    	if(coins == null || coins.length == 0 || amount < 0){
    		return -1;
    	}
    	
    	Arrays.sort(coins);
    	
    	int[] arr = new int[amount + 1];
    	arr[0] = 0;
    	for(int i = 1; i <= amount; i++){
    		int min = Integer.MAX_VALUE;
    		for(int j = 0; j < coins.length; j++){
    			if(coins[j] <= i){
    				if(arr[i - coins[j]] != -1){
    					min = Math.min(min, arr[i - coins[j]] + 1);
    				}
    			}else{
    				break;
    			}
    		}
    		
    		if(min != Integer.MAX_VALUE){
    			arr[i] = min;
    		}else{
    			arr[i] = -1;
    		}
    	}

    	
    	return arr[amount];        
    }
}