public class Solution {
    public boolean isScramble(String s1, String s2) {
    	if(s1 == null && s2 == null){
    		return true;
    	}
    	
    	if(s1 == null || s2 == null){
    		return false;
    	}
    	
    	if(s1.length() != s2.length()){
    		return false;
    	}
    	
    	if(s1.length() == 0){
    		return true;
    	}
    	
    	if(s1.length() == 1){
    		return s1.charAt(0) == s2.charAt(0);
    	}
    	
    	for(int i = 1; i < s1.length(); i++){
    		
    		String s1part1 = s1.substring(0,i);
    		String s1part2 = s1.substring(i,s1.length());
    		
    		String s2part1 = s2.substring(0,i);
    		String s2part2 = s2.substring(i,s2.length());
    		
    		if(isScramble(s1part1, s2part1) & isScramble(s1part2, s2part2) |
    			   isScramble(s1part1, s2part2) & isScramble(s1part2, s2part1) == true){
    			return true;
    		}
    	}
    	
    	return false;        
    }
}