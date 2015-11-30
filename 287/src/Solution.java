//public class Solution {
//	private int findHelper(int[] nums,int left,int right){
//		if(left == right){
//			return left;
//		}
//		
//		int mid = left + (right - left) / 2;
//		int counter = 0;
//		
//		for(int i = 0; i < nums.length; i++){
//			if(nums[i] <= mid){
//				counter++;
//			}
//		}
//		
//		if(counter > mid){
//			return findHelper(nums, left, mid);
//		}else{
//			return findHelper(nums, mid + 1, right);
//		}
//		
//	}
//	
//    public int findDuplicate(int[] nums) {
//    	return findHelper(nums, 1, nums.length - 1);
//    }
//}
public class Solution {
    public int findDuplicate(int[] nums) {
    	int fast = 0;
    	int slow = 0;
    	
    	fast = nums[nums[fast]];
    	slow = nums[slow];
    	
    	while(fast != slow){
    		fast = nums[nums[fast]];
    		slow = nums[slow];
    	}
    	
    	fast = 0;
    	while(fast != slow){
    		fast = nums[fast];
    		slow = nums[slow];
    	}
    	
    	return fast;
        
    }
}