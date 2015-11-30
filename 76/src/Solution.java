import java.util.Hashtable;

public class Solution {
    public String minWindow(String s, String t) {
    	if(s == null || t == null || t.length() == 0 || s.length() == 0){
    		return "";
    	}
    	
        Hashtable<Character,Integer> ht = new Hashtable<Character,Integer>();
        for(int i = 0; i < t.length(); i++){
        	if(ht.containsKey(t.charAt(i))){
        		ht.replace(t.charAt(i), ht.get(t.charAt(i)) + 1);
        	}else{
        		ht.put(t.charAt(i), 1);
        	}
        }
        
        int left = 0;
        int right = 0;
        int len = Integer.MAX_VALUE;
        
        int matchCounter = 0;
        
        int leftIndex = -1;
        int rightIndex = -1;
        
        while(right < s.length()){
        	if(ht.containsKey(s.charAt(right))){
        		if(ht.get(s.charAt(right)) > 0){
        			matchCounter++;
        		}
        		
        		ht.replace(s.charAt(right), ht.get(s.charAt(right)) - 1);
        		        		
        		while(matchCounter == t.length()){
        			if(right - left + 1 < len){
        				len = right - left + 1;
        				leftIndex = left;
        				rightIndex = right;
        			}
        			
        			if(ht.containsKey(s.charAt(left))){
        				ht.replace(s.charAt(left), ht.get(s.charAt(left)) + 1);
        				
        				if(ht.get(s.charAt(left)) > 0){
        					matchCounter--;
        				}
        			}
        			
        			left++;
        		}
        	}
        	right++;
        }
        
        if(leftIndex == -1){
        	return "";
        }
        
        return s.substring(leftIndex, rightIndex + 1);
    }
}