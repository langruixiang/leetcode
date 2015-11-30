import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public List<List<Integer>> ret = new ArrayList<List<Integer>>();
	
	private void twoSum(int[] nums, int begin, int target, int num1, int num2){
		int left = begin;
		int right = nums.length - 1;
		while(left < right){
			if(nums[left] + nums[right] < target){
				left++;
			}else if(nums[left] + nums[right] > target){
				right--;
			}else{
				List<Integer> retTmp = new ArrayList<Integer>();
				retTmp.add(num1);
				retTmp.add(num2);
				retTmp.add(nums[left]);
				retTmp.add(nums[right]);
				
				ret.add(retTmp);
				
				left++;
				right--;
				while(left < right && nums[left] == nums[left - 1]){
					left++;
				}
			}
		}
	}
	
    private void threeSum(int[] nums, int begin, int target, int num1){
    	
    	for(int i = begin; i < nums.length; i++){
    		if(i > begin && nums[i] == nums[i - 1]){
    			continue;
    		}
    		
    		twoSum(nums,i + 1, target - nums[i], num1, nums[i]);
    	}
    	
    }
	
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length < 4){
        	return ret;
        }
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++){
        	if(i > 0 && nums[i] == nums[i - 1]){
        		continue;
        	} 	
        	
        	threeSum(nums,i + 1, target - nums[i], nums[i]);
        }
        
        return ret;
    }
}