import java.util.Iterator;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator<T> implements Iterator<T> {

	private Iterator<T> iterator;
	private boolean peeked = false;
	private T peek = null;
	
	public PeekingIterator(Iterator<T> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public T peek() {
		if(!peeked){
			peek = iterator.next();
			peeked = true;
		}
		
		return peek;
        
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public T next() {
		if(peeked){
			peeked = false;
			return peek;
		}else{
			return iterator.next();
		}
	    
	}

	@Override
	public boolean hasNext() {
		if(!peeked){
			return iterator.hasNext();
		}else{
			return true;
		}	    
	}
}