//import java.util.NavigableSet;
//import java.util.Set;
//import java.util.TreeSet;

//import java.util.Hashtable;
//
//public class Solution {
//    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//    	if(t <= k){
//    		Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
//        	
//        	for(int i = 0; i < nums.length; i++){
//        		if(ht.containsKey(nums[i])){
//        			if(i - ht.get(nums[i]) <= k){
//        				return true;
//        			}    			
//        		}
//        		
//        		for(int delta = -t; delta <= t; delta++){
//    				if(ht.containsKey(nums[i] + delta)){
//    					ht.replace(nums[i] + delta, i);
//    				}else{
//    					ht.put(nums[i] + delta, i);
//    				}
//    			}
//        	}
//        	
//        	return false;     
//    	}else{
//    		for(int i = 0; i < nums.length; i++){
//    			for(int delta = 1; delta <= k; delta++){    				
//    				if(i + delta >=0 && i + delta < nums.length){
//    					if(Math.abs(nums[i + delta] - nums[i]) <= t && Math.abs(nums[i + delta] - nums[i]) >= 0){
//    						return true;
//    					}
//    				}
//    			}
//    		}
//    		return false;
//    	}
//    }
//}

import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k<1 || t<0 || nums==null || nums.length<2) return false;
        
        SortedSet<Long> set = new TreeSet<Long>();
        
        for(int j=0; j<nums.length; j++) {
            SortedSet<Long> subSet =  set.subSet((long)nums[j]-t, (long)nums[j]+t+1);
            if(!subSet.isEmpty()) return true;
            
            if(j>=k) {
                set.remove((long)nums[j-k]);
            }
            set.add((long)nums[j]);
        }
        return false;
    }
}