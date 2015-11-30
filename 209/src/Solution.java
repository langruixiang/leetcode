public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
    	if(nums == null || nums.length == 0){
    		return 0;
    	}
    	
    	boolean flg = false;
    	
    	int len = Integer.MAX_VALUE;
    	
    	int left = 0;
    	int right = 0;
    	
    	int sum = 0;
    	
    	while(right < nums.length){
    		sum += nums[right];
    		while(sum >= s){
    			if(right - left + 1 < len){
    				len = right - left +1;
    				flg = true;
    			}
    			
    			sum -= nums[left];
    			left++;    			
    		}
    		right++;
    	}
        
    	if(flg == false){
    		return 0;
    	}
    	
    	return len;
    }
}