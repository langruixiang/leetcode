public class Solution {
	private String commonPrefix(String str1, String str2){
		String ret = "";
		
		int len  = Math.min(str1.length(), str2.length());
		
		for(int i = 0; i < len; i++){
			if(str1.charAt(i) == str2.charAt(i)){
				ret += str1.charAt(i);
			}else{
				return ret;
			}
		}
		
		return ret;
	}
	
    public String longestCommonPrefix(String[] strs) {
    	String ret = "";
    	
    	if(strs.length == 0){
    		return ret;
    	}
    	
    	if(strs.length == 1){
    		return strs[0];
    	}
    	
    	ret = commonPrefix(strs[0],strs[1]);
    	
    	for(int i = 2; i < strs.length; i++){
    		ret = commonPrefix(ret, strs[i]);
    	}
    	
    	return ret;        
    }
}