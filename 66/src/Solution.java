

public class Solution {
    public int[] plusOne(int[] digits) {
    	if(digits == null || digits.length <= 0){
    		return null;
    	}
    	
    	int he = digits[digits.length - 1] + 1;
    	int mode = he % 10;
    	int set = he / 10;
    	
    	digits[digits.length - 1] = mode;
    	
    	
    	for(int i = digits.length - 2; i >= 0; i--){
    		he = digits[i] + set;
    		mode = he % 10;
    		set = he / 10;
    		
    		digits[i] = mode;
    	}
    	
    	if(set == 0){
    		return digits;
    	}
    	
    	int []ret = new int[digits.length + 1];
    	ret[0] = set;
    	
    	for(int i = 0; i < digits.length; i++){
    		ret[i + 1] = digits[i];
    	}
    	
    	return ret;        
    }
}