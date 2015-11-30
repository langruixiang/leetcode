//public class Solution {
//    public int myAtoi(String str) {
//    	if(str == null || str.length() == 0){
//    		return 0;
//    	}
//    	
//    	int flag = 1;
//    	
//    	int i = 0;
//    	
//    	while(i < str.length() && str.charAt(i) == ' '){
//    		i++;
//    	}
//    	
//    	if(i == str.length()){
//    		return 0;
//    	}
//    	
//    	if(str.charAt(i) == '-'){
//    		flag = -1;
//    		i++;
//    	}else if(str.charAt(i) == '+'){
//    		i++;
//    	}
//    	
//    	long ret = 0;
//    	while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
//    		ret = ret * 10 + str.charAt(i) - '0';
//    		if(flag * ret > Integer.MAX_VALUE){
//    			return Integer.MAX_VALUE;
//    		}else if(flag * ret < Integer.MIN_VALUE){
//    			return Integer.MIN_VALUE;
//    		}
//    		i++;
//    	}
//    	
//    	ret *= flag;
//		return (int)ret;
//    }
//}

public class Solution {
	private boolean isDigit(char c){
		if(c >= '0' && c <= '9'){
			return true;
		}
		
		return false;
	}

	
    public int myAtoi(String str) {
    	if(str == null || str.length() == 0){
    		return 0;
    	}
    	
    	char[] arr = str.toCharArray();
    	int index = 0;
    	while(index < arr.length && arr[index] == ' '){
    		index++;
    	}
    	
    	if(index == arr.length){
    		return 0;
    	}
    	
    	boolean positive = true;
    	
    	if(!isDigit(arr[index])){
    		if(arr[index] == '-'){
    			positive = false;
    		}else if(arr[index] == '+'){
    			positive = true;
    		}else{
    			return 0;
    		}
    		index++;
    	}
    	
    	int limit = positive ? -Integer.MAX_VALUE : Integer.MIN_VALUE;
    	int result = 0;
    	while(index < arr.length && isDigit(arr[index])){
    		if(result < limit / 10){
    			return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    		}
    		result *= 10;
    		int digit = arr[index] - '0';
    		if(result < limit + digit){
    			return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    		}
    		result -= digit;
    		index++;
    	}
    	
    	return positive ? -result : result;
    	     
    }
}