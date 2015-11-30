/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        
        ListNode l,m,n;
        
        l = preHead;
        
        while (true) {
			m = l.next;
			if (m == null) {
				return preHead.next;
			}
			n = m.next;
			if (n == null) {
				return preHead.next;
			}
			m.next = n.next;
			l.next = n;
			n.next = m;
			l = l.next.next;
		}
    }
}