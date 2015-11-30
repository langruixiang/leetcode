import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

//import java.util.ArrayList;
//import java.util.Hashtable;
//import java.util.List;
//
//public class Solution {
//	private List<String> ret = new ArrayList<String>();
//	
//	private int getCode(char a){
//		switch (a) {
//		case 'A':
//			return 0;		
//		case 'C':
//			return 1;
//		case 'G':
//			return 2;
//		case 'T':
//		    return 3;
//		default:
//		    return -1;
//		}
//		
//	}
//	
//    public List<String> findRepeatedDnaSequences(String s) {
//        if(s == null || s.length() <= 10){
//        	return ret;
//        }
//        
//        char[] arrays = s.toCharArray();
//        
//        Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
//        
//        int iterator = 0;
//        for(int i = 0; i < 10; i++){
//        	iterator = iterator << 2;
//        	iterator |= getCode(arrays[i]);        	
//        }
//        
//        ht.put(iterator,1);
//        
//        for(int i = 10; i < arrays.length; i++){
//        	iterator &= 0X3FFFF;
//        	iterator = iterator << 2;
//        	iterator |= getCode(arrays[i]);
//        	
//        	if(ht.containsKey(iterator)){
//        		int counter = ht.get(iterator);
//        		if(counter == 1){
//        			String item = s.substring(i - 9,i + 1);
//            		ret.add(item);
//            		ht.replace(iterator, 2);
//        		}
//        	}else{
//        		ht.put(iterator, 1);
//        	}        	
//        }
//        
//        return ret;
//    }
//}

public class Solution {
	List<String> ret = new ArrayList<String>();
    public List<String> findRepeatedDnaSequences(String s) {
    	if(s == null || s.length() <= 10){
    		return ret;
    	}
    	
    	Hashtable<String,Integer> ht = new Hashtable<String,Integer>();
    	for(int i = 0; i <= s.length() - 10; i++){
    		String item = s.substring(i,i + 10);
    		
    		if(ht.containsKey(item)){
    			int counter = ht.get(item);
    			if(counter == 1){
    				ret.add(item);
    				ht.replace(item, 2);
    			}
    		}else{
    			ht.put(item, 1);
    		}
    	}
        
    	return ret;
    }
}