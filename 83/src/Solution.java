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
        
        ListNode p = head;
        ListNode q = head.next;
        
        while (q != null) {
			while (q != null && q.val == p.val) {
				q = q.next;
			}
			if (q == null) {
				p.next = null;
			} else {
				p.next = q;
				p = q;
				q = p.next;
			} 
		}
        
        return head;
    }
}