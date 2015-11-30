//public class Solution {
//    public int maxSubArray(int[] nums) {
//    	if(nums.length == 0 || nums == null){
//    		return 0;
//    	}
//    	
//    	int ret = Integer.MIN_VALUE;
//    	
//    	int sum = 0;
//    	
//    	for(int i = 0; i < nums.length; i++){
//    		if(sum < 0){
//    			sum = 0;
//    		}
//    		
//    		sum += nums[i];
//			ret = Math.max(sum, ret);
//    	}
//        
//    	return ret;
//    }
//}

public class Solution {
	private int findMaxSubArray(int[] nums,int left, int right){
		if(left == right){
			return nums[left];
		}
		
		int middle = (left + right) / 2;
		int maxleft = findMaxSubArray(nums, left, middle);
		int maxright = findMaxSubArray(nums, middle + 1, right);
		
		int leftSum = Integer.MIN_VALUE;
		int rightSum = Integer.MIN_VALUE;
	
		int sumTmp = 0;
		for(int i = middle; i >= left; i--){
			sumTmp += nums[i];
			
			leftSum = Math.max(leftSum, sumTmp);
		}
		
		sumTmp = 0;
		for(int i = middle + 1; i <= right; i++){
			sumTmp += nums[i];
			
			rightSum = Math.max(rightSum, sumTmp);
		}
		
		int maxAll = leftSum + rightSum;
		
		return Math.max(maxleft, Math.max(maxright, maxAll));
		
	}
	
    public int maxSubArray(int[] nums) {
    	
    	return findMaxSubArray(nums, 0, nums.length - 1);
    	
    }
}