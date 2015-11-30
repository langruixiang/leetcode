public class Solution {
	
	
	private int C(int n,int m){
		if(n == 0 || m == 0){
			return 1;
		}
		
		double ret = 1;
		
		double num = n - m;
		while(num >= 1){
			ret *= (n / num);
			n--;
			num--;
		}
		
		return (int)(ret + 0.5);
	}
	
    public int uniquePaths(int m, int n) {
    	int down = m - 1;
    	int right = n - 1;
    	
    	int sum = down + right;
    			
        return C(sum,down);
    }
}