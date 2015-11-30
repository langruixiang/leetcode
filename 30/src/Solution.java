import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
	private List<Integer> list = new ArrayList<Integer>();
	private HashMap<String,Integer> wordsHashMap = new HashMap<String,Integer>();
	
    public List<Integer> findSubstring(String s, String[] words) {
    	if(s == null || words == null || words.length == 0){
    		return list;
    	}
    	
        for(int i = 0; i < words.length; i++){
    	   if(wordsHashMap.containsKey(words[i])){
    		   wordsHashMap.replace(words[i], wordsHashMap.get(words[i]) + 1);
    	   }else{
    		   wordsHashMap.put(words[i], 1);
    	   }
        }
       
       int singleLegth = words[0].length();
       int allLength = singleLegth * words.length;
       
       HashMap<String,Integer> hm = new HashMap<String,Integer>();
       
       for(int index = 0; index <= s.length() - allLength; index++){
    	   
    	   hm.putAll(wordsHashMap);
    	   
    	   int i;
    	   for(i = index; i < index + allLength; i += singleLegth){
    		   String word = s.substring(i, i + singleLegth);
    		   if(hm.containsKey(word)){
    			   if(hm.get(word) == 1){
    				   hm.remove(word);
    			   }else{
    				   hm.replace(word, hm.get(word) - 1);
    			   }    			   
    		   }else{
    			   break;
    		   }
    	   }
    	   
    	   if(hm.isEmpty()){
    		   list.add(index);
    	   }
    	   
    	   hm.clear();
       }
       
       return list;
    }
}