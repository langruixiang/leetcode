import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	
	private void diffusion(char[][] board,Queue<Point> queue){		
		while(!queue.isEmpty()){
			Point iterator = queue.poll();
			
			int i = iterator.i;
			int j = iterator.j;
			
			if(i - 1 >= 0 && board[i - 1][j] == 'O'){
				board[i - 1][j] = ' ';
				queue.add(new Point(i - 1,j));
			}
			
			if(i + 1 < board.length && board[i + 1][j] == 'O'){
				board[i + 1][j] = ' ';
				queue.add(new Point(i + 1, j));
			}
			
			if(j - 1 >= 0 && board[i][j - 1] == 'O'){
				board[i][j - 1] = ' ';
				queue.add(new Point(i,j - 1));
			}
			
			if(j + 1 < board[0].length && board[i][j + 1] == 'O'){
				board[i][j + 1] = ' ';
				queue.add(new Point(i, j + 1));
			}
		}
	}
	
    public void solve(char[][] board) {
    	if(board == null || board.length <= 1 || board[0].length <= 1){
    		return ;
    	}
    	
    	Queue<Point> queue = new LinkedList<Point>();
    	
    	int i = board.length - 1;
    	for(int j = 0; j < board[0].length; j++){
    		if(board[0][j] == 'O'){
    			board[0][j] = ' ';
    			queue.add(new Point(0, j));
    		}
    		
    		if(board[i][j] == 'O'){
    			board[i][j] = ' ';
    			queue.add(new Point(i, j));
    		}
    	}
    	
    	int j = board[0].length - 1;
    	for(i = 1; i < board.length - 1 ; i++){
    		if(board[i][0] == 'O'){
    			board[i][0] = ' ';
    			queue.add(new Point(i, 0));
    		}
    		
    		if(board[i][j] == 'O'){
    			board[i][j] = ' ';
    			queue.add(new Point(i, j));
    		}
    	}
    	
    	diffusion(board, queue);

    	for(i = 0; i < board.length; i++){
			for(j = 0; j < board[0].length; j++){
				if(board[i][j] == ' '){
					board[i][j] = 'O';
				}else if(board[i][j] == 'O'){
					board[i][j] = 'X';
				}
			}
		}
    	
    	return ;
    }
    
    class Point{
    	int i;
    	int j;
    	
    	public Point(int indexi,int indexj){
    		i = indexi;
    		j = indexj;
    	}
    }
}