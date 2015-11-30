import java.util.Hashtable;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
	private Hashtable<RandomListNode,RandomListNode> ht = new Hashtable<RandomListNode,RandomListNode>(); 
	
    public RandomListNode copyRandomList(RandomListNode head) {
    	if(head == null){
    		return null;
    	}
    	
    	if(ht.containsKey(head)){
    		return ht.get(head);
    	}
    	
    	RandomListNode ret = new RandomListNode(head.label);
    	ht.put(head, ret);
    	ret.next = copyRandomList(head.next);
    	ret.random = copyRandomList(head.random);
    	
    	return ret;        
    }
}