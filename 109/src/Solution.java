/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	
	private TreeNode findRoot(ListNode head,int len){
		if(len == 0){
			return null;
		}
		
		if(len == 1){
			return new TreeNode(head.val);
		}
		
		
		ListNode iterator = head;
		
		int steps = 0;
		if(len % 2 == 0){
			steps = len / 2;
		}else{
			steps = (len + 1) / 2;
		}
		
		for(int i = 0; i < steps - 1; i++){
			iterator = iterator.next;
		}
		
		TreeNode root = new TreeNode(iterator.val);
		root.left = findRoot(head, (len - 1) / 2);
		root.right = findRoot(iterator.next, len / 2);
		
		return root;
	}
	
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
        	return null;
        }
        
        int counter = 0;
        ListNode iterator = head;
        while(iterator != null){
        	counter++;
        	iterator = iterator.next;
        }
        
        return findRoot(head, counter);
    }
}