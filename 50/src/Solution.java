public class Solution {
	
    public double myPow(double x, int n) {
    	if(n == 0){
    		return 1.0;    		
    	}else if(n < 0){
    		return 1.0/myPow(x, -(n+1))/x;
    	}
    	
    	if(x == 1.0){
    		return 1.0;
    	}
    	
    	if(n % 2 == 0){
    		double tmp = myPow(x,n/2);
    		return tmp * tmp;
    	}else if(n % 2 == 1){
    		if(n == 1){
    			return x;
    		}else{
    			double tmp = myPow(x, (n-1)/2);
    			return tmp*tmp*x;
    		}
    	}
    	
    	return 0;
    }
}