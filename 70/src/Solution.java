public class Solution {
    public int climbStairs(int n) {
    	if(n <= 0){
    		return 0;
    	}
    	
    	if(n == 1 || n == 2){
    		return n;
    	}
    	
    	int []counter = new int[n];
    	counter[0] = 1;
    	counter[1] = 2;
    	
    	for(int i = 2; i <n; i++){
    		counter[i] = counter[i - 1] + counter[i - 2];
    	}
    	
    	return counter[n - 1];
        
    }
}