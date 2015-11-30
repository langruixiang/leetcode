

public class Solution {
    public String convert(String s, int numRows) {
    	String []rows = new String[numRows];
    	for(int i = 0; i < numRows; i++){
    		rows[i] = "";
    	}
    	
    	int i = 0;
    	while(i < s.length()){
    		for(int r = 0; r < numRows; r++){
    			rows[r] += s.charAt(i++);
    			if(i == s.length()){
    				break;
    			}
    		}
    		
    		if(i == s.length()){
				break;
			}
    		
    		int r = numRows - 1;
    		for(int c = 0; c < numRows - 2; c++){
    			r--;
    			rows[r] += s.charAt(i++);
    			if(i == s.length()){
    				break;
    			}
    		}    
    	}
        
    	String ret = "";
    	for(i = 0; i < numRows; i++){
    		ret += rows[i];
    	}
    	
    	return ret;
    }
}