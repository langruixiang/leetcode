//public class Solution {
//    public int removeDuplicates(int[] nums) {
//    	if(nums == null){
//    		return 0;
//    	}
//    	
//    	int length = nums.length;
//    	
//    	if(length <= 2){
//    		return nums.length;
//    	}
//    	
//    	int i = 0;
//    	
//    	int delta = 0;
//    	
//    	while(i < nums.length){
//    	    if(i + 1 == nums.length){
//    	    	nums[i - delta] = nums[i];
//    	        return length;    	    	
//    	    }else if(i + 1 < nums.length && nums[i] != nums[i + 1]){
//    			nums[i - delta] = nums[i];
//    			i++;
//    		}else if(i + 1 < nums.length && nums[i] == nums[i + 1]){
//    			int counter = 1;
//    			while(i + counter < nums.length && nums[i] == nums[i + counter]){
//    				counter++;
//    			}    			
//    			
//    			int tmp = counter > 2 ? 2 : counter;
//    			while(tmp > 0){
//    				nums[i - delta] = nums[i];
//    				tmp--;
//    				i++;
//    			}
//    			
//    			if(counter > 2){
//    				delta += (counter - 2);
//    				length -= (counter - 2);
//    				i += (counter - 2);
//    			}
//    			
//    		}
//    	}
//        
//    	return length;
//    }
//}

public class Solution {
    public int removeDuplicates(int[] nums) {
    	if(nums == null){
    		return 0;
        }
    	
    	if(nums.length <= 2){
    		return nums.length;
    	}
    	
    	int start = 0;
    	int key = nums[0];
    	int counter = 0;
    	
    	for(int i = 0; i < nums.length; i++){
    		if(nums[i] == key){
    			counter++;
    		}else{
    			int tmp = counter > 2 ? 2 : counter;
    			for(int j = 0; j < tmp; j++){
    				nums[start] = key;
    				start++;
    			}
    			
    			key = nums[i];
    			counter = 1;
    		}
    	}
    	
    	int tmp = counter > 2 ? 2 : counter;
		for(int j = 0; j < tmp; j++){
			nums[start] = key;
			start++;
		}
    	
    	return start;
    }
}