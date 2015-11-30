public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode head = null;
    	ListNode resultIterator;
    	
    	ListNode num1 = l1;
    	ListNode num2 = l2;
    	
    	int bit = 0;
    	int sum = 0;
    	
    	sum = num1.val + num2.val;
    	bit = sum > 9 ? 1 : 0;
    	sum = sum % 10;
    	
    	head = new ListNode(sum);    	
    	resultIterator = head;
    	
    	num1 = num1.next;
    	num2 = num2.next;
    	
    	while(num1 != null && num2 != null){
    		sum = num1.val + num2.val + bit;
    		
    		bit = sum > 9 ? 1 : 0;
    		
    		sum = sum % 10;
    		
    		resultIterator.next = new ListNode(sum);
    		resultIterator = resultIterator.next;
    		
    		num1 = num1.next;
    		num2 = num2.next;
    	}
    	
    	while(num1 != null){
    		sum = num1.val + 0 + bit;
    		
    		bit = sum > 9 ? 1 : 0;
    		
    		sum = sum % 10;
    		
    		resultIterator.next = new ListNode(sum);
    		resultIterator = resultIterator.next;
    		
    		num1 = num1.next;
    	}
    	
    	while(num2 != null){
            sum = num2.val + 0 + bit;
    		
    		bit = sum > 9 ? 1 : 0;
    		
    		sum = sum % 10;
    		
    		resultIterator.next = new ListNode(sum);
    		resultIterator = resultIterator.next;
    		
    		num2 = num2.next;
    	}
    	
    	if(bit != 0){
    		resultIterator.next = new ListNode(bit);
    		resultIterator = resultIterator.next;
    	}
    	
    	return head;        
    }
}