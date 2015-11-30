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
	
	private boolean checkPath(TreeNode root, int sum){
		if(root.left == null && root.right == null && sum - root.val == 0){
			return true;
		}
		
		if(root.left != null && root.right == null){
			return checkPath(root.left, sum - root.val);
		}
		
		if(root.right != null && root.left == null){
			return checkPath(root.right, sum - root.val);
		}
		
		if(root.left != null && root.right != null){
			return checkPath(root.left, sum - root.val) | checkPath(root.right, sum - root.val);
		}
		
		return false;
	}
	
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root == null){
    		return false;
    	}
    	
    	return checkPath(root, sum);
    }
}