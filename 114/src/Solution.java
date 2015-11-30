import java.util.Stack;

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
    public void flatten(TreeNode root) {
    	if(root == null){
    		return ;
    	}
    	
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	
    	TreeNode iterator = root;
    	while(true){
    		if(iterator.left != null){
    			if(iterator.right != null){
    				stack.push(iterator.right);
    			}
    			
    			iterator.right = iterator.left;
    			iterator.left = null;
    			iterator = iterator.right;
    		}else{
    			if(iterator.right != null){
    				iterator = iterator.right;
    			}else{
    				if(stack.isEmpty()){
    					return ;
    				}
    				
    				iterator.right = stack.pop();
    				iterator = iterator.right;
    			}
    		}
    	}
        
    }
}


//public class Solution {
//	private TreeNode flattenTree(TreeNode root){
//		if(root.left != null && root.right != null){		
//			TreeNode ret = flattenTree(root.left);
//            ret.right = root.right;
//            
//            root.right = root.left;
//            root.left = null;
//			
//			return flattenTree(ret.right);
//		}else if(root.left == null && root.right != null){
//			return flattenTree(root.right);
//		}else if(root.left != null && root.right == null){
//			root.right = root.left;
//			root.left = null;
//			return flattenTree(root.right);
//		}else{
//			return root;
//		}
//	}
//	
//    public void flatten(TreeNode root) {
//    	if(root == null){
//    		return ;
//    	}
//    	flattenTree(root);    	
//    }
//}