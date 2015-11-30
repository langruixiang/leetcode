public class Solution {
    public int mySqrt(int x) {
    	if(x < 0){
    		return Integer.MIN_VALUE;
    	}
    	
    	if(x == 0){
    		return 0;
    	}
    	
    	int l = 1;
    	int r = x;
    	int ret ;
    	
    	while(true){
    		ret =  (l + r) / 2;
    		long ans = ret * ret;
    		
    		if(ret <= x / ret && (ret + 1) > x / (ret + 1)){
    			return ret;
    		}else{
                if(ret < x / ret){
    				l = ret + 1;
    			}else{
    				r = ret - 1;
    			}
    		}
    	}
        
    }
}