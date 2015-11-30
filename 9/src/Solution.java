public class Solution {
	private int jiweishu(int x){
		
		int ret = 0;
		while(x >= 10){
			ret++;
			x /= 10;
		}
		
		ret++;
		
		return ret;
	}
	
    public boolean isPalindrome(int x) {
    	if(x < 0){
    		return false;
    	}
    	
    	
        int num = Math.abs(x);
        
        int weishu = jiweishu(num);
        
        while(weishu > 1){
        	int first = num / (int) Math.pow(10, weishu - 1);
        	int last = num % 10;
        	
        	if(first != last){
        		return false;
        	}
        	
        	num = num - first * (int) Math.pow(10, weishu - 1) - last;
        	
        	num /= 10;
        	
        	weishu -= 2;
        }
        
        return true;
    }
}