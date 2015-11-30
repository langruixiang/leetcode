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
	
	private TreeNode findRoot(Hashtable<Integer,Integer> ht, int[] postorder,int inorderleft,int inorderright,int postorderleft,int postorderright){
		TreeNode ret = new TreeNode(postorder[postorderright]);
		
		int index = ht.get(postorder[postorderright]);
		
		int leftLength = index - inorderleft;
		int rightLength = inorderright - index;
		
		if(rightLength > 0){
		   ret.right = findRoot(ht, postorder, index + 1, inorderright, postorderright - rightLength, postorderright - 1);	
		}
		
		if(leftLength > 0){
			ret.left = findRoot(ht, postorder, inorderleft, index - 1, postorderleft - rightLength - leftLength, postorderright - rightLength - 1);
		}
		
		return ret;
	}
	
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0){
    		return null;
    	}
    	
    	Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
    	
    	for(int i = 0; i < inorder.length; i++){
    		ht.put(inorder[i], i);
    	}
    	
    	return findRoot(ht, postorder, 0, inorder.length - 1, 0 , postorder.length - 1);        
    }
}