import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    // Push element x onto stack.
	private Queue<Integer> q1 = new LinkedList<Integer>();
	private Queue<Integer> q2 = new LinkedList<Integer>();
	
	private Queue<Integer> outQueue = q1;
	private Queue<Integer> inQueue = q2;
	
    public void push(int x) {
        outQueue.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
    	while(outQueue.size() > 1){
    		int tmp = outQueue.poll();
    		inQueue.add(tmp);
    	}
    	
    	outQueue.poll();
    	
    	Queue<Integer> tmp = outQueue;
    	outQueue = inQueue;
    	inQueue = tmp;        
    }

    // Get the top element.
    public int top() {
    	while(outQueue.size() > 1){
    		int tmp = outQueue.poll();
    		inQueue.add(tmp);
    	}
    	
    	return outQueue.peek();
        
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return outQueue.isEmpty() & inQueue.isEmpty();
    }
}