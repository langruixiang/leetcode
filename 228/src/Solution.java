import java.util.ArrayList;
import java.util.List;

public class Solution {
	private List<String> ret = new ArrayList<>();
	
    public List<String> summaryRanges(int[] nums) {
    	if(nums == null || nums.length == 0){
    		return ret;
    	}
    	
    	int begin = nums[0];
    	int end = nums[0];
    	
    	int i = 1;
    	while(i < nums.length){
    		if(nums[i] - nums[i - 1] == 1){
    			end++;
    		}else{
    			if(begin == end){
    				ret.add("" + begin);
    			}else{
    				ret.add("" + begin + "->" + end);
    			}
    			
    			begin = nums[i];
    			end = nums[i];
    		}
    		
    		i++;
    	}
    	
    	if(begin == end){
			ret.add("" + begin);
		}else{
			ret.add("" + begin + "->" + end);
		}
    	
    	return ret;
        
    }
}