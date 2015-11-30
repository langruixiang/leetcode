public class Solution {
    public int longestValidParentheses(String s) {
    	int ret = 0;
    	
    	if(s == null){
    		return ret;
    	}
    	
    	for(int index1 = 0; index1 < s.length(); index1++){
    		if(s.charAt(index1) == ')'){
    			continue;
    		}
    		
    		int leftCounter = 0;
    		int rightCounter = 0;
    		int index2;
    		for(index2 = index1; index2 < s.length(); index2++){
    			if(s.charAt(index2) == '('){
    				leftCounter++;
    			}else if(s.charAt(index2) == ')'){
    				rightCounter++;
    			}
    			
    			if(rightCounter > leftCounter){
    				break;
    			}else if(rightCounter == leftCounter){
    				ret = index2 - index1 + 1 > ret ? index2 - index1 + 1 : ret;
    			}
    		}
    		
    		if(leftCounter > rightCounter){
    			index1 += leftCounter - rightCounter -1;
    		}else if(leftCounter < rightCounter){
    			index1 = index2;
    		}
    	}
        
    	return ret;
    }
}