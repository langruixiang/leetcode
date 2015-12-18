public class Solution {
    public int maxProduct(String[] words) {
    	if(words == null || words.length <= 1){
    		return 0;
    	}
    	
    	int[] flag = new int[words.length];
    	for(int i = 0; i < words.length; i++){
    		for(int j = 0; j < words[i].length(); j++){
    			flag[i] |= (1 << (words[i].charAt(j) - 'a'));
    		}
    	}
    	
    	int ret = 0;
    	
    	for(int i = 0; i < words.length; i++){
    		for(int j = i + 1; j < words.length; j++){
    			if((flag[i] & flag[j]) == 0){
    				int len = words[i].length() * words[j].length();
    				ret = ret > len ? ret : len;
    			}
    		}
    	}
        
    	return ret;
    }
}