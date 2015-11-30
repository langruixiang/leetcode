public class Solution {
	
    public boolean canJump(int[] nums) {
    	if(nums == null || nums.length == 0){
    		return false;
    	}
    	
    	int maxReach = 0;
    	for(int i = 0; i < nums.length; i++){
    		if(maxReach >= i && i + nums[i] > maxReach){
    			maxReach = i + nums[i];
    			if(maxReach >= nums.length - 1){
    				return true;
    			}
    		}else if(maxReach < i){
    			return false;
    		}
    	}
    	
    	return true;        
    }
}