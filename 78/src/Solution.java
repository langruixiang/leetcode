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
		
		pre.add(nums[begin]);
		generateSubsets(nums, begin + 1, pre);
		
		pre.remove(pre.size() - 1);
		generateSubsets(nums, begin + 1, pre);
	}
	
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0){
        	return ret;
        }
        
        Arrays.sort(nums);
        
        List<Integer> pre = new ArrayList<Integer>();
        
        generateSubsets(nums, 0, pre);
        
        return ret;
    }
}