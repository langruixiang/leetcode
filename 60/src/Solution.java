public class Solution {
	
	private void reverseBuffer(StringBuffer buffer,int begin,int end){
		while(begin < end){
			char tmp = buffer.charAt(begin);
			buffer.setCharAt(begin, buffer.charAt(end));
			buffer.setCharAt(end, tmp);
			
			begin++;
			end--;
		}
		
	}
	
	private String nextPermutation(String s){
		StringBuffer buffer = new StringBuffer(s);
		
		int j = buffer.length() - 1;
		while(j - 1 >= 0 && buffer.charAt(j - 1) > buffer.charAt(j)){
			j--;
		}
		
		if(j == 0){
			buffer.reverse();
			return new String(buffer);
		}
		
		int i = j - 1;
		while(j + 1 < buffer.length() && buffer.charAt(j + 1) > buffer.charAt(i)){
			j++;
		}
		
		char tmp = buffer.charAt(i);
		buffer.setCharAt(i, buffer.charAt(j));
		buffer.setCharAt(j, tmp);
		
		reverseBuffer(buffer, i + 1, buffer.length() - 1);
		
		return new String(buffer);
	}
	
	private int delta(int n){
		int ret = 1;
		n--;
		while(n > 1){
			ret *= n;
			n--;
		}
		
		return ret;
	}
	
    public String getPermutation(int n, int k) {
    	if(n < 1 || k < 1){
    		return null;
    	}
    	
    	int start = 0;
    	
    	int delta = delta(n);
    	
    	for(int i = 0; i < n; i++){
    		if(k <= delta * (i + 1) && k > delta * i){
    			start = i + 1;
    			break;
    		}
    	}
    	
    	String ret = "" + start;
    	for(int i = 1; i < start; i++){
    		ret += i;
    	}
    	
    	for(int i = start + 1; i <= n; i++){
    		ret += i;
    	}
        
    	for(int i = delta * (start - 1) + 1; i < k; i++){
    		ret = nextPermutation(ret);
    	}
    	
    	return ret;
    }
}