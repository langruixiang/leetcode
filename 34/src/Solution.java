public class Solution {
	private int binarySearch(int[] nums,int target,int left,int right){    	
    	
    	if(left == right ){
    		if(nums[left] == target){
    			return left;
    		}else{
    			return -1;
    		}    		
    	}
    	
    	if(left > right || right < left){
    		return -1;
    	}
    	
    	int middle = (left + right) / 2;
    	
    	if(nums[middle] == target){
    		return middle;
    	}else if(nums[middle] < target){
    		return binarySearch(nums, target,middle + 1,right);
    	}else{
    		return binarySearch(nums, target, left, middle - 1);
    	}
	}
	
    public int[] searchRange(int[] nums, int target) {
    	if(nums == null){
    		return null;
    	}
    	
    	int index = binarySearch(nums, target, 0, nums.length - 1);
    	
    	if(index == -1){
    		int []ret = {-1,-1};
    		return ret;
    	}else{
    		int []ret = new int[2];
    		ret[0] = index;
    		ret[1] = index;
    		
    		while(ret[0] - 1 >= 0 && nums[ret[0] - 1] == target){
    			ret[0]--;
    		}
    		
    		ret[0] = ret[0] < 0 ? 0 : ret[0];
    		
    		while(ret[1] + 1 <= nums.length - 1 && nums[ret[1] + 1] == target){
    			ret[1]++;
    		}
    		
    		ret[1] = ret[1] > nums.length - 1 ? nums.length - 1 : ret[1];
    		
    		return ret;
    	}    	
    }
}