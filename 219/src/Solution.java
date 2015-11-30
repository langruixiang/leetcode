import java.util.Hashtable;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
    	
    	for(int i = 0; i < nums.length; i++){
    		if(ht.containsKey(nums[i])){
    			if(i - ht.get(nums[i]) <= k){
    				return true;
    			}else{
    				ht.replace(nums[i], i);
    			}
    		}else{
    			ht.put(nums[i], i);
    		}
    	}
    	
    	return false;
        
    }
}