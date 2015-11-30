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

	private boolean isSym(TreeNode root1,TreeNode root2){
		if(root1 == null && root2 == null){
			return true;
		}
		
		if(root1 == null && root2 != null ||
		   root1 != null && root2 == null){
			return false;
		}
		
		if(root1.val != root2.val){
			return false;
		}
		
		return (isSym(root1.left, root2.right) & isSym(root1.right, root2.left));
		
	}
	
    public boolean isSymmetric(TreeNode root) {
    	if(root == null){
    		return true;
    	}
    	
    	return isSym(root.left, root.right);
        
    }
}