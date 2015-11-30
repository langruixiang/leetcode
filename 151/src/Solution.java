public class Solution {
	private void reverseString(StringBuilder string,int left,int right){
		int i = left; 
		int j = right;
		
		while(i < j){
			char c = string.charAt(i);
			string.setCharAt(i, string.charAt(j));
			string.setCharAt(j, c);
			i++;
			j--;
		}
	}
	
    public String reverseWords(String s) {
    	s = s.trim();
    	
    	StringBuilder string = new StringBuilder(s);
    	string.reverse();
    	
    	int left = 0;
    	int right = left;
    	
    	while(right < string.length()){
    		if(string.charAt(right) == ' '){
    			reverseString(string,left,right - 1);
    			right++;
    			while(string.charAt(right) == ' '){
    				string.deleteCharAt(right);    				
    			}
    			left = right;
    		}else{
    			right++;
    		}
    	}
        
    	reverseString(string,left,right - 1);
    	
    	return string.toString();
    }
}