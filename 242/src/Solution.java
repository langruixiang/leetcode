import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isAnagram(String s, String t) {
    	if(s == null && t == null){
    		return true;
    	}
    	
    	if(s == null || t == null){
    		return false;
    	}
    	
    	if(s.length() != t.length()){
    		return false;
    	}
    	
    	Map<Character,Integer> map = new HashMap<Character,Integer>();
    	for(int i = 0; i < s.length(); i++){
    		char c = s.charAt(i);
    		if(map.containsKey(c)){
    			map.replace(c, map.get(c) + 1);
    		}else{
    			map.put(c, 1);
    		}
    	}
    	
    	for(int i = 0; i < t.length(); i++){
    		char c = t.charAt(i);
    		if(map.containsKey(c)){
    			int counter = map.get(c);
    			if(counter == 1){
    				map.remove(c);
    			}else{
    				map.replace(c, counter - 1);
    			}
    		}else{
    			return false;
    		}
    	}
    	
    	return true;        
    }
}