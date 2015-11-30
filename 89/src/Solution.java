import java.util.ArrayList;
import java.util.List;

public class Solution {
	private List<Integer> ret = new ArrayList<Integer>();
	
    public List<Integer> grayCode(int n) {
    	if(n < 0){
    		return ret;
    	}
    	
    	int counter = 1 << n;
    	for(int i = 0; i < counter; i++){
    		ret.add((i >> 1) ^ i);
    	}
        
    	return ret;
    }
}