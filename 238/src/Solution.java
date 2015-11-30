public class Solution {
    public int[] productExceptSelf(int[] nums) {
    	int[] ret = new int[nums.length];
    	
    	ret[0] = 1;
    	
    	int tmp = 1;
    	for(int i = 0; i < nums.length - 1; i++){
    		tmp *= nums[i];
    		ret[i + 1] = tmp;
    	}
    	
    	tmp = 1;
    	for(int i = nums.length - 1; i > 0; i--){
    		tmp *= nums[i];
    		ret[i - 1] *= tmp;
    	}
    	
    	return ret;        
    }
}