public class Solution {
    public int[][] generateMatrix(int n) {
    	if(n < 0){
    		return null;
    	}
    	
    	int[][] ret = new int[n][];
    	for(int i = 0; i < n; i++){
    		ret[i] = new int[n];
    	}
    	
    	if(n == 0){
    		return ret;
    	}
    	
    	int counter = 1;
    	
    	int delta = 0;
    	int length = n;
    	
    	while(length > 0){    		
    		int indexi = delta;
    		int indexj = delta;
    		
    		for(int i = 0; i < length; i++){
    			ret[indexi][indexj] = counter;
    			counter++;
    			indexj++;
    		}
    		
    		if(length == 1){
    			return ret;
    		}
    		
    		indexj--;
    		indexi++;
    		
    		for(int i = 0; i < length - 2; i++){
    			ret[indexi][indexj] = counter;
    			counter++;
    			indexi++;
    		}
    		
    		for(int i = 0; i < length; i++){
    			ret[indexi][indexj] = counter;
    			counter++;
    			indexj--;
    		}
    		
    		indexj++;
    		indexi--;
    		
    		for(int i = 0; i < length - 2; i++){
    			ret[indexi][indexj] = counter;
    			counter++;
    			indexi--;
    		}
    		
    		delta++;   	
    		length = n - 2 * delta;
    	}
    	
    	return ret;
        
    }
}