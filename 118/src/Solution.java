import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	private List<List<Integer>> ret = new ArrayList<List<Integer>>();
	
    public List<List<Integer>> generate(int numRows) {
    	if(numRows <= 0){
    		return ret;
    	}
    	
    	List<Integer> row = new ArrayList<Integer>();
    	row.add(1);
    	ret.add(row);
    	
    	List<Integer> lastRow = null;
    	
    	for(int i = 1; i < numRows; i++){
    		lastRow = ret.get(ret.size() - 1);    		
    		row = new ArrayList<Integer>();
    		row.add(1);
        	for(int j = 0; j + 1 < lastRow.size(); j++){
        		row.add(lastRow.get(j) + lastRow.get(j + 1));
        	}
        	row.add(1);
            ret.add(row);
    	}
    	
    	return ret;
    }
}