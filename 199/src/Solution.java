import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
	private List<TreeNode> queue1 = new LinkedList<TreeNode>();
	private List<TreeNode> queue2 = new LinkedList<TreeNode>();
	
    public List<Integer> rightSideView(TreeNode root) {
    	List<TreeNode> father = queue1;
    	List<TreeNode> son = queue2;
    	
    	List<Integer> ret = new ArrayList<Integer>();
    	
    	if(root != null){
    		father.add(root);
    	}
    	
    	while(!father.isEmpty()){
    		ret.add(father.get(father.size() - 1).val);
    		
    		for(TreeNode iterator : father){
    			if(iterator.left != null){
    				son.add(iterator.left);
    			}
    			
    			if(iterator.right != null){
    				son.add(iterator.right);
    			}
    		}
    		
    		father.clear();
    		
    		List<TreeNode> tmp = father;
    		father = son;
    		son = tmp;    		
    	}
    	
    	return ret;
        
    }
}