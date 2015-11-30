/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
    	ListNode preHead = new ListNode(0);
    	preHead.next = head;
    	
    	ListNode fast = preHead;
    	ListNode slow = preHead;
    	
    	while(fast != null){
    		fast = fast.next;
    		if(fast == null){
    			return null;
    		}    		
    		fast = fast.next;
    		
    		slow = slow.next;
    		
    		if(fast == slow){
    			fast = preHead;
    			while(fast != slow){
    				fast = fast.next;
    				slow = slow.next;
    			}
    			
    			return fast;
    		}
    	}
    	
    	return null;

    }
}