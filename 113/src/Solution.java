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
	
	private void findPath(TreeNode root, int sum, List<Integer> pre){
		pre.add(root.val);
		
		if(root.left == null && root.right == null && sum - root.val == 0){
			List<Integer> res = new ArrayList<Integer>();
			res.addAll(pre);
			ret.add(res);
		}else if(root.left != null && root.right == null){
			findPath(root.left, sum - root.val, pre);
		}else if(root.right != null && root.left == null){
			findPath(root.right, sum - root.val, pre);
		}else if(root.left != null && root.right != null){
			findPath(root.left, sum - root.val, pre);			
			findPath(root.right, sum - root.val, pre);			
		}
		
		pre.remove(pre.size() - 1);
		return ;		
	}
	
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
        	return ret;
        }
        
        List<Integer> pre = new ArrayList<Integer>();
        findPath(root, sum, pre);
        
        return ret;
    }
}