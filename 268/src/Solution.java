public class Solution {
	private void swap(int[] nums,int i,int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
    public int missingNumber(int[] nums) {
    	if(nums == null || nums.length == 0){
    		return 0;
    	}
    	
    	for(int i = 0; i < nums.length;){
    		if(nums[i] == i || nums[i] >= nums.length || nums[nums[i]] == nums[i]){
    			i++;
    		}else{
    			swap(nums,nums[i],i);
    		}
    	}
    	
    	for(int i = 0; i < nums.length; i++){
    		if(i != nums[i]){
    			return i;
    		}
    	}
        
    	return nums.length;
    }
}