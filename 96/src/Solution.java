public class Solution {	
//	private int countTrees(int n){
//        if(n == 0){
//        	return 1;
//        }
//        
//        if(countRes[n] != 0){
//        	return countRes[n];
//        }
//		
//		int counter = 0;
//		
//		for(int i = 0; i < n; i++){
//			int num1 = countTrees(i);
//			int num2 = countTrees(n - i - 1);
//			counter += num1 * num2;
//		}
//		
//		return counter;
//	}
	
    public int numTrees(int n) {
        if(n <= 0){
        	return 0;
        }
        
        int []countRes = new int[n + 1];
        countRes[0] = 1;
        countRes[1] = 1;
        
        for(int i = 2; i < n + 1; i++){
        	int counter = 0;
        	for(int j = 0; j <= (i - 1); j++){
        		counter += countRes[j] * countRes[i - 1 - j];
        	}
        	countRes[i] = counter;
        }
        
        return countRes[n];
    }
}