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
	
	private TreeNode findRoot(int[] nums,int left,int right){
		if(right < left){
			return null;
		}
		
		int middle = (left + right) / 2;
		
		TreeNode root = new TreeNode(nums[middle]);
		root.left = findRoot(nums, left, middle - 1);
		root.right = findRoot(nums, middle + 1, right);
		
		return root;
	}
	
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
        	return null;
        }
        
        return findRoot(nums, 0, nums.length - 1);
    }
}