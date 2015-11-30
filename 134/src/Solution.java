public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	if(gas == null || gas.length == 0 || cost == null || cost.length == 0 || gas.length != cost.length){
    		return -1;
    	}
    	
    	int sum = 0;
    	int startPos = 0;
    	
    	int allSum = 0;
    	
    	for(int i = 0; i < cost.length; i++){
    		sum += (gas[i] - cost[i]);
    		
    		allSum += (gas[i] - cost[i]);
    		
    		if(sum < 0){
    			sum = 0;
    			startPos = i + 1;
    		}
    	}
    	
    	return allSum < 0 ? -1 : startPos;
        
    }
}