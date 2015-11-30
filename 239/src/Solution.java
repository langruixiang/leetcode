import java.util.Stack;

class MyStack<T>{
	private Stack<T> dataStack = new Stack<T>();
	private Stack<T> maxStack = new Stack<T>();
	
	@SuppressWarnings("unchecked")
	public void push(T x){
		dataStack.push(x);
		
		Comparable<? super T> key = (Comparable<? super T>)x;
		
		if(maxStack.isEmpty() || key.compareTo(maxStack.peek()) >= 0){
			maxStack.push(x);
		}
		
	}
	
	public T pop(){
		T tmp = dataStack.pop();
		
		if(tmp == maxStack.peek()){
			maxStack.pop();
		}
		
		return tmp;
	}
	
	public T getMax(){
		return maxStack.peek();
	}
	
	public boolean isEmpty(){
		return dataStack.isEmpty();
	}
}

class MyQueue<T>{
	private MyStack<T> inStack = new MyStack<T>();
	private MyStack<T> outStack = new MyStack<T>();
	
	public void add(T x){
		inStack.push(x);		
	}
	
	public T pop(){
		if(!outStack.isEmpty()){
			return outStack.pop();
		}else{
			while(!inStack.isEmpty()){
				T tmp = inStack.pop();
				outStack.push(tmp);
			}
			
			return outStack.pop();
		}
	}
	
	@SuppressWarnings("unchecked")
	public T getMax(){
		if(!inStack.isEmpty() && !outStack.isEmpty()){
			T inMax = inStack.getMax();
			T outMax = outStack.getMax();
			
			Comparable<? super T> inKey = (Comparable< ? super T>) inMax;
			
			if(inKey.compareTo(outMax) > 0){
				return inMax;
			}
			
			return outMax;
		}
		
		if(!inStack.isEmpty()){
			return inStack.getMax();
		}
		
		return outStack.getMax();
	}
	
	public boolean isEmpty(){
		return inStack.isEmpty() & outStack.isEmpty();
	}
}



public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    	if(nums == null || nums.length == 0){
    		return new int[0];
    	}
    	
    	MyQueue<Integer> queue = new MyQueue<Integer>();
    	
    	int[] ret = new int[nums.length - k + 1];
    	int index = 0;
    	
    	for(int i = 0; i < k; i++){
    		queue.add(nums[i]);
    	}
    	
    	ret[index++] = queue.getMax();
    	
    	for(int i = k; i < nums.length; i++){
    		queue.add(nums[i]);
    		queue.pop();
    		
    		ret[index++] = queue.getMax();
    	}
    	
    	return ret;
        
    }
}