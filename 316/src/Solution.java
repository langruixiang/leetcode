import java.util.Stack;

public class Solution {
    public String removeDuplicateLetters(String s) {
    	if(s == null || s.length() <= 1){
    		return s;
    	}
    	
    	int[] count = new int[26];
    	boolean[] inRes = new boolean[26];
    	for(int i = 0; i < s.length(); i++){
    		count[s.charAt(i) - 'a']++;
    	}
    	
    	Stack<Character> stack = new Stack<Character>();
    	for(int i = 0; i < s.length(); i++){
    		int index  = s.charAt(i) - 'a';
    		if(!inRes[index]){
    			while(!stack.isEmpty() && s.charAt(i) < stack.peek() && count[stack.peek() - 'a'] > 1){
        			count[stack.peek() - 'a']--;
        			inRes[stack.peek() - 'a'] = false;
        			stack.pop();
        		}
        		stack.push(s.charAt(i));
        		inRes[index] = true;
    		}else{
    			count[index]--;
    		}
    	}
    	
    	StringBuilder ret = new StringBuilder();
    	while(!stack.isEmpty()){
    		ret.append(stack.pop());
    	}
    	
    	return ret.reverse().toString();        
    }
}