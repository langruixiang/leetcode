import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
    	ListNode iterator = head;
    	int counter = 0;
    	while(iterator != null){
    		counter++;
    		iterator = iterator.next;
    	}
    	
    	if(counter <= 2){
    		return ;
    	}
    	
    	Stack<ListNode> stack = new Stack<ListNode>();
    	iterator = head;
    	for(int i = 0; i < counter / 2; i++){    		
    		stack.push(iterator);
    		iterator = iterator.next;
    	}
    	
    	ListNode nextIterator = iterator.next;
    	if(counter % 2 == 1){
    		iterator.next = null;
    		iterator = nextIterator;
    	}else{
    		stack.pop();
    		iterator.next = null;
    		iterator = nextIterator;
    	}
    	
    	while(!stack.isEmpty()){
    		nextIterator = iterator.next;
    		ListNode top = stack.pop();
    		iterator.next = top.next;
    		top.next = iterator;
    		iterator = nextIterator;
    	}
        
    }
}