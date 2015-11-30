public class Solution {
	private void swap(int[] nums,int i,int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
    public void sortColors(int[] nums) {
    	if(nums == null || nums.length <= 1){
    		return ;
    	}
    	
    	int leftIndex = 0;
    	int rightIndex = nums.length - 1;
    	
    	int i = 0;
    	
    	while(i <= rightIndex){
    		if(nums[i] == 0 && i != leftIndex){
    			swap(nums, i, leftIndex);
    			leftIndex++;
    		}else if(nums[i] == 2 && i != rightIndex){
    			swap(nums, i, rightIndex);
    			rightIndex--;
    		}else{
    			i++;
    		}
    		
    	}
    }
}