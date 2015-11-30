public class Solution {
    public int firstMissingPositive(int[] nums) {
    	int i = 0;
    	while(i < nums.length){
    		if(nums[i] > 0 && nums[i] - 1 < nums.length && nums[nums[i] - 1] != nums[i]){
    			int temp = nums[nums[i] - 1];
    			nums[nums[i] - 1] = nums[i];
    			nums[i] = temp;
    		}else{
    			i++;
    		}
    	}
    	
    	for(i = 0; i < nums.length; i++){
    		if(nums[i] != i + 1){
    			return i + 1;
    		}
    	}
        
    	return nums.length + 1;
    }
}