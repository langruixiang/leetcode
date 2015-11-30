public class Solution {
    public int trailingZeroes(int n) {
    	int ret = 0;
    	for(long i = 5; i <= (long)n; i*=5){
    		ret += n / i;
    	}
    	
    	return ret;        
    }
}