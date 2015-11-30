import java.util.Hashtable;

public class LRUCache {
	
	class ListNode{
		int key;
		int value;
		ListNode next;
		ListNode pre;
		public ListNode(int key,int value){
			this.key = key;
			this.value = value;
		}
	}
	
	private ListNode headPre = new ListNode(0,0);
	private ListNode tailAfter = new ListNode(0,0);
	
	private Hashtable<Integer,ListNode> ht = new Hashtable<Integer,ListNode>(); 
	
	private int capacity = 0;
	private int nowCapacity = 0;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.nowCapacity = 0;
        
        headPre.next = tailAfter;
        tailAfter.pre = headPre;
    }
    
    private void putNodeToHead(ListNode tmp){
    	tmp.pre.next = tmp.next;
		tmp.next.pre = tmp.pre;
		
		tmp.next = headPre.next;
		headPre.next = tmp;
		
		tmp.next.pre = tmp;
		tmp.pre = headPre;
    }
    
    private void addNode(ListNode tmp){
    	tmp.next = headPre.next;
		headPre.next = tmp;
		
		tmp.next.pre = tmp;
		tmp.pre = headPre;
    }
    
    private void removeTail(){
    	tailAfter.pre = tailAfter.pre.pre;
    	tailAfter.pre.next = tailAfter;
    }
    
    public int get(int key) {
    	if(ht.containsKey(key)){
    		ListNode tmp = ht.get(key);
    		
    		putNodeToHead(tmp);
    		
    		return tmp.value;
    	}else{
    		return -1;
    	}
        
    }
    
    public void set(int key, int value) {
        if(ht.containsKey(key)){
        	ListNode tmp = ht.get(key);
        	tmp.value = value;
        	
        	putNodeToHead(tmp);
        }else{
        	ListNode tmp = new ListNode(key,value);
        	
        	if(nowCapacity < capacity){
        		addNode(tmp);       		
        		ht.put(key, tmp);
        		nowCapacity++;
        	}else{
        		ht.remove(tailAfter.pre.key);
        		removeTail();
        		
        		addNode(tmp);
        		ht.put(key, tmp);
        	}
        }
    }
}