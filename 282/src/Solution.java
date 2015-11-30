import java.util.ArrayList;
import java.util.List;

public class Solution {
	private List<String> ret = new ArrayList<String>();
	
	private void findOperators(String num, int target,int begin,String pre){
		for(int i = begin; i < num.length(); i++){
			int operator1 = Integer.valueOf(num.substring(begin, i + 1));
			
			if(operator1 == target){
				ret.add(pre + operator1);
			}
			
			findOperators(num, target - operator1,i + 1,pre + operator1 + "+");
			findOperators(num, operator1 - target, i + 1, pre + operator1 + "-");
			
			for(int j = i + 1; j < num.length(); j++){
				int operator2 = Integer.valueOf(num.substring(i + 1,j + 1));
				findOperators(num, target - operator1 * operator2, j + 1, pre + operator1 + "*" + operator2 + "+");
				findOperators(num, operator1 * operator2 - target, j + 1, pre + operator1 + "*" + operator2 + "-");
			}
		}
		
	}
	
    public List<String> addOperators(String num, int target) {
    	if(num == null || num.length() == 0){
    		return ret;
    	}
    	
    	findOperators(num, target, 0, "");
    	
    	return ret;        
    }
}