import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	private List<List<Integer>> ret = new ArrayList<List<Integer>>();
	
	private void generateSubsets(int[] nums,int begin,List<Integer> pre){
		if(begin == nums.length){
			List<Integer> tmp = new ArrayList<Integer>();
			tmp.addAll(pre);
			ret.add(tmp);
			return ;
		}
		
		int delta = 0;
		
		while(begin + delta < nums.length && nums[begin + delta] == nums[begin]){
			delta++;
		}
		
		for(int i = 0; i <= delta; i++){
			generateSubsets(nums, begin + delta, pre);
			pre.add(nums[begin]);
		}
		
		for(int i = 0; i <= delta; i++){
			pre.remove(pre.size() - 1);
		}
	}
	
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	if(nums == null || nums.length == 0){
    		return ret;
    	}
    	
    	Arrays.sort(nums);
    	
    	List<Integer> pre = new ArrayList<Integer>();
    	
    	generateSubsets(nums, 0, pre);   
    	
//    	System.out.println("Pre ��С��" + pre.size());
    	
    	return ret;
    }
}