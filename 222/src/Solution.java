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
	private int getLeftHeight(TreeNode root){
		int ret = 0;
		
		TreeNode iterator = root;
		while(iterator != null){
			ret++;
			iterator = iterator.left;
		}
		
		return ret;			
	}
	
	private int getRightHeight(TreeNode root){
        int ret = 0;
		
		TreeNode iterator = root;
		while(iterator != null){
			ret++;
			iterator = iterator.right;
		}
		
		return ret;	
	}
	
    public int countNodes(TreeNode root) {
    	if(root == null){
    		return 0;
    	}
    	
    	int left = getLeftHeight(root);
    	int right = getRightHeight(root);
    	
    	if(left == right){
    		return (1 << left) - 1;
    	}else{
    		return countNodes(root.left) + countNodes(root.right) + 1;
    	}
        
    }
}