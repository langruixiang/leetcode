import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
    	if(nums == null || nums.length == 0){
    		return 0;
    	}
    	
    	if(nums.length == 1){
    		return 1;
    	}
    	
    	int ret = Integer.MIN_VALUE;
    	Set<Integer> set = new HashSet<Integer>();
    	
    	for(int i = 0; i < nums.length; i++){
    		set.add(nums[i]);
    	}
    	
    	while(!set.isEmpty()){
    		Iterator<Integer> ite = set.iterator();
    		int number = ite.next();
    		set.remove(number);
    		
    		int length = 1;
    		
    		int tmp = number - 1;
    		while(!set.isEmpty()){    			
    			if(set.contains(tmp)){
    				length++;
    				set.remove(tmp);
    				tmp -= 1;
    			}else{
    				break;
    			}
    		}
    		
    		tmp = number + 1;
    		while(!set.isEmpty()){    			
    			if(set.contains(tmp)){
    				length++;
    				set.remove(tmp);
    				tmp += 1;
    			}else{
    				break;
    			}
    		}
    		
    		ret = ret > length ? ret : length;
    	}
    	
    	return ret;    	
    	
    }
}