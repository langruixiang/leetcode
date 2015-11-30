import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	if(numCourses == 0){
    		return true;
    	}
    	
    	int[] indegree = new int[numCourses];
    	
    	Hashtable<Integer, List<Integer>> ht = new Hashtable<Integer, List<Integer>>();
    	
    	for(int i = 0; i < prerequisites.length; i++){
    		int[] edge = prerequisites[i];
    		
    		indegree[edge[0]]++;
    		List<Integer> list = null;
    		if(ht.containsKey(edge[1])){
    			list = ht.get(edge[1]);
    		}else{
    			list = new ArrayList<Integer>();
    			ht.put(edge[1], list);
    		}
    		
    		list.add(edge[0]);
    	}
    	
    	int counter = 0;
    	while(counter < numCourses){
    		int i;
    		for(i = 0; i < numCourses; i++){
    			if(indegree[i] == 0){
    				indegree[i] = -1;
    				break;
    			}
    		}
    		
    		if(i == numCourses){
    			return false;
    		}
    		
    		counter++;
    		if(ht.containsKey(i)){
    			List<Integer> list = ht.get(i);
        		for(int j = 0; j < list.size(); j++){
        			indegree[list.get(j)]--;
        		}    
    		}
    	}
    	
    	return true;
        
    }
}