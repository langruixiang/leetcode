public class Solution {
    public int rob(int[] nums) {
    	if(nums == null || nums.length == 0){
    		return 0;
    	}
    	
    	if(nums.length == 1){
    		return nums[0];
    	}
    	
    	if(nums.length == 2){
    		return Integer.max(nums[0], nums[1]);
    	}
    	
    	int[] robbed = new int[nums.length];
    	int[] unrobbed = new int[nums.length];
    	
    	robbed[0] = nums[0];
    	
    	unrobbed[1] = nums[0];
    	
    	robbed[2] = nums[0] + nums[2];
    	unrobbed[2] = nums[0];
    	
    	for(int i = 3; i < nums.length; i++){
    		robbed[i] = unrobbed[i - 1] + nums[i];
    		unrobbed[i] = Integer.max(robbed[i - 1], unrobbed[i - 1]);
    	}
    	
    	int max1 = unrobbed[nums.length - 1];
    	
    	robbed[0] = 0;
    	
    	robbed[1] = nums[1];
    	unrobbed[1] = 0;
    	
    	for(int i = 2; i < nums.length; i++){
    		robbed[i] = unrobbed[i - 1] + nums[i];
    		unrobbed[i] = Integer.max(robbed[i - 1], unrobbed[i - 1]);
    	}
    	
    	int max2 = Integer.max(robbed[nums.length - 1], unrobbed[nums.length - 1]);
    	
    	return Integer.max(max1, max2);        
    }
}