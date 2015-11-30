import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
    	if(pattern == null && str == null){
    		return true;
    	}
    	
    	if(pattern == null || str == null){
    		return false;
    	}
    	
    	String[] words = str.split(" ");
    	if(pattern.length() != words.length){
    		return false;
    	}
    	
    	Map<Character,String> map1 = new HashMap<Character,String>();
    	Map<String,Character> map2 = new HashMap<String,Character>();
    	
    	for(int i = 0; i < pattern.length(); i++){
    		char c = pattern.charAt(i);
    		
    		if(map1.containsKey(c)){
    			String word = map1.get(c);
    			if(!word.equals(words[i])){
    				return false;
    			}
    		}else{
    			map1.put(c, words[i]);
    		}
    		
    		if(map2.containsKey(words[i])){
    			char cTmp = map2.get(words[i]);
    			if(cTmp != c){
    				return false;
    			}
    		}else{
    			map2.put(words[i], c);
    		}
    		
    	}
    	
    	return true;
        
    }
}