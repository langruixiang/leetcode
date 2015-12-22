public class Solution {
	private class Bucket{
		int size;
		int min;
		int max;
		
		public void add(int num){
			if(size == 0){
				min = num;
				max = num;
			}else{
				min = min < num ? min : num;
				max = max > num ? max : num;
			}
			size++;
		}
	}
	
    public int maximumGap(int[] nums) {
    	if(nums == null || nums.length < 2){
    		return 0;
    	}
    	
    	int min = nums[0];
    	int max = nums[0];
    	
    	for(int i = 1; i < nums.length; i++){
    		min = nums[i] < min ? nums[i] : min;
    		max = nums[i] > max ? nums[i] : max;
    	}
    	
    	int len = (int)Math.ceil(((double)(max - min)) / (nums.length - 1));
    	len = len < 1 ? 1 : len;
    	
    	Bucket[] bucket = new Bucket[nums.length];
    	for(int i = 0; i < nums.length; i++){
    		bucket[i] = new Bucket();
    	}
    	
    	for(int i = 0; i < nums.length; i++){
    		bucket[(nums[i] - min) / len].add(nums[i]);
    	}
    	
    	int preMax = bucket[0].max;
    	int ret = 0;
    	for(int i = 1; i < nums.length; i++){
    		if(bucket[i].size != 0){
    			ret = ret > bucket[i].min - preMax ? ret : bucket[i].min - preMax;
    			preMax = bucket[i].max;
    		}
    	}
        
    	return ret;
    }
}