/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	private int getLength(ListNode head){
		int counter = 0;
		ListNode iterator = head;
		while(iterator != null){
			counter++;
			iterator = iterator.next;
		}
		
		return counter;
	}
	
	private ListNode reverseList(ListNode head){
		ListNode preHead = new ListNode(0);
		preHead.next = head;
		
		ListNode p1 = head;
		ListNode p2 = p1.next;
		
		head.next = null;
		
		p1 = p2;
		if(p2 != null){
			p2 = p2.next;
		}
		
		while(p1 != null){
			p1.next = preHead.next;
			preHead.next = p1;
			
			p1 = p2;
			if(p2 != null){
				p2 = p2.next;
			}
			
		}
		
		return preHead.next;
	}
	
    public boolean isPalindrome(ListNode head) {
    	int len = getLength(head);
    	if(len <= 1){
    		return true;
    	}
    	
    	ListNode p1 = head;
    	ListNode p2 = p1;
    	for(int i = 0; i < (len + 1) / 2; i++){
    		p2 = p2.next;
    	}
    	
    	p2 = reverseList(p2);
    	
    	while(p2 != null){
    		if(p1.val != p2.val){
    			return false;
    		}
    		
    		p1 = p1.next;
    		p2 = p2.next;
    	}
        
    	return true;
    }
}