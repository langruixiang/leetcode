public class Solution {
    public int removeElement(int[] nums, int val) {
    	if(nums == null){
    		return 0;
    	}
    	
    	int newLength = nums.length;
    	
    	int index = nums.length - 1;
    	int delta = 0;
    	
    	while(index >= 0){
    		if(nums[index] == val){
    			delta = 1;
    			while(index - delta >= 0 && nums[index - delta] == nums[index]){
    				delta++;
    			}
    			
    			for(int i = index + 1; i < newLength; i++){
        			nums[i - delta] = nums[i];
        		}
        		
        		newLength -= delta;
        		index -= delta;
    		}else{
    			index--;
    		}
    	}
        return newLength;
    }
}