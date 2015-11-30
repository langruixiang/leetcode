public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1){        	
        	return Integer.MAX_VALUE;
        }
        int flag = 1;
        
        long ldividend,ldivisor;
        
        if(dividend < 0){
        	flag = -flag;
        	ldividend = -(long)dividend;
        }else{
        	ldividend = (long)dividend;
        }
        
        if(divisor < 0){
        	flag = -flag;
        	ldivisor = -(long)divisor;
        }else {
        	ldivisor = (long)divisor;
        }
        
        if(ldividend < ldivisor){
        	return 0;
        }
        
        int ret = 0;
        
        long bit = 1;
        while((ldivisor << 1) <= ldividend){
        	ldivisor = ldivisor << 1;
        	bit = bit << 1;
        }
        
        while(bit > 0){
        	if(ldividend >= ldivisor){
        		ldividend -= ldivisor;
            	ret += bit;
        	}
        	
        	ldivisor = ldivisor >> 1;
        	bit = bit >> 1;
        }
        
        return flag * ret;
    }
}