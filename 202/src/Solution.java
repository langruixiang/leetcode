import java.util.HashSet;
import java.util.Set;

public class Solution {
	public int getNumber(int n){
		int ret = 0;
		while(n > 0){
			int tmp = n % 10;
			ret += tmp * tmp;
			n /= 10;
		}
		
		return ret;
	}
	
	private Set<Integer> set = new HashSet<Integer>();
	
    public boolean isHappy(int n) {
    	if(n <= 0){
    		return false;
    	}
    	
    	int tmp = getNumber(n);
    	while(tmp != 1){
    		if(set.contains(tmp)){
    			return false;
    		}    		
    		set.add(tmp);
    		
    		tmp = getNumber(tmp);
    	}
    	
    	return true;
        
    }
}