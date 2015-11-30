public class Solution {
    public boolean isPalindrome(String s) {
    	if(s == null){
    		return false;
    	}
    	
    	if(s.length() == 0){
    		return true;
    	}
    	
    	StringBuilder str = new StringBuilder();
    	
    	String lowcase = s.toLowerCase();
    	
    	for(int i = 0; i < lowcase.length();i++){
    		char c = lowcase.charAt(i);
    		if(c >= 'a' && c <= 'z' ||
    		   c >= 'A' && c <= 'Z' ||
    		   c >= '0' && c <= '9'){
    			str.append(c);
    		}
    	}
    	
    	int l = 0;
    	int r = str.length() - 1;
    	while(l < r){
    		if(str.charAt(l) == str.charAt(r)){
    			l++;
    			r--;
    		}else{
    			return false;
    		}
    	}
    	
    	return true;
        
    }
}