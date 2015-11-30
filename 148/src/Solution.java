/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	private ListNode mergerSort(ListNode head,int len){
		if(len == 1){
			head.next = null;
			return head;
		}
		
		ListNode iterator = head;
		for(int i = 0; i < len / 2; i++){
			iterator = iterator.next;
		}
		
		ListNode left = mergerSort(head, len / 2);
		ListNode right  = mergerSort(iterator, (len + 1) / 2);
		
		ListNode pre = new ListNode(0);
		ListNode last = pre;

		while(left != null && right != null){
			if(left.val < right.val){
				last.next = left;
				last = left;
				left = left.next;
			}else{
				last.next = right;
				last = right;
				right = right.next;
			}
		}
		
		if(left != null){
			last.next = left;
		}else{
			last.next = right;
		}
		
		return pre.next;
	}
	
    public ListNode sortList(ListNode head) {
    	if(head == null){
    		return null;
    	}
        
    	int len = 0;
    	ListNode iterator = head;
    	while(iterator != null){
    		len++;
    		iterator = iterator.next;
    	}
    	
    	return mergerSort(head, len);
    }
}