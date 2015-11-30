import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
    	if(path == null){
    		return null;
    	}
    	
    	if(path.length() == 0){
    		return "";
    	}
    	
    	String[] items = path.split("/");
    	
    	Stack<String> stack = new Stack<>();
    	for(int i = 0; i < items.length; i++){
    		if(items[i].equals("")){
    			continue;
    		}else if(items[i].equals(".")){
    			continue;
    		}else if(items[i].equals("..")){
    			if(!stack.isEmpty()){
    				stack.pop();
    			}
    		}else{
    			stack.push(items[i]);
    		}
    	}
    	
    	String ret = "";
    	if(stack.isEmpty()){
    		return "/";
    	}
    	
    	while(!stack.isEmpty()){
    		ret = "/" + stack.peek() + ret;
    		stack.pop();
    	}
        
    	return ret;
    }
}