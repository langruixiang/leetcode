/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	private ListNode mergeTwoLists(ListNode l1, ListNode l2){
		if(l1 == null){
			return l2;
		}else if(l2 == null){
			return l1;
		}
		
		ListNode ret;
		
		if(l1.val <= l2.val){
			ret = l1;
			ret.next = mergeTwoLists(l1.next, l2);
		}else{
			ret = l2;
			ret.next = mergeTwoLists(l1, l2.next);
		}
		
		return ret;
	}
	
	
    public ListNode mergeKLists(ListNode[] lists) {
    	if(lists.length == 0){
    		return null;
    	}else if(lists.length == 1){
    		return lists[0];
    	}
    	
    	ListNode[] newlists = new ListNode[(lists.length - 1) / 2 + 1];
    	for(int i = 0; i < lists.length; i += 2){
    		if(i + 1 < lists.length){
    			newlists[i / 2] = mergeTwoLists(lists[i], lists[i + 1]);
    		}else{
    			newlists[i / 2] = lists[i];
    		}
    	}
    	
    	ListNode ret = mergeKLists(newlists);
    	
    	return ret;
        
    }
}