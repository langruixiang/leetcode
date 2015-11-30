import java.util.Stack;

class MinStack {
	Stack<Integer> contentStack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	
    public void push(int x) {
    	contentStack.push(x);
    	
    	if(minStack.isEmpty() || x <= minStack.peek()){
    		minStack.push(x);
    	}        
    }

    public void pop() {
    	if(contentStack.peek().equals(minStack.peek())){
    		minStack.pop();
    	}
        
    	contentStack.pop();
    }

    public int top() {
        return contentStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
