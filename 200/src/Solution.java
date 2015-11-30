public class Solution {
	private char[][] grid = null;
	
	private void dissolve(int i,int j){
		if(i < 0 || i == grid.length || j < 0 || j == grid[0].length){
			return ;
		}
		
		if(grid[i][j] == '1'){
			grid[i][j] = '#';
			dissolve(i + 1, j);
			dissolve(i - 1, j);
			dissolve(i, j + 1);
			dissolve(i, j - 1);		
		}
	}
	
    public int numIslands(char[][] grid) {
    	if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0){
    		return 0;
    	}
    	
        this.grid = grid;
        int ret = 0;
        
        for(int i = 0; i < grid.length; i++){
        	for(int j = 0; j < grid[0].length; j++){
        		if(grid[i][j] == '1'){
        			ret++;
        			dissolve(i, j);
        		}
        	}
        }
        
        return ret;
    }
}