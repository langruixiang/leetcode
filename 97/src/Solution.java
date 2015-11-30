public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
    	if(s1 == null && s2 == null){
    		return s3 == null;
    	}
    	
    	if(s1 == null || s1.length() == 0){
    		return s2.equals(s3);
    	}
    	
    	if(s2 == null || s2.length() == 0){
    		return s1.equals(s3);
    	}
    	
    	if(s1.length() + s2.length() != s3.length()){
    		return false;
    	}
    	
    	boolean result[][] = new boolean[s1.length() + 1][];
        for(int i = 0; i < result.length; i++){
        	result[i] = new boolean[s2.length() + 1];
        }
        
        for(int i = 0; i < result.length; i++){
        	result[i][0] = s1.substring(0,i).equals(s3.substring(0,i));
        }
        
        for(int j = 0; j < result[0].length; j++){
        	result[0][j] = s2.substring(0,j).equals(s3.substring(0,j));
        }
        
        for(int i = 1; i < result.length; i++){
        	for(int j = 1; j < result[0].length; j++){
        		if(s2.charAt(j - 1) == s3.charAt(i + j - 1)){
        			result[i][j] |= result[i][j - 1];
        		}
        		if(s1.charAt(i - 1) == s3.charAt(i + j - 1)){
        			result[i][j] |= result[i - 1][j];
        		}
        		
        		if(s1.charAt(i - 1) != s3.charAt(i + j - 1) && s2.charAt(j - 1) != s3.charAt(i + j -1)){
        			result[i][j] = false;
        		}
        	}
        }
        
        return result[s1.length()][s2.length()];
        
    }
}