import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public void nextPermutation(int[] nums) {
    	if(nums == null || nums.length <= 1){
    		return ;
    	}
    	
    	int index = nums.length - 2;
    	
    	PriorityQueue<Integer> heap1 = new PriorityQueue<Integer>();
    	PriorityQueue<Integer> heap2 = new PriorityQueue<Integer>();
    	
    	
    	while(index >= 0){
    		for(int i = index; i < nums.length; i++){
    			heap1.add(nums[i]);
    		}
    		
    		while(!heap1.isEmpty()){
    			int tmp = heap1.remove();
    			if(tmp <= nums[index]){
    				heap2.add(tmp);
    			}else{
    				nums[index] = tmp;
    				while(!heap1.isEmpty()){
    					heap2.add(heap1.remove());
    				}
    				
    				int i = 1; 
    				while(!heap2.isEmpty()){
    					nums[index + i] = heap2.remove();
    					i++;
    				}
    				
    				return ;
    			}
    		}
    		
    		index--;
    		heap1.clear();
    		heap2.clear();
    	}
    	
    	Arrays.sort(nums);
    	
    	return ;
        
    }
}