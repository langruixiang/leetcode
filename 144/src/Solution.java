import java.util.ArrayList;
import java.util.List;
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
	private List<Integer> ret = new ArrayList<Integer>();
	
    public List<Integer> preorderTraversal(TreeNode root) {
    	if(root == null){
    		return ret;
    	}    	
    	
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty()){
        	TreeNode iteraotr = stack.pop();
        	ret.add(iteraotr.val);
        	
        	if(iteraotr.right != null){
        		stack.push(iteraotr.right);
        	}
        	
        	if(iteraotr.left != null){
        		stack.push(iteraotr.left);
        	}        	
        }
        
        return ret;
    }
}