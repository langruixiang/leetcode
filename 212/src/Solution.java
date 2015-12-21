import java.util.*;

public class Solution {
	private class TrieNode{
		boolean isWord;
		TrieNode[] sons = new TrieNode[26];
	}
	
	private TrieNode root = new TrieNode();
	
	private void insert(String word){
		TrieNode iterator = root;
		for(int i = 0; i < word.length(); i++){
			 int index = word.charAt(i) - 'a';
			if(iterator.sons[index] == null){
				TrieNode tmp = new TrieNode();
				iterator.sons[index] = tmp;
				iterator = tmp;
			}else{
				iterator = iterator.sons[index];
			}
		}
		
		iterator.isWord = true;
	}
	
	private void search(char[][] board,int indexi,int indexj,TrieNode root,String pre){
		if(indexi < 0 || indexi >= board.length || indexj < 0 || indexj >= board[0].length){
			return ;
		}
		
		char c = board[indexi][indexj];
		int index = c - 'a';
		if(index < 0 || index >= 26){
			return ;
		}
		
		board[indexi][indexj] = ' ';
		int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
		
		if(root.sons[index] != null){
			pre += c;
			if(root.sons[index].isWord){
				ret.add(pre);
				root.sons[index].isWord = false;
			}
			
			for(int d = 0; d < 4; d++){
				search(board, indexi + directions[d][0], indexj + directions[d][1], root.sons[index], pre);
			}
		}
		board[indexi][indexj] = c;
	}
	
	private List<String> ret = new ArrayList<String>();
	
    public List<String> findWords(char[][] board, String[] words) {
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0 || words == null || words.length == 0){
        	return ret;
        }
        
        for(int i = 0; i < words.length; i++){
        	insert(words[i]);
        }        
      
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				search(board, i, j, root, "");
			}
		}       
        
        return ret;
    }
}