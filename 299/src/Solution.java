import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String getHint(String secret, String guess) {
    	if(secret == null || secret.length() == 0 || guess == null || guess.length() == 0){
    		return "0A0B";
    	}
    	
    	int numOfA = 0;
    	int numOfB = 0;
    	
    	Map<Character,Integer> map = new HashMap<>();
    	
    	for(int i = 0; i < secret.length(); i++){
    		if(secret.charAt(i) == guess.charAt(i)){
    			numOfA++;
    		}else{
    			char c = guess.charAt(i);
    			
    			if(map.containsKey(c)){
    				map.replace(c, map.get(c) + 1);
    			}else{
    				map.put(c, 1);
    			}
    		}
    	}
    	
    	for(int i = 0; i < secret.length(); i++){
    		if(secret.charAt(i) != guess.charAt(i)){
    			char c = secret.charAt(i);
    			if(map.containsKey(c)){
    				if(map.get(c) > 0){
    					numOfB++;
    					map.replace(c, map.get(c) - 1);
    				}
    			}
    		}
    	}
    	
    	return numOfA + "A" + numOfB + "B";
        
    }
}