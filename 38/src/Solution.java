public class Solution {
	private String say(String num){
        String ret = "";
    	
    	int index = 0; 
    	while(index < num.length()){
    		char c = num.charAt(index);
    		int count = 1;
    		
    		index++;
    		while(index < num.length() && num.charAt(index) == c){
    			index++;
    			count++;
    		}
    		
    		ret = ret + count + c;
    	}        
    	
    	return ret;
	}
	
    public String countAndSay(int n) {
    	if(n <= 0){
    		return "";
    	}
    	
    	String num = "1";
    	
    	for(int i = 1; i < n; i++){
    		num = say(num);
    	}
    	
    	return num;
    }
}