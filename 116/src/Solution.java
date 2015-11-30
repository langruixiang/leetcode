/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
    	TreeLinkNode level = root;
    	if(level == null){
    		return ;
    	}
    	
    	while(level.left != null){
    		TreeLinkNode iterator = level;
    		
    		while(true){
    			iterator.left.next = iterator.right;
        		if(iterator.next != null){
        			iterator.right.next = iterator.next.left;
        		}else{
        			break;
        		}
        		iterator = iterator.next;
    		}
    		level = level.left;
    	}        
    }
}