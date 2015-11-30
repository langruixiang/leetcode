import java.util.Arrays;

public class Solution {
	
	private boolean twoSum(int[] nums,int begin,int target){
		int  left = begin;
		int right = nums.length - 1;
		while(left < right){
			if(nums[left] + nums[right] < target){
				left++;
			}else if(nums[left] + nums[right] > target){
				right--;
			}else{
				return true;
			}
		}
		return false;
	}
	
	private boolean threeSum(int[] nums, int target){

		if(nums.length < 3){
			return false;
		}
		
		for(int i = 0; i < nums.length; i++){			
			if(twoSum(nums, i + 1, target - nums[i]) == true){
				return true;
			}
		}
		
		return false;
	}
	
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3){
        	return 0;
        }
        
        Arrays.sort(nums);
        
        int delta = 0;
        
        while(true){        	
        	
        	if(threeSum(nums, target + delta)){
        		return target + delta;
        	}
        	
        	if(threeSum(nums, target - delta)){
        		return target - delta;
        	}
        	
        	delta++;
        }
    }
}