import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
	private List<String> ret = new ArrayList<>();
	
	private boolean isValid(String str){
		int count = 0;
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == '('){
				count++;
			}else if(str.charAt(i) == ')'){
				count--;
				if(count < 0){
					return false;
				}
			}
		}
		
		return count == 0;		
	}
	
    public List<String> removeInvalidParentheses(String s) {
        if(s == null || s.length() == 0){
        	ret.add("");
        	return ret;
        }
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.add(s);
        visited.add(s);
        
        boolean found = false;
        
        while(!queue.isEmpty()){
        	String str = queue.poll();
        	if(isValid(str)){
        		found = true;
        		ret.add(str);
        	}
        	
        	if(!found){
        		for(int i = 0; i < str.length(); i++){
        			if(str.charAt(i) == '(' || str.charAt(i) == ')'){
        				StringBuilder tmp = new StringBuilder(str);
        				tmp.deleteCharAt(i);
        				if(visited.add(tmp.toString())){
        					queue.add(tmp.toString());
        				}
        			}
        		}
        	}
        	
        }
        
        return ret;        
    }
}