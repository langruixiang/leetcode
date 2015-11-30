public class Solution {

    public int numSquares(int n) {
    	if(n <= 0){
    		return 0;
    	}
    	
    	int root = (int)Math.sqrt(n);
    	if(root * root == n){
    		return 1;
    	}
    	
    	int []counter = new int[n + 1];
    	counter[1] = 1;
    	
    	for(int i = 2; i <= n; i++){    		
    		root = (int)Math.sqrt(i);
    		
    		if(root * root == i){
    			counter[i] = 1;
    		}else{
    			int tmp = Integer.MAX_VALUE;
    			for(int j = 1; j  <= root ; j++){    			
        			tmp = tmp < 1 + counter[i - j * j ] ? tmp : 1 + counter[i - j * j ];
        		}
    			counter[i] = tmp;
    		}   		
    	}
    	
    	return counter[n];
    	
    }
}