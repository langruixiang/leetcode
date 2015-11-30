public class Solution {
    public int[] singleNumber(int[] nums) {
    	if(nums == null || nums.length == 0){
    		return new int[0];
    	}
    	
    	int num1 = 0;
    	int num2 = 0;
    	
    	for(int i = 0; i < nums.length; i++){
    		num1 = num1 ^ nums[i];
    	}
    	
    	int index = 0;
    	for(int i = 0; i < 32; i++){
    		if(((num1 >> i) & 1) == 1){
    			index = i;
    			break;
    		}
    	}
    	
    	num1 = 0;
    	num2 = 0;
    	for(int i = 0; i < nums.length; i++){
    		if(((nums[i] >> index) & 1) == 1){
    			num1 = num1 ^ nums[i];
    		}else{
    			num2 = num2 ^ nums[i];
    		}
    	}
    	
    	int[] ret = new int[2];
    	ret[0] = num1;
    	ret[1] = num2;
    	
    	return ret;
        
    }
}