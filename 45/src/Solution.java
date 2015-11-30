public class Solution {
    public int jump(int[] nums) {
    	if(nums == null || nums.length <= 1){
    		return 0;
    	}
    	
    	int current = 0;
    	int max = 0;
    	int counter = 0;
    	
    	for(int i = 0; i < nums.length; i++){
    		if(i > current ){
    			counter++;
    			current = max;
    		}
    		
    		max = max > i + nums[i] ? max : nums[i] + i;
    	}
    	
    	return counter;
    }
}