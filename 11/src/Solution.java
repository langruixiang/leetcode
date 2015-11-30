public class Solution {
    public int maxArea(int[] height) {
    	int ret = -1;
    	
    	int i = 0;
    	int j = height.length - 1;
    	
    	while(i < j){
    		int area = Math.min(height[i], height[j]) * (j - i);
    		
    		ret = ret < area ? area : ret;
    		
    		if(height[i] < height[j]){
    			i++;
    		}else{
    			j--;
    		}
    	}
    	
    	return ret;
        
    }
}