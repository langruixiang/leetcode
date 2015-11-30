import java.util.ArrayList;
import java.util.List;

public class Solution {
	private List<List<Integer>> ret = new ArrayList<List<Integer>>();
	
	private void findCombination(List<Integer> list,int n,List<Integer> pre,int begin){
		if(n == 0){
			List<Integer> tmp = new ArrayList<Integer>();
			tmp.addAll(pre);
			ret.add(tmp);
			return ;
		}
		
		for(int i = begin; i < list.size(); i++){
			pre.add(list.get(i));
			findCombination(list, n - 1, pre,i + 1);
			pre.remove(pre.size() - 1);
		}
		
	}
	
    public List<List<Integer>> combine(int n, int k) {
        if(k > n || n <= 0 || k <= 0){
        	return ret;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i < n; i++){
        	list.add(i + 1);
        }
        
        List<Integer> pre = new ArrayList<Integer>();
        
        findCombination(list, k, pre,0);
        
        return ret;
    }
}