import java.util.HashMap;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
    	HashMap<Character,Integer> hashMap = new HashMap<Character,Integer>();
    	
    	//判定行是否合法
    	for(int i = 0; i < board.length; i++){
    		int j;
    		for(j = 0; j < board[i].length; j++){
    			if(board[i][j] != '.' && hashMap.containsKey(board[i][j])){
    				break;
    			}else if(board[i][j] != '.'){
    				hashMap.put(board[i][j], 0);    				
    			}
    		}
    		
    		if(j != board[i].length){
    			return false;
    		}else{
    			hashMap.clear();
    		}
    	}
    	
    	//判定列是否合法
        for(int i = 0; i < board.length; i++){
        	int j;
        	for(j = 0; j < board[i].length; j++){
        		if(board[j][i] != '.' && hashMap.containsKey(board[j][i])){
        			break;
        		}else if(board[j][i] != '.'){
        			hashMap.put(board[j][i], 0);
        		}
        	}
        	
        	if(j != board[i].length){
        		return false;
        	}else{
        		hashMap.clear();
        	}
        }
        
        //判定网格是否合法
        for(int i = 0; i < board.length; i += 3){
        	for(int j = 0; j < board[i].length; j += 3){
        	    for(int l = 0; l < 3; l++){
        	    	int m;
        	    	for(m = 0; m < 3; m++){
        	    		if(board[i + l][j + m] != '.' && hashMap.containsKey(board[i + l][j + m])){
        	    			break;
        	    		}else if(board[i + l][j + m] != '.'){
        	    			hashMap.put(board[i + l][j + m], 0);
        	    		}
        	    	}
        	    	
        	    	if(m != 3){
        	    		return false;
        	    	}
        	    }
        	    
        	    hashMap.clear();
        	}
        }
        
        return true;
    	
    }
}