public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	if(nums1 == null || nums2 == null || n == 0){
    		return ;
    	}
        
    	for(int i = 0; i < n; i++){
    		int j = m + i - 1;
    		while(j >= 0 && nums1[j] > nums2[i]){
    			nums1[j + 1] = nums1[j];
    			j--;
    		}
    		
    		nums1[j + 1] = nums2[i];
    	}
    }
}