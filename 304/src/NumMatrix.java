public class NumMatrix {

	private int[][] matrix = null;
	
    public NumMatrix(int[][] matrix) {
    	if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
    		return ;
    	}
    	
    	this.matrix = matrix;
    	
    	int sum = 0;
    	for(int j = 0; j < matrix[0].length; j++){
    		sum += matrix[0][j];
    		matrix[0][j] = sum;
    	}
    	
 
    	sum = 0;
    	for(int i = 0; i < matrix.length; i++){
    		sum += matrix[i][0];
    		matrix[i][0] = sum;
    	}
    	
    	for(int i = 1; i < matrix.length; i++){
    		for(int j = 1; j < matrix[0].length; j++){
    			matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1] - matrix[i - 1][j - 1] + matrix[i][j];
    		}
    	}
        
    	
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
    	
    	
    	if(row1 != 0 && col1 != 0){
    		 return matrix[row2][col2] - matrix[row1 - 1][col2] - matrix[row2][col1 - 1] + matrix[row1 - 1][col1 - 1];
    	}else if(row1 == 0 && col1 == 0){
    		return matrix[row2][col2];
    	}else if(row1 == 0){
    		 return matrix[row2][col2] - matrix[row2][col1 - 1];
    	}
    	
        return matrix[row2][col2] - matrix[row1 - 1][col2];
       
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);