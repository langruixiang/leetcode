import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
    	if(s == null || s.length() == 0){
    		return true;
    	}
    	
    	StringBuilder word = new StringBuilder(s);
    	boolean[] res = new boolean[s.length() + 1];
    	
    	res[0] = true;
    	
    	for(int i = 0; i < word.length(); i++){
    		for(int j = 0; j <= i; j++){
    			String tmp = word.substring(j, i + 1);
    			if(res[j] && wordDict.contains(tmp)){
    				res[i + 1] = true;
    				break;
    			}
    		}
    		
    	}
        
    	return res[word.length()];
    }
}