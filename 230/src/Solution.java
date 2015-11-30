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
	private int counter = 0;
	private int ret = 0;
	
	private boolean find(TreeNode root,int k){
		if(root == null){
			return false;
		}
		
		if(!find(root.left, k)){
			counter++;
			if(counter == k){
				ret = root.val;
				return true;
			}
			
			return find(root.right, k);
		}
		
		return true;		
	}
	
    public int kthSmallest(TreeNode root, int k) {
    	find(root, k);
    	
    	return ret;        
    }
}