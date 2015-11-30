
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public List<Integer> twoSum(int[] nums,int begin,int sum){
		int left = begin;
		int right = nums.length - 1;
		
		
		return null;
	}
	
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	
    	Arrays.sort(nums);
    	for(int i = 0; i < nums.length; i++){
    		if(i > 0 && nums[i] == nums[i - 1]){
    			continue;
    		}
    		
    		int sum = - nums[i];
    		
    		int left = i + 1;
    		int right = nums.length - 1;
    		
    		while(left < right){
    			if(nums[left] + nums[right] < sum){
    				left++;
    			}else if(nums[left] + nums[right] > sum){
    				right--;
    			}else{
    				List<Integer> rettmp = new ArrayList<Integer>();
    				rettmp.add(-sum);
    				rettmp.add(nums[left]);
    				rettmp.add(nums[right]);
    				
                    ret.add(rettmp);
                    
                    left++;
                    while(left < nums.length && nums[left] == nums[left - 1]){
                    	left++;
                    }
                    right--;
    			}
    		}
    		
    	}
        
    	return ret;
    }
}