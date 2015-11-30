public class Solution {
    public int reverse(int x) {
    	long ret = 0;
    	
    	int abs;
    	abs = x < 0 ? -x : x;
    	
    	int last = 0;
    	while(abs >= 10){
    		last = abs % 10;
    		ret = ret * 10 + last;
    		
    		abs /= 10;
    	}
    	
    	ret = ret * 10 + abs;
    	
    	if(ret > Integer.MAX_VALUE || ret < - Integer.MAX_VALUE){
    		ret = 0;
    	}else{
    		if(x < 0){
    			ret = -ret;
    		}
    	}
    	
    	return (int)ret;
        
    }
}