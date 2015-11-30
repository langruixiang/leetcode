import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
	private Queue<Integer> queue = new LinkedList<Integer>();
	private Stack<TreeNode> stack = new Stack<TreeNode>();
	

    public BSTIterator(TreeNode root) {
    	TreeNode iterator = root;
    	while(iterator != null){
    		stack.push(iterator);
    		iterator = iterator.left;
    	}
        
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	if(!stack.isEmpty()){
    		TreeNode iterator = stack.pop();
    		queue.add(iterator.val);
    		
    		iterator = iterator.right;
    		while(iterator != null){
    			stack.push(iterator);
    			iterator = iterator.left;
    		}
    	}
    	
    	return !queue.isEmpty();        
    }

    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */