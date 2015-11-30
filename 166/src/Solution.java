import java.util.Hashtable;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
    	long lnumerator = numerator;
    	long ldenominator = denominator;
    	
    	if(ldenominator == 0){
    		return "";
    	}
    	
    	String flag = "";
    	
    	if(lnumerator > 0 && ldenominator < 0){
    		ldenominator = -ldenominator;
    		flag = "-";
    	}else if(lnumerator < 0 && ldenominator > 0){
    		lnumerator = -lnumerator;
    		flag = "-";
    	}
    	
    	
    	long zhengshu  = lnumerator / ldenominator;
    	
    	lnumerator = lnumerator % ldenominator;
    	
    	if(lnumerator == 0){
    		return flag + zhengshu;
    	}
    	
    	StringBuilder xiaoshu = new StringBuilder("");
    	Hashtable<Long,Integer> ht = new Hashtable<Long,Integer>();
    	
    	while(lnumerator != 0 && !ht.containsKey(lnumerator)){
    		ht.put(lnumerator,xiaoshu.length());
    		lnumerator *= 10;    		
    		
    		long tmp = lnumerator / ldenominator;
    		xiaoshu.append(tmp);
    		
    		lnumerator = lnumerator % ldenominator;    		
    	}
    	
    	if(lnumerator == 0){
    		return flag + zhengshu + "." + xiaoshu;
    	}else{
    		int index = ht.get(lnumerator);
    		xiaoshu.insert(index,'(');
    		xiaoshu.append(')');
    		
    		return flag + zhengshu + "." + xiaoshu;
    	}        
    }
}