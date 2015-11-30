import java.util.Stack;

class MyQueue {
	private Stack<Integer> inStack = new Stack<Integer>();
	private Stack<Integer> outStack = new Stack<Integer>();
	
    // Push element x to the back of queue.
    public void push(int x) {
    	inStack.push(x);        
    }

    // Removes the element from in front of queue.
    public void pop() {
    	if(!outStack.isEmpty()){
    		outStack.pop();
    	}else{
    		while (!inStack.isEmpty()) {
				int tmp = inStack.pop();
				outStack.push(tmp);				
			}
    		
    		outStack.pop();
    	}
        
    }

    // Get the front element.
    public int peek() {
    	if(!outStack.isEmpty()){
    		return outStack.peek();
    	}else{
    		while(!inStack.isEmpty()){
    			int tmp = inStack.pop();
    			outStack.push(tmp);    			
    		}
    		
    		return outStack.peek();
    	}
        
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return inStack.isEmpty() & outStack.isEmpty();
    }
}