import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
	private List<List<Integer>> ret = new ArrayList<List<Integer>>();
    
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if(root == null){
			return ret;
		}
		
    	List<TreeNode> list1 = new ArrayList<TreeNode>();
    	List<TreeNode> list2 = new ArrayList<TreeNode>();
    	
    	list1.add(root);
    	
    	List<TreeNode> father = list1;
    	List<TreeNode> son = list2;
    	
    	int counter = 0;
    	
    	while(father.size() != 0){
    		List<Integer> res = new ArrayList<Integer>();
    		
    		if(counter % 2 == 1){
    			List<TreeNode> reverse = new ArrayList<>();
    			reverse.addAll(father);
    			Collections.reverse(reverse);
    			for(int i = 0; i < reverse.size(); i++){
    				res.add(reverse.get(i).val);
    			}
    		}   		
    		
    		for(int i = 0; i < father.size(); i++){
    			TreeNode iterator = father.get(i);
    			if(counter % 2 == 0){
    				res.add(iterator.val);
    			}
    			if(iterator.left != null){
    				son.add(father.get(i).left);
    			}
    			if(iterator.right != null){
    				son.add(father.get(i).right);
    			}    			
    		}
    		
    		ret.add(res);
    		father.clear();
    		
    		List<TreeNode> tmp = father;
    		father = son;
    		son = tmp;
    		
    		counter++;
    	}
    	
    	return ret;        
    }
}