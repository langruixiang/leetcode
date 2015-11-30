public class Solution {
    public int titleToNumber(String s) {
    	if(s == null || s.length() == 0){
    		return 0;
    	}
    	
    	char[] str = s.toCharArray();
    	int ret = 0;
    	
    	int base = 'A' - 1;
    	for(int i = 0; i < str.length; i++){
    		ret = ret * 26 + str[i] - base;
    	}
        
    	return ret;
    }
}