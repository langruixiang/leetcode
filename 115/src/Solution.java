public class Solution {
    public int numDistinct(String s, String t) {
    	if(s == null || t == null || s.length() < t.length()){
    		return 0;
    	}
    	
    	int counter[][] = new int[s.length() + 1][];
    	for(int i = 0; i < counter.length;i++){
    		counter[i] = new int[t.length() + 1];
    	}
    	
    	counter[0][0] = 1;
    	
    	int i = 0;
    	for(int j = 1; j < counter[0].length; j++){
    		counter[i][j] = 0;
    	}
    	
    	int j = 0;
    	for(i = 1; i < counter.length; i++){
    		counter[i][j] = 1;
    	}
    	
    	for(i = 1; i < counter.length; i++){
    		for(j = 1; j < counter[0].length;j++){
    			if(s.charAt(i - 1) == t.charAt(j - 1)){
    				counter[i][j] = counter[i - 1][j - 1] + counter[i - 1][j];
    			}else{
    				counter[i][j] = counter[i - 1][j];
    			}
    		}
    	}
        
    	return counter[s.length()][t.length()];
    }
}