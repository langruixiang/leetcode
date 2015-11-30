public class Solution {
	private int[][] board;	
	
	private int liveNeighbors(int iIndex,int jIndex){
		int ret = 0;
		
		for(int i = iIndex - 1; i <= iIndex + 1; i++){
			if(i < 0 || i >= board.length){
				continue;
			}
			
			for(int j = jIndex - 1; j <= jIndex + 1; j++){
				if(j < 0 || j >= board[0].length || (i == iIndex && j == jIndex)){
					continue;
				}
				
				if((board[i][j] & 1) == 1){
					ret++;
				}
			}
		}
		
		return ret;
	}
	
    public void gameOfLife(int[][] board) {
    	if(board == null || board.length == 0 || board[0] == null || board[0].length == 0){
    		return ;
    	}
    	
    	this.board = board;
    	
    	for(int i = 0; i < board.length; i++){
    		for(int j = 0; j < board[0].length;j++){
    			int num = liveNeighbors(i, j);
    			if(board[i][j] == 1){
    				if(num == 2 || num == 3){
    					board[i][j] |= (1 << 1);
    				}
    			}else{
    				if(num == 3){
    					board[i][j] |= (1 << 1);
    				}
    			}
    		}
    	}
    	
    	for(int i = 0; i < board.length; i++){
    		for(int j = 0; j < board[0].length; j++){
    			board[i][j] = board[i][j] >>> 1;
    		}
    	}
        
    	return ;
    }
}