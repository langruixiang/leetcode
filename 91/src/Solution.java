//public class Solution {
//	private int findNumOfWays(String s,int begin,int end){
//		if(begin > end){
//			return 1;
//		}
//		
//		if(begin == end){
//			if(s.charAt(begin) == '0'){
//				return 0;
//			}else{
//				return 1;
//			}
//		}
//		
//		int ret = 0;
//		
//		int mid = (begin + end) / 2;
//		
//		int leftNum = findNumOfWays(s, begin, mid);
//		int rightNum = findNumOfWays(s, mid + 1, end);
//		
//		ret += leftNum * rightNum;
//		
//		if(s.charAt(mid) != '0' && Integer.parseInt(s.substring(mid,mid + 2)) <= 26){
//			leftNum = findNumOfWays(s, begin, mid - 1);
//			rightNum = findNumOfWays(s, mid + 2, end);
//			ret += leftNum * rightNum;
//		}
//		
//		return ret;
//		
//	}
//	
//    public int numDecodings(String s) {
//        if(s == null || s.length() == 0){
//        	return 0;
//        }
//        
//        return findNumOfWays(s, 0, s.length() - 1);
//    }
//}

public class Solution {
	public int numDecodings(String s) {
		if(s == null || s.length() == 0 || s.charAt(0) == '0'){
			return 0;
		}
		
		int []counter = new int[s.length()];
		
		counter[0] = 1;
		
		if(s.length() == 1){
			return 1;
		}
		
		if(s.charAt(1) == '0' && (s.charAt(0) == '1' || s.charAt(0) == '2')){
			counter[1] = 1;
		}else if(s.charAt(1) != '0' && Integer.parseInt(s.substring(0,2)) <= 26){
			counter[1] = 2;
		}else if(s.charAt(1) != '0' && Integer.parseInt(s.substring(0,2)) > 26){
			counter[1] = 1;
		}else{
			counter[1] = 0;
		}
		
		for(int i = 2; i < counter.length; i++){
			if(s.charAt(i) == '0' && (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2')){
				counter[i] = counter[i - 2];
			}else if(s.charAt(i) != '0' && (s.charAt(i - 1) == '0' || Integer.parseInt(s.substring(i - 1, i + 1)) > 26)){
				counter[i] = counter[i - 1];
			}else if(s.charAt(i) != '0' && Integer.parseInt(s.substring(i - 1, i + 1)) <= 26){
				counter[i] = counter[i -1 ] + counter[i - 2];
			}else{
				counter[i] = 0;
			}
		}
		
		return counter[counter.length - 1];
	}
}