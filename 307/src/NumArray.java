public class NumArray {
	private class TreeNode{
		int sum;
		int leftIndex;
		int rightIndex;
		
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int leftIndex,int rightIndex){
			this.leftIndex = leftIndex;
			this.rightIndex = rightIndex;
		}
	}
	
	private TreeNode root;
	
	private TreeNode buildTree(int[] nums,int left,int right){
		TreeNode ret = new TreeNode(left,right);
		
		if(left == right){
			ret.sum = nums[left];
			return ret;
		}
		
		int mid = left + (right - left) / 2;
		ret.left = buildTree(nums, left, mid);
		ret.right = buildTree(nums, mid + 1, right);		
		ret.sum = ret.left.sum + ret.right.sum;
		
		return ret;		
	}
	
	private void updateNode(TreeNode root,int index,int val){
		if(root.left == root.right){
			root.sum = val;
		}else{
			int mid = root.leftIndex + (root.rightIndex - root.leftIndex) / 2;
			if(index <= mid){
				updateNode(root.left, index, val);
			}else{
				updateNode(root.right, index, val);
			}
			
			root.sum = root.left.sum + root.right.sum;	
		}	
	}
	
	private int queryTree(TreeNode root,int left,int right){	
		if(root.leftIndex == root.rightIndex){
			return root.sum;
		}
		
		if(root.leftIndex == left && root.rightIndex == right){
			return root.sum;
		}
		
		int mid = root.leftIndex + (root.rightIndex - root.leftIndex) / 2;		
		if(right <= mid){
			int sum1 = queryTree(root.left, left, right);
			return sum1;
		}else if(left >= mid + 1){
			int sum1 = queryTree(root.right, left, right);
			return sum1;
		}else{
			int sum1 = queryTree(root.left, left, mid);
			int sum2 = queryTree(root.right, mid + 1, right);
			
			return sum1 + sum2;
		}		
	}
	

    public NumArray(int[] nums) {
    	if(nums == null || nums.length == 0){
    		return ;
    	}
    	
    	this.root = buildTree(nums, 0, nums.length - 1);
        
    }

    void update(int i, int val) {
        updateNode(root, i, val);
    }

    public int sumRange(int i, int j) {
        return queryTree(root, i, j);
    }
    
//    public static void main(String[] args){
//    	int[] nums = {1,3,5};
//    	
//    	NumArray numArray = new NumArray(nums);
//	    numArray.sumRange(0, 2);
//	    numArray.update(1, 2);
//	    numArray.sumRange(0, 2);
//    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);