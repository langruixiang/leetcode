import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//import java.util.Stack;
//
///**
// * Definition for a binary tree node.
// * public class TreeNode {
// *     int val;
// *     TreeNode left;
// *     TreeNode right;
// *     TreeNode(int x) { val = x; }
// * }
// */
//public class Solution {
//	private List<Integer> ret = new ArrayList<Integer>();
//	private Set<TreeNode> visited = new HashSet<TreeNode>();
//	
//    public List<Integer> postorderTraversal(TreeNode root) {
//    	Stack<TreeNode> stack = new Stack<TreeNode>();
//    	
//    	TreeNode iterator = root;
//    	while(iterator != null){
//    		if(visited.contains(iterator)){
//    			ret.add(iterator.val);
//    			if(!stack.isEmpty()){
//    				iterator = stack.pop();
//    			}else{
//    				return ret;
//    			}
//    			continue;
//    		}
//    		
//    		if(iterator.left == null && iterator.right == null){
//    			ret.add(iterator.val);
//    			if(!stack.isEmpty()){
//    				iterator = stack.pop();
//    			}else{
//    				return ret;
//    			}
//    		}else if(iterator.left != null && iterator.right == null){
//    			stack.push(iterator);    			
//    			visited.add(iterator);
//    			iterator = iterator.left;
//    		}else if(iterator.right != null && iterator.left == null){
//    			stack.push(iterator);
//    			visited.add(iterator);
//    			iterator = iterator.right;
//    		}else{
//    			stack.push(iterator);
//    			stack.push(iterator.right);
//    			visited.add(iterator);
//    			iterator = iterator.left;
//    		}
//    	}
//    	
//    	return ret;        
//    }
//}

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
	
    public List<Integer> postorderTraversal(TreeNode root) {
    	if(root == null){
    		return ret;
    	}
    	
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	
    	TreeNode pre = new TreeNode(0);
    	TreeNode iterator = root;
    	while(true){
    		if(iterator.left == null && iterator.right == null || pre == iterator.left || pre == iterator.right){
    			ret.add(iterator.val);
    			pre = iterator;
    			if(stack.isEmpty()){
    				return ret;
    			}else{
    				iterator = stack.pop();
    			}
    		}else{
    			if(iterator.left != null && iterator.right != null){
    				stack.push(iterator);
    				stack.push(iterator.right);
    				iterator = iterator.left;
    			}else {
    				stack.push(iterator);
    				iterator = iterator.left != null ? iterator.left : iterator.right;
    			}
    		}
    	}        
    }
}