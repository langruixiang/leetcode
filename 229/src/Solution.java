import java.util.ArrayList;
import java.util.List;

public class Solution {
	private List<Integer> ret = new ArrayList<Integer>();
	
    public List<Integer> majorityElement(int[] nums) {
    	if(nums == null || nums.length == 0){
    		return ret;
    	}
    	
    	if(nums.length == 1){
    		ret.add(nums[0]);
    		return ret;
    	}
    	
    	int c1 = 0;
    	int counter1 = 0;
    	int c2 = 0;
    	int counter2 = 0;
    	
    	for(int i = 0; i < nums.length; i++){
    		if(nums[i] == c1){
    			counter1++;
    		}else if(nums[i] == c2){
    			counter2++;
    		}else if(counter1 == 0){
    			c1 = nums[i];
    			counter1++;
    		}else if(counter2 == 0){
    			c2 = nums[i];
    			counter2++;
    		}else{
    			counter1--;
    			counter2--;
    		}
    	}
    	
    	counter1 = 0;
    	counter2 = 0;
    	
    	for(int i = 0; i < nums.length; i++){
    		if(nums[i] == c1){
    			counter1++;
    		}else if(nums[i] == c2){
    			counter2++;
    		}    		
    	}
        
    	if(counter1 > nums.length / 3){
    		ret.add(c1);
    	}
    	
    	if(counter2 > nums.length / 3){
    		ret.add(c2);
    	}
    	
    	return ret;    	
    }
}