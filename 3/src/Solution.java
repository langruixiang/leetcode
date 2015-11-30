import java.util.Hashtable;

//public class Solution {
//	
//    public int lengthOfLongestSubstring(String s) {
//    	int ret = 0;
//    	int begin = -1;
//    	
//    	int lastLocation[] = new int[256];
//    	
//    	for(int i = 0; i < 256; i++){
//    		lastLocation[i] = -1;
//    	}
//    	
//    	for(int i = 0; i < s.length(); i++){
//    		if(lastLocation[s.charAt(i)] > begin){
//    			begin = lastLocation[s.charAt(i)];
//    		}
//    		
//    		if(i - begin > ret){
//    			ret = i - begin;
//    		}
//    		
//    		lastLocation[s.charAt(i)] = i;
//    	}    	
//    	return ret;        
//    }
//}
public class Solution {
	
    public int lengthOfLongestSubstring(String s) {
    	if(s == null || s.length() == 0){
    		return 0;
    	}
    	
    	Hashtable<Character,Integer> ht = new Hashtable<Character,Integer>();
    	
    	int left = 0;
    	int right = 0;
    	
    	int len = Integer.MIN_VALUE;
    	
    	while(right < s.length()){
    		if(!ht.containsKey(s.charAt(right))){
    			ht.put(s.charAt(right), 0);
    			if(right - left + 1 > len){
    				len = right - left + 1;
    			}
    			right++;
    		}else{
    			while(s.charAt(left) != s.charAt(right)){
    				ht.remove(s.charAt(left));
    				left++;
    			}    			
    			ht.remove(s.charAt(left));
    			left++;
    		}
    	}
    	
    	return len;
    }
}