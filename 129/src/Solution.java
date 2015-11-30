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
	private int sum = 0;
	
	private void findSum(TreeNode root, String pre){
		pre += root.val;
		
		if(root.left == null && root.right == null){
			sum += Integer.parseInt(pre);
			return ;
		}
		
		if(root.left != null){
			findSum(root.left, pre);
		}
		
		if(root.right != null){
			findSum(root.right, pre);
		}		
	}
	
    public int sumNumbers(TreeNode root) {
        if(root == null){
        	return 0;
        }
        
        findSum(root, "");
        
        return sum;
    }
}