import java.util.List;
//
//public class Solution {
//	private int min = Integer.MAX_VALUE;
//	
//	private void minPath(List<List<Integer>> triangle,int i,int j,int sum){
//		if(i == triangle.size() - 1){
//			min = min < sum ? min : sum;
//			return ;
//		}
//		
//		minPath(triangle, i + 1, j, sum + triangle.get(i + 1).get(j));
//		minPath(triangle, i + 1, j + 1, sum + triangle.get(i + 1).get(j + 1));
//	}
//	
//    public int minimumTotal(List<List<Integer>> triangle) {
//    	if(triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0){
//    		return 0;
//    	}
//    	
//    	minPath(triangle, 0, 0, triangle.get(0).get(0));
//    	
//    	return min;        
//    }
//}

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
    	if(triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0){
    		return 0;
    	}
    	
       int[] counter1 = new int[triangle.get(triangle.size() - 1).size()];
       int[] counter2 = new int[triangle.get(triangle.size() - 1).size()];
       
       int[] father = counter1;
       int[] son = counter2;
       
       father[0] = triangle.get(0).get(0);
       
       for(int i = 1; i < triangle.size(); i++){
    	   for(int j = 0; j < i + 1; j++){
    		   long tmp = Long.MAX_VALUE;
    		   if(j - 1 >= 0){
    			   tmp = tmp < father[j - 1] ? tmp : father[j - 1];
    		   }
    		   
    		   if(j < i){
    			   tmp = tmp < father[j] ? tmp : father[j];
    		   }
    		   
    		   son[j] = (int)tmp + triangle.get(i).get(j);
    	   }
    	   
    	   int[] swaptmp = father;
    	   father = son;
    	   son = swaptmp;
       }
       
       long ret = Long.MAX_VALUE;
       for(int i = 0; i < triangle.get(triangle.size() - 1).size(); i++){
    	   ret = ret < father[i] ? ret : father[i];
       }
       
       return (int)ret;
    }
}