public class Solution {
	private int min(int[] nums,int left,int right){
		if(left == right){
			return nums[left];
		}
		
		if(right - left == 1){
			return nums[left] < nums[right] ? nums[left] : nums[right];
		}
		
		int mid = (left + right) / 2;
		
		if(nums[left] < nums[mid]){
			if(left == 0 && nums[left] < nums[right]){
				return nums[left];
			}else if(left > 0 && nums[left] < nums[left - 1]){
				return nums[left];
			}else{
				return min(nums, mid + 1, right);
			}
		}else{
			if(mid == 0 && nums[mid] < nums[right]){
				return nums[mid];
			}else if(mid > 0 && nums[mid] < nums[mid - 1]){
				return nums[mid];
			}else{
				return min(nums, left, mid - 1);
			}
		}
	}
	
    public int findMin(int[] nums) {
    	if(nums == null || nums.length == 0){
    		return 0;
    	}
    	
    	return min(nums, 0, nums.length - 1);
        
    }
}