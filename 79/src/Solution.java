public class Solution {
	private boolean find(char[][] board,String word,int i,int j,int wordbegin){
		if(wordbegin == word.length()){
			return true;
		}
		
		if(i + 1 < board.length && board[i + 1][j] == word.charAt(wordbegin)){
			char tmp = board[i + 1][j];
			board[i + 1][j] = ' ';
			if(find(board, word, i + 1, j,wordbegin + 1)){
				return true;
			}
			board[i + 1][j] = tmp;
		}
		
		if(i - 1 >= 0 && board[i - 1][j] == word.charAt(wordbegin)){
			char tmp = board[i - 1][j];
			board[i -1][j] = ' ';
			if(find(board,word,i - 1,j,wordbegin + 1)){
				return true;
			}
			board[i - 1][j] = tmp;
		}
		
		if(j + 1 < board[0].length && board[i][j + 1] == word.charAt(wordbegin)){
			char tmp = board[i][j + 1];
			board[i][j + 1] = ' ';
			if(find(board, word, i, j + 1,wordbegin + 1)){
				return true;
			}
			board[i][j + 1] = tmp;
		}
		
		if(j - 1 >= 0 && board[i][j - 1] == word.charAt(wordbegin)){
			char tmp = board[i][j - 1];
			board[i][j - 1] = ' ';
			if(find(board,word,i,j - 1,wordbegin + 1)){
				return true;
			}
			board[i][j - 1] = tmp;
		}
		
		return false;
		
	}
	
    public boolean exist(char[][] board, String word) {
    	if(board == null || board.length == 0 || board[0].length == 0){
    		return false;
    	}
    	
    	for(int i = 0; i < board.length; i++){
    		for(int j = 0; j < board[0].length; j++){
    			if(board[i][j] == word.charAt(0)){
    				char tmp = board[i][j];
        			board[i][j] = ' ';
        			if(find(board, word, i, j,1)){
        				return true;
        			}
        			board[i][j] = tmp;
    			}
    			
    		}
    	}
    	
    	return false;
        
    }
}