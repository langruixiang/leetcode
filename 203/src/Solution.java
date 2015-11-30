/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
    	ListNode preHead = new ListNode(0);
    	preHead.next = head;
    	
    	ListNode p1 = preHead;
    	ListNode p2 = p1.next;
    	
    	while(p2 != null){
    		if(p2.val == val){
    			p1.next = p2.next;
    			p2 = p2.next;
    		}else{
    			p2 = p2.next;
    			p1 = p1.next;
    		}
    	}
        
    	return preHead.next;
    }
}