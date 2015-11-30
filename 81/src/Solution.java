public class Solution {
	private boolean binarySearch(int[]nums,int target,int left,int right){
		if(right < left){
			return false;
		}
		
		int middle = (left + right) / 2;
		if(nums[middle] == target){
			return true;
		}
		
		if(nums[left] < nums[right]){
			if(nums[middle] < target){
				return binarySearch(nums, target, middle + 1, right);
			}else{
				return binarySearch(nums, target, left, middle - 1);
			}
		}else{
			if(nums[middle] > nums[left]){
				if(target >= nums[left] && target < nums[middle]){
					return binarySearch(nums, target, left, middle - 1);
				}else if(target > nums[middle] || target < nums[left]){
					return binarySearch(nums, target, middle + 1, right);
				}
			}else if(nums[middle] < nums[left]){
				if(target > nums[middle] && target <= nums[right]){
					return binarySearch(nums, target, middle + 1, right);
				}else if(target < nums[middle] || target > nums[right]){
					return binarySearch(nums, target, left, middle - 1);
				}
			}else{
				if(nums[left] == target || nums[right] == target){
					return true;
				}else{
					return binarySearch(nums, target, left + 1, right - 1);
				}
			}
		}
		
		return false;
	}
	
    public boolean search(int[] nums, int target) {
    	if(nums == null || nums.length == 0){
    		return false;
    	}
        return binarySearch(nums, target, 0, nums.length - 1);
    }
}