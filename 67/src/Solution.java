public class Solution {
    public String addBinary(String a, String b) {
    	if(a == null || b == null){
    		return null;
    	}
    	
    	if(a.equals("")){
    		return b;
    	}
    	
    	if(b.equals("")){
    		return a;
    	}
    	
    	if(a.length() < b.length()){
    		int delta = b.length() - a.length();
    		for(int i = 0; i < delta; i++){
    			a = "0" + a;
    		}
    	}else{
    		int delta = a.length() - b.length();
    		for(int i = 0; i < delta; i++){
    			b = "0" + b;
    		}
    	}
    	
        String ret = "";
    	
    	int mode = 0;
    	int bit = 0;
    	
    	int he = 0;
    	
    	
    	int i = a.length() - 1;
    	while(i >= 0){
    		int num1 = a.charAt(i) - '0';
    		int num2 = b.charAt(i) - '0';
    		
    		he = num1 + num2 + bit;
    		mode = he % 2;
    		bit = he / 2;
    		
    		ret = mode + ret;
    		i--;
    	}
    	
    	
    	if(bit != 0){
    		ret = bit + ret;
    	}
    	
    	return ret;
    }
}