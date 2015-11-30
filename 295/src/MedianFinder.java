import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//import java.util.ArrayList;
//import java.util.List;
//
//class MedianFinder {
//	private List<Integer> array = new ArrayList<Integer>();
//
//    private int findPosition(int num, int left, int right){    	
//    	if(right < left){
//    		return left;
//    	}
//    	
//    	int mid = left + (right - left) / 2;
//    	if(array.get(mid) == num){
//    		return mid;
//    	}else if(array.get(mid) < num){
//    		return findPosition(num, mid + 1, right);
//    	}else{
//    		return findPosition(num, left, mid - 1);
//    	}
//    }
//	
//	// Adds a number into the data structure.
//    public void addNum(int num) {
//    	int index = findPosition(num, 0, array.size() - 1);
//    	array.add(index, num);        
//    }
//
//    // Returns the median of current data stream
//    public double findMedian() {
//    	System.out.println(array.toString());
//    	
//    	int size = array.size();
//    	int mid = size / 2;
//    	
//    	if(size % 2 == 1){
//    		return array.get(mid);
//    	}else{
//    		return (array.get(mid) + array.get(mid - 1)) / 2.0;
//    	}
//        
//    }
//};
//
//// Your MedianFinder object will be instantiated and called as such:
//// MedianFinder mf = new MedianFinder();
//// mf.addNum(1);
//// mf.findMedian();

class MedianFinder {
	private int size = 0;
	private Queue<Integer> firstQueue = new PriorityQueue<>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2 - o1;
		}
		
	});
	
	private Queue<Integer> lastQueue = new PriorityQueue<>();
	

    // Adds a number into the data structure.
    public void addNum(int num) {
    	size++;
    	
    	if(firstQueue.isEmpty() || num < firstQueue.peek()){
    		firstQueue.add(num);
    		if(size % 2 == 0 && firstQueue.size() > size / 2 ||
    				size % 2 == 1 && firstQueue.size() > (size + 1) / 2){
    			int tmp = firstQueue.poll();
    			lastQueue.add(tmp);
    		}
    		    		
    	}else{
    		lastQueue.add(num);
    		if(lastQueue.size() > size / 2){
    			int tmp = lastQueue.poll();
    			firstQueue.add(tmp);
    		}
    		
    	}
        
    }

    // Returns the median of current data stream
    public double findMedian() {
    	if(size % 2 == 0){
    		return (firstQueue.peek() + lastQueue.peek()) / 2.0;
    	}
    	
    	return firstQueue.peek();
        
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();