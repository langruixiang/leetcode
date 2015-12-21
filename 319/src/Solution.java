//public class Solution {
//    public int bulbSwitch(int n) {
//    	if(n <= 0){
//    		return 0;
//    	}
//    	
//    	if(n == 1){
//    		return 1;
//    	}
//    	
//    	int[] counter = new int[n];
//    	for(int i = 2; i <= n; i++){
//    		int delta = 1;
//    		int product = i * delta;
//    		while(product <= n){
//    			counter[product - 1]++;
//    			product = i * ++delta;
//    		}
//    	}
//    	
//    	int ret = 0;
//    	for(int i = 0; i < n; i++){    		
//    		if((counter[i] & 1) == 0){
//    			ret ++;
//    			System.out.print("0 ");
//    		}else{
//    			System.out.print("1 ");
//    		}
//    	}
//    	
//    	return ret;        
//    }
//}

//public class Solution {
//    public int bulbSwitch(int n) {
//    	if(n <= 0){
//    		return 0;
//    	}
//    	
//    	int ret = 1;
//    	int acc = 1;
//    	int delta = 3;
//    	while(acc <= n - delta){
//    		ret++;
//    		acc += delta;
//    		delta += 2;
//    	}
//    	return ret;        
//    }
//}

public class Solution {
    public int bulbSwitch(int n) {
    	return (int)Math.sqrt(n);        
    }
}