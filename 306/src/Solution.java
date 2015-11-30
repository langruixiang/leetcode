public class Solution {
    public boolean isAdditiveNumber(String num) {
    	if(num == null || num.length() < 3){
    		return false;
    	}
    	
    	for(int i = 1; i <= (num.length() + 1) / 2; i++){
    		String tmp = num.substring(0,i);
    		if(tmp.length() >= 2 && tmp.startsWith("0")){
    			break;
    		}
    		
    		long num1 = Long.parseLong(tmp);
    		for(int j = i + 1; j < num.length(); j++){
    			tmp = num.substring(i, j);
    			if(tmp.length() >= 2 && tmp.startsWith("0")){
        			break;
        		}
    			
    			long num2 = Long.parseLong(tmp);
    			
    			String num3 = String.valueOf(num1 + num2);
    			String prefix = "" + num1 + num2 + num3;

    			while(prefix.length() < num.length() && num.startsWith(prefix)){
    				long num1tmp = num2;
    				num2 = Long.parseLong(num3);
    				num3 = String.valueOf(num1tmp + num2);
    				prefix += num3;
    			}
    			
    			if(prefix.equals(num)){
    				return true;
    			}    			
    		}
    	}
    	
    	return false;        
    }
}