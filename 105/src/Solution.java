import java.util.Hashtable;

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
	
	private TreeNode findRoot(int[] preorder,Hashtable<Integer,Integer> ht,int preleft,int preright,int inleft,int inright){
		if(preleft == preright){
			return new TreeNode(preorder[preleft]);
		}
		
		
		TreeNode ret = new TreeNode(preorder[preleft]);
		
		int rootIndex = ht.get(preorder[preleft]);
		
		int leftLength = rootIndex - inleft;
		int rightLength = inright - rootIndex;
		
		if (leftLength > 0) {
			ret.left = findRoot(preorder, ht, preleft + 1, preleft + leftLength, inleft, rootIndex - 1);
		}
		if (rightLength > 0) {
			ret.right = findRoot(preorder, ht, preleft + leftLength + 1, preleft + leftLength + rightLength,
					rootIndex + 1, inright);
		}
		return ret;
	}
	
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0){
    		return null;
    	}
    	
    	Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
    	for(int i = 0; i < inorder.length; i++){
    		ht.put(inorder[i], i);
    	}
    	
    	return findRoot(preorder, ht, 0, preorder.length - 1, 0, inorder.length - 1);        
    }
}