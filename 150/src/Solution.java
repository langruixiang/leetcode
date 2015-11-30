import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
    	if(tokens == null || tokens.length == 0){
    		return 0;
    	}
    	
    	Stack<Integer> stack = new Stack<Integer>();
    	for(int i = 0; i < tokens.length; i++){
    		if(tokens[i].equals("+")){
    			int operand2 = stack.pop();
    			int operand1 = stack.pop();
    			int res = operand1 + operand2;
    			stack.push(res);    			
    		}else if(tokens[i].equals("-")){
    			int operand2 = stack.pop();
    			int operand1 = stack.pop();
    			int res = operand1 - operand2;
    			stack.push(res);
    			
    		}else if(tokens[i].equals("*")){
    			int operand2 = stack.pop();
    			int operand1 = stack.pop();
    			int res = operand1 * operand2;
    			stack.push(res);
    			
    		}else if(tokens[i].equals("/")){
    			int operand2 = stack.pop();
    			int operand1 = stack.pop();
    			int res = operand1 / operand2;
    			stack.push(res);
    			
    		}else{
    			stack.push(Integer.parseInt(tokens[i]));
    		}
    	}
    	
        return stack.pop();
    }
}