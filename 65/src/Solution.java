public class Solution {
	private boolean isDigit(char c){
		if(c >= '0' && c <= '9'){
			return true;
		}
		
		return false;
	}
	
    public boolean isNumber(String s) {
    	char[] arr = s.trim().toCharArray();
    	if(arr.length == 0){
    		return false;
    	}
    	
    	int index = 0;
    	boolean num = false;
    	boolean exp = false;
    	boolean dot = false;
    	
    	if(!isDigit(arr[index])){
    		if(arr[index] == '+' || arr[index] == '-'){
    			index++;
    		}else if(arr[index] == '.'){
    			index++;
    			dot = true;
    		}
    		else{
    			return false;
    		}
    	}
    	
    	while(index < arr.length){
    		if(isDigit(arr[index])){
    			num = true;
    		}else if(arr[index] == '.'){
    			if(dot == true || exp == true){
    				return false;
    			}
    			dot = true;
    		}else if(arr[index] == 'e'){
    			if(num == false || exp == true){
    				return false;
    			}
    			exp = true;
    			num = false;
    		}else if(arr[index] == '+' || arr[index] == '-'){
    			if(arr[index - 1] != 'e'){
    				return false;
    			}
    		}
    		else{
    			return false;
    		}
    		
    		index++;
    	}
    	
    	return num;        
    }
}