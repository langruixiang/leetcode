/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	ListNode preHead = new ListNode(0);
    	preHead.next = head;
        
    	ListNode iterator = preHead;
    	
    	ListNode l = null;
    	ListNode p = null;
    	ListNode q = null;
    	
    	for(int i = 0; i < m - 1; i++){
    		iterator = iterator.next;
    	}
    	
    	l = iterator;
    	p = l.next;
    	
    	for(int i = 0; i < n - m + 1; i++){
    		iterator = iterator.next;
    	}
    	
    	q = iterator;
    	
    	for(int i = 0; i < n - m; i++){
    		l.next = p.next;
    		p.next = q.next;
    		q.next = p;
    		
    		p = l.next;
    	}
    	
    	return preHead.next;
    }
}