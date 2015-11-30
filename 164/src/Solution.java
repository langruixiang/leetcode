public class Solution {
    public int maximumGap(int[] nums) {
    	if(nums == null || nums.length < 2){
    		return 0;
    	}
    	
    	boolean []flag = new boolean[Integer.MAX_VALUE];
    	boolean hasZero = false;
    	
    	for(int i = 0; i < nums.length; i++){
    		if(nums[i] != 0){
    			flag[nums[i] - 1] = true;
    		}else{
    			hasZero = true;
    		}
    	}
    	
    	int indexPre = -1;
    	int i = 0;
    	if(!hasZero){
        	while(flag[i] == false){
        		i++;
        	}
        	
        	indexPre = i;
        	i++;    		
    	}
    	
    	int ret = Integer.MIN_VALUE;
    	
    	while(i < flag.length){
    		if(flag[i] == true){
    			ret = i - indexPre > ret ? i - indexPre : ret;
    			indexPre = i;
    		}
    		
    		i++;
    	}
        
    	return ret;
    }
}