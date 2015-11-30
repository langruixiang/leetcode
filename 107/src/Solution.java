import java.util.ArrayList;
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
	
	private void levelreverse(List<TreeNode> fatherLevel){
		if(fatherLevel.size() == 0){
			return ;
		}
		
		List<Integer> resFather = new ArrayList<Integer>();
		
		List<TreeNode> sonLevel = new ArrayList<TreeNode>();
		
		for(int i = 0; i < fatherLevel.size(); i++){
			TreeNode iterator = fatherLevel.get(i);
			
			resFather.add(iterator.val);
			
			if(iterator.left != null){
				sonLevel.add(iterator.left);
			}
			
			if(iterator.right != null){
				sonLevel.add(iterator.right);
			}
		}
		levelreverse(sonLevel);
		
		ret.add(resFather);
	}
	
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	if(root == null){
    		return ret;
    	}
    	
    	List<TreeNode> list = new ArrayList<TreeNode>();
    	list.add(root);
    	
    	levelreverse(list);
    	
    	return ret;        
    }
}