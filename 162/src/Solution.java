public class Solution {
	private int peak(int[] nums,int left,int right){
		if(left == right){
			return left;
		}
		
		if(right - left == 1){
			return nums[left] > nums[right] ? left : right;
		}
		
		int mid = (left + right) / 2;
		
		if(nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]){
			return mid;
		}else if(nums[mid] < nums[mid + 1]){
			return peak(nums, mid + 1, right);
		}else{
			return peak(nums, left, mid - 1);
		}		
	}
	
    public int findPeakElement(int[] nums) {
    	if(nums == null || nums.length == 0){
    		return 0;
    	}
        
    	return peak(nums, 0, nums.length - 1);
    }
}