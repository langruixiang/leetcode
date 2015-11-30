import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	private Map<Integer,String> convert;
	
	public List<String> ret = new ArrayList<String>();
	
	private void combination(String pre,String digits){
		
		int num = Integer.parseInt(digits.substring(0, 1));
		String letters = convert.get(num);
		
		if(digits.length() == 1){
		   for(int i = 0; i < letters.length(); i++){
			   ret.add(pre + letters.charAt(i));
		   }
		}else{
			digits = digits.substring(1);	
			
			for(int i = 0; i < letters.length(); i++){
				combination(pre + letters.charAt(i), digits);
			}
		}		
	}
	
    public List<String> letterCombinations(String digits) {
    	if(digits.equals("")){
    		return ret;
    	}
    	
    	convert = new HashMap<Integer,String>();
        
    	convert.put(2, "abc");
        convert.put(3, "def");
        convert.put(4, "ghi");
        convert.put(5, "jkl");
        convert.put(6, "mno");
        convert.put(7, "pqrs");
        convert.put(8, "tuv");
        convert.put(9, "wxyz");
        
        combination("", digits);
        
        return ret;        
        
    }
}