import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	class MyComparator implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			long l1l2 = Long.parseLong(o1 + o2);
			long l2l1 = Long.parseLong(o2 + o1);
			if(l1l2 > l2l1){
				return 1;
			}else if(l2l1 > l1l2){
				return -1;
			}else{
				return 0;
			}
		}
		
	}
	
    public String largestNumber(int[] nums) {
    	String arrays[] = new String[nums.length];
    	for(int i = 0; i < nums.length; i++){
    		arrays[i] = "" + nums[i];
    	}
    	
    	StringBuilder ret = new StringBuilder("");
    	
        MyComparator myComparator = new MyComparator();
    	
    	Arrays.sort(arrays, myComparator);
    	
    	for(int i = nums.length - 1; i >= 0; i--){
    		ret.append(arrays[i]);
    	}
        
    	if(ret.charAt(0) == '0'){
    		return "0";
    	}
    	
    	return ret.toString();
    }
}