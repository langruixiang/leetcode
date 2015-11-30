import java.util.Hashtable;

public class Solution {
	
	public boolean isomorphic(String s, String t){
		Hashtable<Character,Character> ht = new Hashtable<Character,Character>();
		
		char[] arrs = s.toCharArray();
    	char[] arrt = t.toCharArray();
    	
    	for(int i = 0; i < arrs.length; i++){
    		if(ht.containsKey(arrs[i])){
    			if(ht.get(arrs[i]) != arrt[i]){
    				return false;
    			}
    		}else{
    			ht.put(arrs[i], arrt[i]);
    		}
    	}
    	
    	return true;        
	}
	
	
    public boolean isIsomorphic(String s, String t) {
    	if(s == null && t == null){
    		return true;
    	}
    	
    	if(s.length() == 0 && t.length() == 0){
    		return true;
    	}
    	
    	if(s == null || t == null || s.length() != t.length()){
    		return false;
    	}
    	
    	return isomorphic(s, t) & isomorphic(t, s);
    }
}