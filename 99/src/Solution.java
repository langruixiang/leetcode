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
	private TreeNode mistake1 = null;
	private TreeNode mistake2 = null;
	private TreeNode pre = null;
	
	private void findMistake(TreeNode root){
		if(root.left != null){
			findMistake(root.left);
		}
		
		if(pre != null && root.val < pre.val){
			if(mistake1 == null){
				mistake1 = pre;
				mistake2 = root;
			}else{
				mistake2 = root;
			}
		}
		
		pre = root;
		if(root.right != null){
			findMistake(root.right);
		}		
	}
	
    public void recoverTree(TreeNode root) {
    	if(root == null){
    		return ;
    	}
    	
    	findMistake(root);
    	
    	int tmp = mistake1.val;
    	mistake1.val = mistake2.val;
    	mistake2.val = tmp;
    	
    	return ;
    }
}