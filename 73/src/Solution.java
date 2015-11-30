public class Solution {
    public void setZeroes(int[][] matrix) {
    	if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
    		return ;
    	}
    	
    	int indexi = -1;
    	int indexj = -1;
        
    	boolean flg = false;
    	
    	for(int i = 0; i < matrix.length; i++){
    		for(int j = 0; j < matrix[0].length;j++){
    			if(j == indexj){
    				continue;
    			}
    			
    			if(matrix[i][j] == 0 && flg == false){
    				indexi = i;
    				indexj = j;
    				flg = true;
    				break;
    			}else if(matrix[i][j] == 0 && flg == true){
    				matrix[i][indexj] = 0;
    				matrix[indexi][j] = 0;
    			}
    		}
    	}
    	
    	if(flg == false){
    		return ;
    	}
    	
    	for(int i = 0; i < matrix.length; i++){
    		if(i == indexi){
    			continue;
    		}
    		if(matrix[i][indexj] == 0){
    			for(int j = 0; j < matrix[0].length; j++){
    				matrix[i][j] = 0;
    			}
    		}
    	}
    	
    	for(int j = 0; j < matrix[0].length; j++){
    		if(j == indexj){
    			continue;
    		}
    		if(matrix[indexi][j] == 0){
    			for(int i = 0; i < matrix.length; i++){
    				matrix[i][j] = 0;
    			}
    		}
    	}
    	
    	for(int i = 0; i < matrix.length; i++){
    		matrix[i][indexj] = 0;
    	}
    	
    	for(int j = 0; j < matrix[0].length; j++){
    		matrix[indexi][j] = 0;
    	}
    }
}