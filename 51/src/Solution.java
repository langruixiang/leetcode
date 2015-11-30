import java.util.ArrayList;
import java.util.List;

public class Solution {
	private boolean checkPlate(char[][] plate){
		for(int i = 0; i < plate.length; i++){
			int counter = 0;
			for(int j = 0; j < plate.length; j++){
				if(plate[i][j] == 'Q'){
					counter++;
					
					int di = i - 1;
					int dj = j - 1;
					
					while(di >= 0 && dj >= 0){
						if(plate[di][dj] == 'Q'){
							return false;
						}
						di--;
						dj--;
					}
					
					di = i + 1;
					dj = j + 1;
					
					while(di < plate.length && dj < plate.length){
						if(plate[di][dj] == 'Q'){
							return false;
						}
						di++;
						dj++;
					}
					
					di = i - 1;
					dj = j + 1;
					while(dj < plate.length && di >= 0){
						if(plate[di][dj] == 'Q'){
							return false;
						}
						di--;
						dj++;
					}
					
					di = i + 1;
					dj = j - 1;
				    while(di < plate.length && dj >= 0){
				    	if(plate[di][dj] == 'Q'){
				    		return false;
				    	}
				    	di++;
				    	dj--;
				    }
				
				}
			}
			
			if(counter > 1){
				return false;
			}
		}
		
		for(int i = 0; i < plate.length; i++){
			int counter = 0;
			for(int j = 0; j < plate.length; j++){
				if(plate[j][i] == 'Q'){
					counter++;
				}
			}
			
			if(counter > 1){
				return false;
			}
		}
		
		return true;
	}
	
	private List<List<String>> ret = new ArrayList<List<String>>();
	
	public void solve(char[][] plate,int row){
		if(row == plate.length){
			List<String> item = new ArrayList<String>();
			for(int i = 0; i < plate.length; i++){
				String s = "";
				for(int j = 0; j < plate.length; j++){
					s += plate[i][j];
				}
				item.add(s);
			}
			
			ret.add(item);
			return ;
		}
		
		for(int i = 0; i < plate.length; i++){
			char[][] plateNew = new char[plate.length][];
			
			for(int j = 0; j < plate.length;j++){
				plateNew[j] = new char[plate.length];
				for(int k = 0; k < plate.length; k++){
					plateNew[j][k] = plate[j][k];
				}
			}
			
			plateNew[row][i] = 'Q';
			if(checkPlate(plateNew)){
				solve(plateNew,  row + 1);
			}
		}
	}
	
    public List<List<String>> solveNQueens(int n) {
    	char[][] plate = new char[n][];
    	
    	for(int i = 0; i < n; i++){
    		plate[i] = new char[n];
    		for(int j = 0; j < n; j++){
    			plate[i][j] = '.';
    		}
    	}
    	
    	solve(plate, 0);
    	
    	return ret;
    }
}