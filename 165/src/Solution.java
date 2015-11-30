public class Solution {
    public int compareVersion(String version1, String version2) {
    	if(version1 == null || version1.length() == 0 || version2 == null || version2.length() == 0){
    		return 0;
    	}
    	
    	String items1[] = version1.split("\\.");
    	String items2[] = version2.split("\\.");
    	
    	int i = 0;
    	while(i < items1.length && i < items2.length){
    		if(Integer.parseInt(items1[i]) > Integer.parseInt(items2[i])){
    			return 1;
    		}else if(Integer.parseInt(items1[i]) < Integer.parseInt(items2[i])){
    			return -1;
    		}
    		i++;
    	}
    	
    	if(i == items1.length && i == items2.length){
    		return 0;
    	}else if(i == items1.length){
    		while(i < items2.length){
    			if(Integer.parseInt(items2[i]) == 0){
    				i++;
    			}else{
    				return -1;
    			}
    		}
    		
    		return 0;
    	}else{
    		while(i < items1.length){
    			if(Integer.parseInt(items1[i]) == 0){
    				i++;
    			}else{
    				return 1;
    			}
    		}
    		return 0;
    	}
        
    }
}