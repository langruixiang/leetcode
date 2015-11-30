import java.util.ArrayList;
import java.util.List;

public class Solution {
	List<String> ret = new ArrayList<String>();
	
	public void generate(int left,int right,String prefix){
		if(left > right){
			return ;
		}
		
		if(left == 0 && right == 0){
			ret.add(prefix);			
		}
		
		if(left > 0){
			generate(left - 1, right, prefix + "(");
		}
		
		if(right > 0){
			generate(left, right - 1, prefix + ")");	
		}
	}
	
    public List<String> generateParenthesis(int n) {
    	
    	
    	if( n <= 0){
    		return ret;
    	}
    	
    	generate(n, n, "");
        
    	return ret;
    }
}