public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
    		return 0;
    	}
    	
    	int [][]counter = new int[obstacleGrid.length][];
    	for(int i = 0; i < obstacleGrid.length; i++){
    		counter[i] = new int[obstacleGrid[0].length];
    	}
    	
    	int initCounter = 1;
    	for(int i = 0; i < obstacleGrid[0].length; i++){
    		if(obstacleGrid[0][i] == 1){
    			initCounter = 0;
    		}
    		
    		counter[0][i] = initCounter;
    	}
    	
    	initCounter = 1;
    	for(int i = 0; i < obstacleGrid.length; i++){
    		if(obstacleGrid[i][0] == 1){
    			initCounter = 0;
    		}
    		
    		counter[i][0] = initCounter;
    	}
    	
    	for(int i = 1; i < obstacleGrid.length; i++){
    		for(int j = 1; j < obstacleGrid[0].length; j++){
    			if(obstacleGrid[i][j] == 1){
    				counter[i][j] = 0;
    			}else{
    				counter[i][j]  = counter[i - 1][j] + counter[i][j - 1];
    			}
    		}
    	}
    	
    	return counter[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}