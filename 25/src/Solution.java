/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        
        ListNode nextHead = preHead;
        
        if(k <= 1){
        	return head;
        }
        
        while (true) {
			ListNode l = nextHead;

			ListNode n = l;
			for (int i = 0; i < k; i++) {
				n = n.next;
				if (n == null) {
					return preHead.next;
				}
			}
			
			ListNode m = l.next;
			l.next = m.next;
			
			m.next = n.next;
			n.next = m;
			
			nextHead = m;
			
			for (int i = 1; i < k - 1; i++) {
				m = l.next;
				l.next = m.next;

				m.next = n.next;
				n.next = m;
			}
		}
    }
}