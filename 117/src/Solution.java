/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
	public TreeLinkNode findNextLevel(TreeLinkNode root){
		TreeLinkNode iterator = root;
		
		while(iterator != null){
			if(iterator.left != null){
				return iterator.left;
			}else if(iterator.right != null){
				return iterator.right;
			}
			
			iterator = iterator.next;
		}
		
		return null;
	}
	
	private TreeLinkNode findNextSilibing(TreeLinkNode root,int left){
		if(root == null){
			return null;
		}
		
		TreeLinkNode iterator = root;
		
		if(left == 1 && iterator.left != null){
			return iterator.left;
		}
		
		if(iterator.right != null){
			return iterator.right;
		}
		
		iterator = iterator.next;
		while(iterator != null){
			if(iterator.left != null){
				return iterator.left;
			}else if(iterator.right != null){
				return iterator.right;
			}
			iterator = iterator.next;
		}
		
		return null;
	}
	
    public void connect(TreeLinkNode root) {
    	TreeLinkNode level = root;
    	if(level == null){
    		return ;
    	}
    	
    	TreeLinkNode nextLevel = findNextLevel(level);
    	
    	while(nextLevel != null){
    		TreeLinkNode iterator = level;
    		
    		while(iterator != null){
    			if(iterator.left != null){
    				iterator.left.next = findNextSilibing(iterator, 2);
    				if(iterator.left.next == null){
    					break;
    				}
    			}
    			if(iterator.right != null){
    				iterator.right.next = findNextSilibing(iterator.next, 1);
    				if(iterator.right.next == null){
    					break;
    				}
    			}
    			iterator = iterator.next;
    		}
    		level = nextLevel;
    		nextLevel = findNextLevel(level);
    	}        
        
    }
}