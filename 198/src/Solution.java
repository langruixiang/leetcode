public class Solution {
    public int rob(int[] nums) {
    	if(nums == null || nums.length == 0){
    		return 0;
    	}
    	
    	int[] robbed = new int[nums.length];
    	int[] unrobbed = new int[nums.length];
    	
    	robbed[0] = nums[0];
    	unrobbed[0] = 0;
    	
    	for(int i = 1; i < nums.length; i++){
    		robbed[i] = unrobbed[i - 1] + nums[i];
    		unrobbed[i] = Integer.max(robbed[i - 1], unrobbed[i - 1]);
    	}
    	
    	return robbed[nums.length - 1] > unrobbed[nums.length - 1] ? robbed[nums.length - 1] : unrobbed[nums.length - 1];
        
    }
}