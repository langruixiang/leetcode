import java.util.ArrayList;
import java.util.List;

public class Solution {	
    public List<Integer> getRow(int rowIndex) {
    	List<Integer> ret = new ArrayList<Integer>();
    	
    	if(rowIndex < 0){
    		return ret;
    	}    	
    	ret.add(1);
    	
    	for(int i = 0; i < rowIndex ;i++){
    		for(int j = 0; j + 1 < ret.size(); j++){
    			ret.set(j, ret.get(j) + ret.get(j + 1));
    		}
    		  ret.add(0, 1);
    	}
      
        
        return ret;
    }
}