public class Solution {
	private String mul(String num1, char num2){
		String ret = "";
		
		int iNum2 = num2 - '0';
		
		int mode = 0;
		int set = 0;
		int ji = 0;
		
		for(int i = num1.length() - 1; i >= 0; i--){
			ji = (num1.charAt(i) - '0') * iNum2 + set;
			mode = ji % 10;
			set = ji / 10;
			
			ret = mode + ret;
		}
		
		if(set != 0 ){
			ret = set + ret;
		}
		
		return ret;
	}
	
	private String add(String num1, String num2, int bit){
		String ret = "";
		
		for(int i = 0; i < bit; i++){
			num2 += '0';
		}
		
		int index1 = num1.length() - 1;
		int index2 = num2.length() - 1;
		
		int he = 0; 
		int mode = 0;
		int set = 0;
		
		while(index1 >= 0 && index2 >= 0 ){
			he = (num1.charAt(index1) - '0') + (num2.charAt(index2) - '0') + set;
			mode = he % 10;
			set = he / 10;
			
			ret = mode + ret;
			
			index1--;
			index2--;
		}
		
		while(index1 >= 0){
			he = (num1.charAt(index1) - '0') + set;
			mode = he % 10;
			set = he / 10;
			
			ret = mode + ret;
			index1--;
		}
		
		while(index2 >= 0){
			he = (num2.charAt(index2) - '0') + set;
			mode = he % 10;
			set = he / 10;
			
			ret = mode + ret;
			index2--;
		}
		
		if(set != 0){
			ret = set + ret;
		}
		
		return ret;
	}
	
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null){
        	return null;
        }
        
        if(num1.equals("0") || num2.equals("0")){
        	return "0";
        }
        
        String ret = "0";
        for(int i = num2.length() - 1; i >= 0; i--){
        	String tmp = mul(num1, num2.charAt(i));
        	ret = add(ret, tmp, num2.length() - 1 - i);
        }
        
        return ret;
        
    }
}