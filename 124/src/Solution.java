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
	private int max = Integer.MIN_VALUE;
	private int maxcross = Integer.MIN_VALUE;
	
	private int subPathMax(TreeNode root){
		if(root.left == null && root.right == null){
			max = max > root.val ? max : root.val;
			return root.val;
		}

		int left = Integer.MIN_VALUE;
		int right = Integer.MIN_VALUE;
		
		if(root.left != null){
			left = subPathMax(root.left);
		}
		
		if(root.right != null){
			right = subPathMax(root.right);
		}
		
		if(root.left != null && root.right != null){
			maxcross = maxcross > left + right + root.val ? maxcross : left + right + root.val;
		}
		
		int maxBranch = left > right ? left : right;
		if(maxBranch > 0){
			max = max > maxBranch + root.val ? max : maxBranch + root.val;
			return maxBranch + root.val;
		}else{
			max = max > root.val ? max : root.val;
			return root.val;
		}		
	}
	
    public int maxPathSum(TreeNode root) {
    	if(root == null){
    		return 0;
    	}
        
    	subPathMax(root);
    	
    	return max > maxcross ? max : maxcross;
    }
}