public class Solution {
	private void subRatate(int[][] matrix,int delta){
		int index1i = delta;
		int index1j = delta;
		
		int index2i = index1i;
		int index2j = matrix.length - 1 - delta;
		
		int index3i = matrix.length - 1 - delta;
		int index3j = matrix.length - 1 - delta;
		
		int index4i = index3i;
		int index4j = index1j;
		
		if(index1j == index2j){
			return ;
		}
		
		int counter = index2j - index1j;
		for(int i = 0; i < counter; i++){
			int temp = matrix[index1i][index1j];
			matrix[index1i][index1j] = matrix[index4i][index4j];
			matrix[index4i][index4j] = matrix[index3i][index3j];
			matrix[index3i][index3j] = matrix[index2i][index2j];
			matrix[index2i][index2j] = temp;
			
			index1j++;
			index2i++;
			index3j--;
			index4i--;
		}
	}
	
    public void rotate(int[][] matrix) {
    	
    	for(int i = 0; i < (matrix.length + 1) / 2; i++){
    		subRatate(matrix, i);
    	}
        
    }
}