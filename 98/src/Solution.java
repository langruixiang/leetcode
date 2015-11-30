/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//public class Solution {
//	private boolean isValid(TreeNode root,long min,long max){
//		if(root == null){
//			return true;
//		}
//		
//		if(root.val <= min || root.val >= max){
//			return false;
//		}
//		
//		if(root.left != null && root.left.val >= root.val){
//			return false;
//		}
//		
//		if(root.right != null && root.right.val <= root.val){
//			return false;
//		}
//		
//		if(!isValid(root.left, min, root.val)){
//			return false;
//		}
//		
//		if(!isValid(root.right, root.val, max)){
//			return false;
//		}
//		
//		return true;
//	}
//	
//    public boolean isValidBST(TreeNode root) {  
//    	return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
//    }
//}

public class Solution {
	private long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {  
    	if(root == null){
    		return true;
    	}
    	
    	if(!isValidBST(root.left)){
    		return false;
    	}
    	
    	if(root.val <= pre){
    		return false;
    	}
    	
    	pre = root.val;
    	
    	if(!isValidBST(root.right)){
    		return false;
    	}
    	
    	return true;
    }
}