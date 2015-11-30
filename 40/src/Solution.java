import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	private List<List<Integer>> ret = new ArrayList<List<Integer>>();
	
	private void findSum(int[] candidates, int target, int begin, List<Integer> pre){
		if(target == 0){
			ret.add(pre);
		}
		
		for(int i = begin; i < candidates.length; i++){
			if(candidates[i] <= target){
				List<Integer> temp = new ArrayList<Integer>();
				temp.addAll(pre);
				
				temp.add(candidates[i]);
				findSum(candidates, target - candidates[i], i + 1, temp);
				
				while(i + 1 < candidates.length && candidates[i + 1] == candidates[i]){
					i++;
				}
			}else{
				break;
			}
		}
		
	}
	
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	if(candidates == null || candidates.length == 0){
    		return ret;
    	}
    	
        Arrays.sort(candidates);
        
        List<Integer> list = new ArrayList<Integer>();
        findSum(candidates, target, 0, list);
        
        return ret;
    }
}