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
	private List<String> ret = new ArrayList<String>();
	
	private void addPath(TreeNode root,List<TreeNode> pre){
		if(root.left == null && root.right == null){
			pre.add(root);
			
			StringBuilder res = new StringBuilder("");
			res.append(pre.get(0).val);
			
			for(int i = 1; i < pre.size(); i++){
				res.append("->");
				res.append(pre.get(i).val);
			}
			
			ret.add(new String(res));
			
			pre.remove(pre.size() - 1);
			
		}else{
			pre.add(root);
			
			if(root.left != null){
				addPath(root.left, pre);
			}
			
			if(root.right != null){
				addPath(root.right, pre);
			}
			
			pre.remove(pre.size() - 1);
		}
	}
	
    public List<String> binaryTreePaths(TreeNode root) {
    	if(root == null){
    		return ret;
    	}
    	
    	List<TreeNode> pre = new ArrayList<TreeNode>();
    	
    	addPath(root, pre);
    	
    	return ret;        
    }
}