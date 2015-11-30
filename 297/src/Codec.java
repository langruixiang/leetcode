import java.util.ArrayList;
import java.util.Arrays;
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
public class Codec {
	
	private void buildString(TreeNode root,StringBuilder pre){
		if(root == null){
			pre.append("N" + ",");
			return ;
		}
		
		pre.append(root.val + ",");
		
		buildString(root.left, pre);
		buildString(root.right, pre);		
	}
	
	private TreeNode decodeString(ArrayList<String> items){
		if(items.isEmpty()){
			return null;
		}
		
		if(items.get(0).equals("N")){
			items.remove(0);
			return null;
		}
		
		TreeNode root = new TreeNode(Integer.valueOf(items.get(0)));
		items.remove(0);
		
		root.left = decodeString(items);
		root.right = decodeString(items);
		
		return root;		
	}
	
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	StringBuilder pre = new StringBuilder("");
    	
    	buildString(root, pre);
    	
    	return new String(pre);
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	ArrayList<String> pre = new ArrayList<String>(); 
    	pre.addAll(Arrays.asList(data.split(",")));
    	
    	return decodeString(pre);        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));