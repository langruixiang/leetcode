/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
    	ListNode p = head;
    	if(p == null){
    		return null;
    	}
    	ListNode q = head.next;
    	
    	ListNode beforeHead = new ListNode(0);
    	ListNode beforeTail = beforeHead;
    	
    	ListNode afterHead = new ListNode(0);
    	ListNode afterTail = afterHead;
    	
    	while(q != null){
    		p.next = null;
    		if(p.val < x){
    			beforeTail.next = p;    			
    			beforeTail = beforeTail.next;
    		}else{
    			afterTail.next = p;    			
    			afterTail = afterTail.next;
    		}
    		
    		p = q;
    		q = q.next;    	
    	}
        
    	p.next = null;
    	if(p.val < x){
			beforeTail.next = p;
			beforeTail = beforeTail.next;
		}else{
			afterTail.next = p;
			afterTail = afterTail.next;
		}
    	
    	beforeTail.next = afterHead.next;
    	
    	return beforeHead.next;
    }
}