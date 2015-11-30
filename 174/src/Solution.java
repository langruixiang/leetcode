public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
    	if(dungeon == null || dungeon.length == 0 || dungeon[0] == null || dungeon[0].length == 0){
    		return 1;
    	}
    	
    	int[][] min = new int[dungeon.length][];
    	
    	for(int i = 0; i < dungeon.length; i++){
    		min[i] = new int[dungeon[0].length];
    	}
    	
    	int i = dungeon.length - 1;
    	int j = dungeon[0].length - 1;
    	min[i][j] = 1 - dungeon[i][j] < 1 ? 1 : 1 - dungeon[i][j];
    	
    	i = dungeon.length - 1;
    	for(j = dungeon[0].length - 2; j >= 0; j--){
    		min[i][j] = min[i][j + 1] - dungeon[i][j] < 1 ? 1 : min[i][j + 1] - dungeon[i][j];
    	}
    	
    	j = dungeon[0].length - 1;
    	for(i = dungeon.length - 2; i >=0 ; i--){
    		min[i][j] = min[i + 1][j] - dungeon[i][j] < 1 ? 1 : min[i + 1][j] - dungeon[i][j];
    	}   	
    	
    	for(i = dungeon.length - 2;i >= 0; i--){
    		for(j = dungeon[0].length - 2;j >= 0; j--){
    			min[i][j] = Math.min(min[i + 1][j], min[i][j + 1]) - dungeon[i][j];
    			if(min[i][j] < 1){
    				min[i][j] = 1;
    			}
    		}
    	}
        
    	return min[0][0];
    }
}