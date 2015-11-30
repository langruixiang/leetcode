import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class Solution {
	private List<String> ret = new ArrayList<String>();
	private Hashtable<Integer,List<Integer>> ht = new Hashtable<Integer,List<Integer>>();
	private String word;
	
	private void restore(String pre,int end){
		if(end == 0){
			ret.add(pre);
			return ;
		}		
		
		List<Integer> begins = ht.get(end);
		for(int i = 0; i < begins.size(); i++){
			String tmp;
			
			if(pre.equals("")){
				tmp = word.substring(begins.get(i),end);
			}else{
				tmp = word.substring(begins.get(i),end) + " " + pre;
			}
			
			restore(tmp, begins.get(i));
		}
	}
	
    public List<String> wordBreak(String s, Set<String> wordDict) {
    	if(s == null || s.length() == 0){
    		return ret;
    	}
    	
    	word = s;
    	
    	boolean[] flags = new boolean[s.length() + 1];
    	flags[0] = true;
    	    	
    	List<Integer> ite = new ArrayList<Integer>();
    	ite.add(0);
    	
    	ht.put(0, ite);
    	
    	
    	for(int i = 0; i < s.length(); i++){
    		ite = new ArrayList<Integer>();
    		
    		for(int j = 0; j <= i; j++){
    			if(flags[j] && wordDict.contains(s.substring(j,i + 1))){
    				flags[i + 1] = true;    				
    				ite.add(j);    				
    			}
    		}
    		
    		if(ite.size() != 0){
    			ht.put(i + 1, ite);
    		}
    	}
    	
    	if(ht.containsKey(s.length())){           
           restore("", s.length());
    	}
    	
    	return ret;
    }
}