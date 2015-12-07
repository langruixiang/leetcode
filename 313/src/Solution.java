
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {    	
    	int[] superUglyNum = new int[n];    	
    	int[] minIndex = new int[primes.length];
    	int counter = 0;
    	superUglyNum[counter++] = 1;
    	
    	int[] minArray = new int[primes.length];
    	System.arraycopy(primes, 0, minArray, 0, primes.length);
    	
    	while(counter < n){
    		int minNum = Integer.MAX_VALUE;
    		for(int i = 0; i < minArray.length; i++){
    			if(minArray[i] < minNum){
    				minNum = minArray[i];
    			}
    		}
    		
    		superUglyNum[counter++] = minNum;
    		System.out.println(superUglyNum[counter - 1]);
    		for(int i = 0; i < minArray.length; i++){
    			if(minArray[i] == minNum){
    				minArray[i] = superUglyNum[++minIndex[i]] * primes[i];
    			}
    		}
    	}
        
    	return superUglyNum[n - 1];
    }
}