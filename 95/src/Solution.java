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
	private List<TreeNode> generate(int[] array,int left,int right){
		if(right < left){
			return null;
		}
		
		List<TreeNode> ret = new ArrayList<TreeNode>();
		
		for(int i = left; i <= right; i++){
			List<TreeNode> leftRes = generate(array, left, i - 1);
			List<TreeNode> rightRes = generate(array, i + 1, right);
			
			if(leftRes != null && rightRes != null){
				for(int k = 0; k < leftRes.size(); k++){
					for(int l = 0; l < rightRes.size(); l++){
						TreeNode root = new TreeNode(array[i]);
						root.left = leftRes.get(k);
						root.right = rightRes.get(l);
						
						ret.add(root);
					}
				}
			}else if(leftRes != null && rightRes == null){
				for(int k = 0; k < leftRes.size(); k++){
					TreeNode root = new TreeNode(array[i]);
					root.left = leftRes.get(k);
					
					ret.add(root);
				}
			}else if(leftRes == null && rightRes != null){
				for(int k = 0; k < rightRes.size(); k++){
					TreeNode root = new TreeNode(array[i]);
					root.right = rightRes.get(k);
					
					ret.add(root);
				}
			}else{
				TreeNode root = new TreeNode(array[i]);
				ret.add(root);
			}			
		}
		
		return ret;
	}
	
    public List<TreeNode> generateTrees(int n) {
    	if(n <= 0){
    		List<TreeNode> ret = new ArrayList<TreeNode>();
    		ret.add(null);
    		return ret;
    	}
    	
    	int[] array = new int[n];
    	for(int i = 0; i < n; i++){
    		array[i] = i + 1;
    	}
    	
    	return generate(array, 0, array.length - 1);
    	        
    }
}