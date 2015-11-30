public class Solution {
    public int minDistance(String word1, String word2) {
    	if(word1 == null && word2 == null){
    		return 0;
    	}
    	
    	if(word1 == null && word2 != null){
    		return word2.length();
    	}
    	
    	if(word1 != null && word2 == null){
    		return word1.length();
    	}
    	
    	int [][]score  = new int[word1.length() + 1][];
    	for(int i = 0; i < word1.length() + 1; i++){
    		score[i] = new int[word2.length() + 1];
    	}
    	
    	for(int i = 0; i < word1.length() + 1; i++){
    		score[i][0] = i;
    	}
    	
    	for(int i = 0; i < word2.length() + 1; i++){
    		score[0][i] = i;
    	}
    	
    	for(int i = 1; i < word1.length() + 1; i++){
    		for(int j = 1; j < word2.length() + 1; j++){
    			int num1;
    			if(word1.charAt(i - 1) == word2.charAt(j - 1)){
    				num1 = score[i - 1][j - 1];
    			}else{
    				num1 = score[i -1][j - 1] + 1;
    			}
    			
    			int num2 = score[i - 1][j] + 1;
    			int num3 = score[i][j - 1] + 1;
    			
    			score[i][j] = Math.min(num1, Math.min(num2, num3));
    		}
    	}
    	
        return score[word1.length()][word2.length()];
    }
}