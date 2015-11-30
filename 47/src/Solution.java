import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
	List<List<Integer>> ret = new ArrayList<List<Integer>>();
	private void reverse(List<Integer> list,int begin,int end){
		while(begin < end){
			int temp = list.get(begin);
			list.set(begin,list.get(end));
			list.set(end, temp);
			
			begin++;
			end--;
		}
	}
	
	private List<Integer> nextPermutation(List<Integer> list){
		List<Integer> pre = new ArrayList<Integer>();
		pre.addAll(list);
		
		int j = pre.size() - 1;
		while(j >= 1 && pre.get(j - 1) >= pre.get(j)){
			j--;
		}
		
		if(j == 0){
			Collections.reverse(pre);
			return pre;
		}
		
	    int i = j - 1;
	    
	    while(j + 1 < pre.size() && pre.get(j + 1) > pre.get(i)){
	    	j++;
	    }
	    
	    int temp = pre.get(j);
	    pre.set(j, pre.get(i));
	    pre.set(i, temp);
	    
	    reverse(pre,i + 1,pre.size() - 1);
	    
	    return pre;
		
	}
	
    public List<List<Integer>> permuteUnique(int[] nums) {
    	if(nums == null || nums.length <= 0){
    		return ret;
    	}
    	
    	List<Integer> iterator = new ArrayList<Integer>();
    	List<Integer> start = new ArrayList<Integer>();
    	
    	Arrays.sort(nums);
    	
    	for(int i = 0; i < nums.length; i++){
    		iterator.add(nums[i]);
    	}
    	
    	start.addAll(iterator);
    	
    	ret.add(iterator);
    	
    	while(true){
    		iterator = nextPermutation(iterator);
    		if(iterator.equals(start)){
    			break;
    		}
    		ret.add(iterator);
    	}   	
        
    	return ret;
    }
}