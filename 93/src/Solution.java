import java.util.ArrayList;
import java.util.List;

public class Solution {
	private List<String> ret = new ArrayList<String>();
	
	private void restore(String s, int num,int begin, String pre){
		if(begin == s.length()){
			return ;
		}
		
		if(num == 0){
			if(s.charAt(begin) != '0' && Long.parseLong(s.substring(begin, s.length())) < 256 || s.substring(begin,s.length()).equals("0")){
				pre += s.substring(begin, s.length());
				ret.add(pre);
			}
			return ;
		}
		
		
		int len;
		if(s.charAt(begin) == '0'){
			len = 1;
		}else{
			len = 3;
		}
		
		for(int i = 1; i <= len; i++){
			if(begin + i > s.length()){
				return ;
			}
			String tmp = s.substring(begin,begin + i);
			if(Integer.parseInt(tmp) < 256){
				String preTmp = pre + tmp + ".";
				restore(s, num - 1, begin + i, preTmp);
			}
		}
		
	}
	
    public List<String> restoreIpAddresses(String s) {
    	if(s == null || s.length() < 4 || s.length() > 12){
    		return ret;
    	}
    	
        restore(s, 3, 0, "");
        
        return ret;
    }
}