/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
    	if(head == null){
    		return null;
    	}
    	
    	int len = 0;
    	ListNode tmp = head;
    	while(tmp != null){
    		len++;
    		tmp = tmp.next;
    	}
    	
    	k = k % len;
    	
    	if(k == 0){
    		return head;
    	}
    	
    	ListNode preHead = new ListNode(0);
    	preHead.next = head;
    	
    	ListNode p = preHead;
    	ListNode q = preHead;
    	
    	for(int i = 0; i < k; i++){
    		q = q.next;
    	}
    	
    	while(q.next != null){
    		p = p.next;
    		q = q.next;
    	}
    	
    	
    	q.next = preHead.next;
    	preHead.next = p.next;
    	p.next = null;
    	
    	return preHead.next;        
    }
}