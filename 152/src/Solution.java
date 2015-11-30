public class Solution {
    public int maxProduct(int[] nums) {
    	if(nums == null || nums.length == 0){
    		return 0;
    	}
    	
    	int[] max = new int[nums.length];
    	int[] min = new int[nums.length];
    	
    	max[0] = nums[0];
    	min[0] = nums[0];
    	
    	for(int i = 1; i < nums.length; i++){
    		if(nums[i] > 0){
    			max[i] = max[i - 1] * nums[i] > nums[i] ? max[i - 1] * nums[i] : nums[i];
    			min[i] = min[i - 1] * nums[i] < nums[i] ? min[i - 1] * nums[i] : nums[i];
    		}else{
    			max[i] = min[i - 1] * nums[i] > nums[i] ? min[i - 1] * nums[i] : nums[i];
    			min[i] = max[i - 1] * nums[i] < nums[i] ? max[i - 1] * nums[i] : nums[i];
    		}
    	}
    	
    	int ret = max[0];
    	for(int i = 1; i < max.length; i++){
    		ret = ret > max[i] ? ret : max[i];
    	}
    	
    	return ret;    		
    } 
}