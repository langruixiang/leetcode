public class Solution {
    public String longestPalindrome(String s) {
    	String ret = "";
    	int retLength = 0;
    	int retLeft = 0,retRight = 0;
    	
    	for(int index = 0; index < s.length(); index ++){
    		int left = index - 1;
    		int right = index + 1;
    		
    		while(left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)){
    			left--;
    			right++;
    		}
    		
			left++;
			right--;
    		
    		if(right - left + 1 > retLength){
    			retLength = right - left + 1;
    			retLeft = left;
    			retRight = right + 1;
    		}
    		
    		left = index;
    		right = index + 1;

    		while(left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)){
    			left--;
    			right++;    			
    		}
    		
			left++;
			right--;
    		
    		if(right - left + 1 > retLength){
    			retLength = right - left + 1;
    			retLeft = left;
    			retRight = right + 1;
    		}
    	}
    	
    	return s.substring(retLeft, retRight);
    }
}