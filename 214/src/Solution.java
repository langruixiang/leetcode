

public class Solution {
    public String shortestPalindrome(String s) {
    	if(s == null || s.length() <= 1){
    		return s;
    	}
    	
    	char[] arrays = s.toCharArray();
    	
    	int i = 0;
    	
    	if(s.length() % 2 == 1){
    		i = s.length() / 2;
    		int delta = 1;
    		while(i - delta >= 0){
    			if(arrays[i - delta] == arrays[i + delta]){
    				delta++;
    			}else{
    				break;
    			}
    		}
    		
    		if(i - delta < 0){
    			return s;
    		}
    		i--;
    	}else{
    		i = (s.length() - 1) / 2 ;
    	}
    	
    	while(i >= 0){
    		
    		int delta = 0;
    		int rightBase = i + 1;
    		
    		while(i - delta >= 0){
    			if(arrays[i - delta] == arrays[rightBase + delta]){
    				delta++;
    			}else{
    				break;
    			}
    		}
    		
    		if(i - delta < 0){
    			StringBuffer bu = new StringBuffer(s.substring(rightBase + delta));
    			String prefix = new String(bu.reverse());
    			return prefix + s;
    		}
    		
    		delta = 1;
    		while(i - delta >= 0){
    			if(arrays[i - delta] == arrays[i + delta]){
    				delta++;
    			}else{
    				break;
    			}
    		}
    		
    		if(i - delta < 0){
    			StringBuffer bu = new StringBuffer(s.substring(i + delta));
    			String prefix = new String(bu.reverse());
    			return prefix + s;
    		}
    		
    		i--;
    	}
    	
    	StringBuffer bu = new StringBuffer(s.substring(1));
    	String prefix = new String(bu.reverse());
    	return prefix + s;        
    }
}