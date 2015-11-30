public class Solution {
    public int findKthLargest(int[] nums, int k) {
    	int L = 0;
    	int R = nums.length - 1;
    	
    	while(L < R){
    		int left = L;
        	int right = R;
        	
        	int povit = nums[left];
        	while(left < right){
        		while(left < right && nums[right] <= povit){
        			right--;
        		}        		
        		nums[left] = nums[right];
        		
        		while(left < right && nums[left] > povit){
        			left++;
        		}
        		nums[right] = nums[left];
        	}
        	
        	nums[left] = povit;
        	
        	if(left == k - 1){
        		return nums[left];
        	}else if(left > k - 1){
        		R = left - 1;
        	}else{
        		L = left + 1;
        	}
    	}
    	
    	return nums[L];
        
    }
}