public class Solution {
	private int min(int a,int b,int c){
		return Math.min(Math.min(a, b), c);
	}
	
    public int nthUglyNumber(int n) {
    	int counter = 0;
    	
    	int[] uglyNum = new int[n];
    	uglyNum[0] = 1;
    	
    	int factor2 = 2;
    	int factor3 = 3;
    	int factor5 = 5;
    	
    	int index2 = 0;
    	int index3 = 0;
    	int index5 = 0;
    	
    	while(counter < n - 1){
    		int num = min(factor2,factor3,factor5);
    		uglyNum[++counter] = num;
    		
    		if(num == factor2){
    			factor2 = uglyNum[++index2] * 2;
    		}
    		if(num == factor3){
    			factor3 = uglyNum[++index3] * 3;
    		}
    		if(num == factor5){
    			factor5 = uglyNum[++index5] * 5;
    		}    		
    	}
    	
    	return uglyNum[counter];        
    }
}