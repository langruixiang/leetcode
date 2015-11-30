public class NumArray {
	
	int[] sum = null;

    public NumArray(int[] nums) {
        sum = new int[nums.length];
        
        int counter = 0; 
        for(int i = 0; i < nums.length; i++){
        	counter += nums[i];
        	sum[i] = counter;
        }
    }

    public int sumRange(int i, int j) {
        if(i == 0){
        	return sum[j];
        }
        
        return sum[j] - sum[i - 1];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);