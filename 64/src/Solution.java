public class Solution {
    public int minPathSum(int[][] grid) {
    	if(grid == null || grid.length == 0 ||grid[0].length == 0){
    		return 0;
    	}
    	
    	int [][]counter = new int[grid.length][];
    	for(int i = 0; i < grid.length; i++){
    		counter[i]  =new int[grid[0].length];
    	}
        
    	counter[0][0] = grid[0][0];
    	
    	for(int i = 1; i < grid[0].length; i++){
    		counter[0][i] = counter[0][i -1] + grid[0][i];
    	}
    	
    	for(int i = 1; i < grid.length; i++){
    		counter[i][0] = counter[i - 1][0] + grid[i][0];
    	}
    	
    	for(int i = 1; i < grid.length; i++){
    		for(int j = 1; j < grid[0].length; j++){
    			counter[i][j] = Math.min(counter[i -1][j], counter[i][j - 1]) + grid[i][j];
    		}
    	}
    	
    	return counter[grid.length - 1][grid[0].length - 1];
    }
}