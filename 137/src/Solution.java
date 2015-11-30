public class Solution {
    public int singleNumber(int[] nums) {
    	int bitCounter[] = new int[32];
    	int res = 0;
    	
    	for(int i = 0; i < 32; i++){
    		for(int j = 0; j < nums.length; j++){
    			bitCounter[i] += (nums[j] >> i) & 1;
    		}
    		
    		if(bitCounter[i] % 3 != 0){
    			res |= (1 << i);
    		}
    	}
        
    	return res;
    }
}