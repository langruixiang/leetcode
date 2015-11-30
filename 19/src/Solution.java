/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode headTmp = new ListNode(0);
    	headTmp.next = head;
    	
        ListNode iterator1 = headTmp;
        ListNode iterator2 = headTmp;
        
        for(int i = 0; i < n; i++){
        	iterator1 = iterator1.next;
        }
        
        while(iterator1.next != null){
        	iterator1 = iterator1.next;
        	iterator2 = iterator2.next;
        }
        
        iterator2.next = iterator2.next.next;
        
        return headTmp.next;
    }
}