/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	private int length(ListNode head){
		int counter = 0;
		ListNode iterator = head;
		while(iterator != null){
			counter++;
			iterator = iterator.next;
		}
		
		return counter;
	}
	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	int lenA = length(headA);
    	int lenB = length(headB);
    	
    	if(lenA == 0 || lenB == 0){
    		return null;
    	}
    	
    	ListNode iteratorA = headA;
    	ListNode iteratorB = headB;
    	
    	if(lenA < lenB){
    		for(int i = 0; i < lenB - lenA; i++){
    			iteratorB = iteratorB.next;    					
    		}
    	}else{
    		for(int i = 0; i < lenA - lenB; i++){
    			iteratorA = iteratorA.next;
    		}
    	}
    	
    	while(iteratorA != iteratorB){
    		iteratorA = iteratorA.next;
    		iteratorB = iteratorB.next;
    	}
    	
        return iteratorA;
    }
}