public class Solution {
	private int binarySearch(int[] nums,int target, int left, int right){
		if(right < left){
			return -1;
		}
		
		int middle = (left + right) / 2;
		
		if(nums[middle] == target){
			return middle;
		}
		
		if(nums[middle] > nums[right]){
			if(nums[middle] < target || target < nums[left]){
				return binarySearch(nums, target, middle + 1, right);
			}else{
				return binarySearch(nums, target, left, middle - 1);
			}
		}else{
			if(target < nums[middle] || target > nums[right]){
				return binarySearch(nums, target, left, middle - 1);
			}else{
				return binarySearch(nums, target, middle + 1, right);
			}
		}
		
		
		
	}
	
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
        	return -1;
        }
        
        return binarySearch(nums, target, 0, nums.length - 1);
    }
}