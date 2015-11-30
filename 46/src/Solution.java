import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	List<List<Integer>> ret = new ArrayList<List<Integer>>();
	
	private void helper(List<Integer> nums,List<Integer> pre){
		if(nums.size() == 0){
			ret.add(pre);
		}
		
		for(int i = 0 ; i < nums.size(); i++){
			List<Integer> tmpPre = new ArrayList<Integer>();
			tmpPre.addAll(pre);
			
			List<Integer> tmpNums = new ArrayList<Integer>();
			tmpNums.addAll(nums);
			
			tmpPre.add(nums.get(i));
			tmpNums.remove(i);
			
			helper(tmpNums, tmpPre);
		}
	}
	
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0){
        	return ret;
        }
        
        List<Integer> tmp = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
        	tmp.add(nums[i]);
        }
        
        List<Integer> pre = new ArrayList<Integer>();
        helper(tmp, pre);
        
        return ret;
    }
}