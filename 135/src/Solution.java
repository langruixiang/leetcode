import java.security.AccessControlContext;

//public class Solution {
//	private int[] ratings = null;
//	private int[] counter = null;
//	
//	private void helper(int i){
//		int index = i;
//		
//		counter[index] = 1;
//		while(index - 1 >= 0 && ratings[index - 1] > ratings[index]){
//			counter[index - 1] = Math.max(counter[index - 1],counter[index] + 1);
//			index--;
//		}
//		
//		
//		index = i;
//		while(index + 1 < ratings.length && ratings[index + 1] > ratings[index]){
//			counter[index + 1] = Math.max(counter[index + 1], counter[index] + 1);
//			index++;
//		}		
//	}
//	
//    public int candy(int[] ratings) {
//    	if(ratings == null || ratings.length == 0){
//    		return 0;
//    	}
//    	
//    	if(ratings.length == 1){
//    		return 1;
//    	}
//    	
//    	this.ratings = ratings;
//    	this.counter = new int[ratings.length];
//    	
//    	for(int i = 0; i < ratings.length; i++){
//    		if(i == 0){
//    			if(ratings[i] <= ratings[i + 1]){
//    				helper(i);
//    			}
//    		}else if(i == ratings.length - 1){
//    			if(ratings[i] <= ratings[i - 1]){
//    				helper(i);
//    			}
//    		}else{
//    			if(ratings[i] <= ratings[i + 1] && ratings[i] <= ratings[i - 1]){
//    				helper(i);
//    			}
//    		}
//    	}
//        
//    	int sum = 0;
//    	for(int i = 0; i < counter.length; i++){
//    		sum += counter[i];
//    	}
//    	
//    	return sum;
//    }
//}

public class Solution {
    public int candy(int[] ratings) {
    	if(ratings == null || ratings.length == 0){
    		return 0;
    	}
    	
    	if(ratings.length == 1){
    		return 1;
    	}
    	
    	int counter[] = new int[ratings.length];
    	counter[0] = 1;
    	
    	for(int i = 1; i < ratings.length; i++){
    		if(ratings[i] > ratings[i - 1]){
    			counter[i] = counter[i - 1] +1;
    		}else{
    			counter[i] = 1;
    		}
    	}
    	
    	for(int i = ratings.length - 2; i >= 0; i--){
    		if(ratings[i] > ratings[i + 1]){
    			counter[i] = Math.max(counter[i], counter[i + 1] + 1);
    		}
    	}
    	
    	int sum = 0;
    	for(int i = 0; i < counter.length; i++){
    		sum += counter[i];
    	}
    	
    	return sum;
        
    }
}