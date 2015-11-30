public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
    		return false;
    	}
    	
    	int r = matrix.length;
    	int c = matrix[0].length;
    	
    	int num = r * c;
    	
    	int left = 0;
    	int right = num - 1;
    	
    	while(left <= right){
    	    int middle = (left + right) / 2;
    	    int indexi = middle / c;
    	    int indexj = middle % c;
    	    
    	    if(matrix[indexi][indexj] == target){
    	    	return true;
    	    }else if(matrix[indexi][indexj] < target){
    	    	left = middle + 1;
    	    }else{
    	    	right = middle - 1;
    	    }
    		
    	}
        
    	return false;
    }
}