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
	
    public List<Integer> inorderTraversal(TreeNode root) {
    	
    	TreeNode iterator = root;
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	
    	while(iterator != null || !stack.isEmpty()){
    		if(iterator == null){
    			iterator = stack.pop();
    			ret.add(iterator.val);
    			iterator = iterator.right;
    		}
    		else if(iterator.left != null){
    			stack.push(iterator);
    			iterator = iterator.left;
    		}else{
    			ret.add(iterator.val);
    			iterator = iterator.right;
    		}
    	}
    	
    	return ret;
    }
}