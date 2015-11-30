/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
    	if(head == null || head.next == null){
    		return head;
    	}
    	
    	ListNode pre = new ListNode(0);
    	
    	ListNode p = head;
    	ListNode q = p.next;
    	while(p != null){
    		ListNode l = pre;
    		while(l.next != null && l.next.val < p.val){
    			l = l.next;
    		}
    		p.next = l.next;
    		l.next = p;
    		
    		p = q;
    		if(p != null){
    			q = p.next;
    		}
    	}
    	
    	return pre.next;        
    }
}