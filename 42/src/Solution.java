public class Solution {
    public int trap(int[] height) {
    	if(height == null || height.length <= 2){
    		return 0;
    	}
    	
    	int maxIndex = 0;
    	int maxHeight = height[0];
    	
    	for(int i = 1; i < height.length; i++){
    		if(height[i] > maxHeight){
    			maxIndex = i;
    			maxHeight = height[i];
    		}
    	}
    	
    	int leftIndex = 0;
    	int ret = 0;
    	for(int i = 1; i < maxIndex; i++){
    		if(height[i] < height[leftIndex]){
    			ret += height[leftIndex] - height[i];
    		}else{
    			leftIndex = i;
    		}
    	}
    	
    	int rightIndex = height.length - 1;
    	for(int i = rightIndex - 1; i > maxIndex; i--){
    		if(height[i] < height[rightIndex]){
    			ret += height[rightIndex] - height[i];
    		}else{
    			rightIndex = i;
    		}
    	}
    	
    	return ret;
    }
}