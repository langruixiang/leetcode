import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

public class Solution {
	private List<List<String>> ret = new ArrayList<List<String>>();
	
    public List<List<String>> groupAnagrams(String[] strs) {
    	if(strs == null || strs.length == 0){
    		return ret;
    	}
    	
    	Hashtable<String,List<String>> ht = new Hashtable<String,List<String>>();
        
    	for(int i = 0; i < strs.length; i++){
        	char []arr = strs[i].toCharArray();
        	Arrays.sort(arr);
        	String key = new String(arr);
        	
        	List<String> value = null;
        	if(ht.containsKey(key)){
        		value = ht.get(key);        		       		
        	}else{
        		value = new ArrayList<String>();
        		ht.put(key, value);
        	}
        	
        	value.add(strs[i]);
        }
        
        for(String key : ht.keySet()){
        	Collections.sort(ht.get(key));
        	ret.add(ht.get(key));
        }
        
        return ret;    	
    }
}