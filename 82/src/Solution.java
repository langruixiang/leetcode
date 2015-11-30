/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    	if(head == null){
    		return null;
    	}
    	
    	ListNode preHead = new ListNode(head.val + 1);
    	preHead.next = head;
    	
    	ListNode p = preHead;
    	ListNode q = p.next;
    	
    	while(q != null){
    		if(q.next == null){
    			return preHead.next;
    		}else if(q.next.val == q.val){
    			while(q.next != null && q.next.val == q.val){
    				q.next = q.next.next;
    			}
    			
    			p.next = q.next;
    			q = p.next;
    		}else{
    			p = q;
    			q = p.next;
    		}
    	}
    	
    	return preHead.next;
    }
}