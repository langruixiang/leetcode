import java.util.HashMap;
import java.util.Map;

public class Solution {
	Map<Character,Integer> allValue = new HashMap<Character,Integer>();
	public Solution(){
		for(int i = 1; i < 10; i++){
			allValue.put(new Character((char)('0' + i)), 0);
		}
	}
	
	private boolean solve(char[][] board,int begini,int beginj){
    	int indexi = -1,indexj = -1;
    	
    	for(int i = begini; i < board.length; i++){
    		int j;
    		for(j = beginj; j < board[0].length; j++){
    			if(board[i][j] == '.'){
    				indexi = i;
    				indexj = j;
    				break;
    			}
    		}
    		
    		if(j != board[0].length){
    			break;
    		}
    		beginj = 0;
    	}
        
    	if(indexi == -1){
    		return true;
    	}
    	
    	Map<Character,Integer> validValue = new HashMap<Character,Integer>();
    	validValue.putAll(allValue);
    	
    	for(int i = 0; i < board.length; i++){
    		if(board[i][indexj] != '.'){
    			validValue.remove(board[i][indexj]);
    		}
    	}
    	
    	for(int j = 0; j < board[0].length; j++){
    		if(board[indexi][j] != '.'){
    			validValue.remove(board[indexi][j]);
    		}
    	}
    	
    	int starti = indexi - indexi % 3;
    	int startj = indexj - indexj % 3;
    	
    	for(int i = 0; i < 3; i++){
    		for(int j = 0; j < 3; j++){
    			if(board[starti + i][startj + j] != '.'){
    				validValue.remove(board[starti + i][startj + j]);
    			}
    		}
    	}
    	
    	if(validValue.isEmpty()){
    		return false;
    	}
    	
    	for(Map.Entry<Character, Integer> entry:validValue.entrySet()){   
    	    board[indexi][indexj] = entry.getKey();
    	    if(solve(board,indexi,indexj + 1)){
    	    	return true;
    	    }
    	}   
    
    	board[indexi][indexj] = '.';
		return false;
	}
	
    public void solveSudoku(char[][] board) {
    	solve(board, 0, 0);
    }
}