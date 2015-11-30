public class Solution {
    public int lengthOfLIS(int[] nums) {
    	if(nums == null || nums.length == 0){
    		return 0;
    	}
    	
    	if(nums.length == 1){
    		return 1;
    	}
    	
    	int[] counter = new int[nums.length];
    	counter[0] = 1;
    	
    	for(int i = 1; i < nums.length; i++){
    		int tmp = 1;
    		for(int j = 0; j < i; j++){
    			if(nums[i] > nums[j]){
    				tmp = tmp > counter[j] + 1 ? tmp : counter[j] + 1;
    			}
    		}
    		counter[i] = tmp;
    	}
    	
    	int ret = 1;
    	for(int i = 0; i < nums.length; i++){
    		ret = ret > counter[i] ? ret : counter[i];
    	}
    	
    	return ret;        
    }
}