import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	private List<List<Integer>> ret = new ArrayList<List<Integer>>();
	
	private void findSum(int[] candidates, int target, int begin, List<Integer> pre){
		if(target == 0){
			List<Integer> tmp = new ArrayList<Integer>();
			tmp.addAll(pre);
			ret.add(tmp);
			return ;
		}
		
		for(int i = begin; i < candidates.length; i++){
			if(candidates[i] <= target){
				pre.add(candidates[i]);
				findSum(candidates, target - candidates[i], i, pre);
				pre.remove(pre.size() - 1);
			}else{
				break;
			}
		}
		
	}
	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	if(candidates == null || candidates.length == 0){
    		return ret;
    	}
    	
        Arrays.sort(candidates);
        
        List<Integer> list = new ArrayList<Integer>();
        findSum(candidates, target, 0, list);
        
        return ret;
    }
}