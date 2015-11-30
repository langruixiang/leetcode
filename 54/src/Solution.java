import java.util.ArrayList;
import java.util.List;

public class Solution {
	private List<Integer> ret = new ArrayList<Integer>();
	
	private void help(int[][] matrix, int delta){
	    int m = matrix.length - 1;
	    int n = matrix[0].length - 1;
		
		int i = delta;
		int j = delta;
		
		while(j <= n - delta){
			ret.add(matrix[i][j]);
			j++;
		}
		
		j--;
		i++;
		
		if(m - 2 * delta == 0){
			return ;
		}
		
		while(i <= m - delta){
			ret.add(matrix[i][j]);
			i++;
		}
		
		i--;
		j--;
		
		if(n - 2 * delta == 0){
			return ;
		}
		
		while(j >= delta){
			ret.add(matrix[i][j]);
			j--;
		}
		
		j++;
		i--;
		
		while(i > delta){
			ret.add(matrix[i][j]);
			i--;
		}
		
		return ;
		
	}
	
    public List<Integer> spiralOrder(int[][] matrix) {
    	if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
    		return ret;
    	}
        
    	int m = matrix.length - 1;
    	int n = matrix[0].length - 1;
    	
    	int delta = 0;
    	while(m >= 0 && n >= 0){
    		help(matrix, delta);
    		delta++;
    		m -= 2;
    		n -= 2;
    	}
    	
    	return ret;
    }
}