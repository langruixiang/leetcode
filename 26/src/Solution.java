public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
    	
        int index = nums.length - 1;
        int legthCounter = 0;
        
        while (index >= 0) {
        	legthCounter++;
			int delta = 1;
			while (index - delta >= 0 && nums[index - delta] == nums[index]) {
				delta++;
			}
			if(delta > 1){
				for (int i = index,j = 0; j < legthCounter; i++,j++) {
					nums[i - delta + 1] = nums[i];
				}
			}
			index = index - delta;
		}
        
        return legthCounter;
    }
}