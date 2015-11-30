import java.util.ArrayList;
import java.util.List;

public class Solution {
	private List<List<Integer>> ret = new ArrayList<List<Integer>>();
	
	private void combinationSum(int[] arrays,List<Integer> pre,int begin,int k,int n){
		if(k == 1){
			for(int i = begin; i < arrays.length; i++){
				if(arrays[i] == n){
					pre.add(arrays[i]);
					
					List<Integer> tmp = new ArrayList<Integer>();
					tmp.addAll(pre);
					ret.add(tmp);
					
					pre.remove(pre.size() - 1);
					
					return ;
				}
			}
		}else{
			for(int i = begin; i < arrays.length; i++){
				if(arrays[i] < n){
					pre.add(arrays[i]);
					combinationSum(arrays, pre, i + 1, k - 1, n - arrays[i]);
					pre.remove(pre.size() - 1);
				}
			}
		}
		
	}
	
    public List<List<Integer>> combinationSum3(int k, int n) {
    	if(k < 1 || n < 1){
    		return ret;
    	}
    	
    	List<Integer> pre = new ArrayList<Integer>();
    	int[] arrays = new int[9];
    	for(int i = 0; i < 9; i++){
    		arrays[i] = i + 1;
    	}
    	
    	combinationSum(arrays, pre, 0, k, n);     
    	
    	return ret;
    }
}