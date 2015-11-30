import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Solution {
    public boolean isAdditiveNumber(String num) {
    	if(num == null || num.length() < 3){
    		return false;
    	}
    	
    	List<Set<Integer>> list= new ArrayList<>();
    	Set<Integer> set = new HashSet<Integer>();
    	set.add(0);
    	
    	list.add(set);
    	
    	for(int i = 1; i < num.length(); i++){
    		Set<Integer> setTmp = new HashSet<>();    		
    		for(int j = i - 1; j >= 0; j--){
    			String subString = num.substring(j, i);
    			if(subString.startsWith("0") && subString.length() > 1){
    				continue;
    			}
    			
    			int numTmp = Integer.parseInt(subString);
    			
    			Iterator<Integer> iterator = list.get(j).iterator();
    			while(iterator.hasNext()){
    				int sum = numTmp + iterator.next();
    				setTmp.add(sum);
    				System.out.print(sum + " ");
    			}    			
    		}
    		
    		list.add(setTmp);
    		System.out.println();
    	}
    	
    	for(int i = num.length() - 1; i >= 0; i--){
    		String subString = num.substring(i);
    		if(subString.startsWith("0") && subString.length() > 1){
    			continue;
    		}
    		
    		int numTmp = Integer.parseInt(subString);
    		if(list.get(i).contains(numTmp)){
    			return true;
    		}
    	}
    	
    	return false;        
    }
}