import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
//	private int minHeight = Integer.MAX_VALUE;
//	private List<List<Integer>> edge = new ArrayList<List<Integer>>();	
//	private int[] heights;
//	
//	private List<Integer> ret = new ArrayList<>();
//	
//	private int getHeight(int root,int height,Set<Integer> visited){
//		visited.add(root);
//		
//		List<Integer> sons = edge.get(root);
//		
//		int ret = height;
//		for(int i : sons){
//			if(!visited.contains(i)){
//				int h = getHeight(i, height + 1,visited);
//				if(h > ret){
//					ret = h;
//				}
//			}
//		}
//		
//		visited.remove(root);
//		return ret;		
//	}
//	
//    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//        for(int i = 0; i < n; i++){
//        	edge.add(new ArrayList<>());
//        }
//        
//        heights = new int[n];
//        
//        for(int i = 0; i < edges.length; i++){
//        	int from = edges[i][0];
//        	int to = edges[i][1];
//        	
//        	edge.get(from).add(to);
//        	edge.get(to).add(from);
//        }
//        
//        
//        Set<Integer> visited = new HashSet<>();
//        for(int i = 0; i < n; i++){
//        	int height = getHeight(i,1,visited);
//        	if( height < minHeight){
//        		minHeight = height;
//        	}
//        	
//        	heights[i] = height;
//        }
//        
//        for(int i = 0; i < n; i++){
//        	if(heights[i] == minHeight){
//        		ret.add(i);
//        	}
//        }
//        
//        return ret;
//    }

	private void bfs(List<List<Integer>> edge,int root,int[] distance,int[] pre){
		Set<Integer> visited = new HashSet<>();
		
		distance[root] = 0;
		pre[root] = - 1;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(root);
		visited.add(root);
		
		while(!queue.isEmpty()){
			int father = queue.poll();
			List<Integer> sons = edge.get(father);
			for(int son : sons){
				if(!visited.contains(son)){
					distance[son] = distance[father] + 1;
					pre[son] = father;
					queue.add(son);
					visited.add(son);
				}
			}		
		}		
	}
	
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<List<Integer>> edge = new ArrayList<>();
		for(int i = 0; i < n; i++){
			edge.add(new ArrayList<>());
		}
		
		for(int i = 0; i < edges.length; i++){
			int from = edges[i][0];
			int to = edges[i][1];
			
			edge.get(from).add(to);
			edge.get(to).add(from);
		}
		
		int[] dis = new int[n];
		int[] pre = new int[n];
		
		bfs(edge,0,dis,pre);
		int max = Integer.MIN_VALUE;
		int u = 0;
		for(int i = 0; i < dis.length; i++){
			if(dis[i] > max){
				max = dis[i];
				u = i;
			}
		}
		
		bfs(edge,u,dis,pre);
		int v = 0;
		max = Integer.MIN_VALUE;
		for(int i = 0; i < dis.length; i++){
			if(dis[i] > max){
				max = dis[i];
				v = i;
			}
		}
		
		int p = v;
		List<Integer> longestPath = new ArrayList<>();
		
		while(p != - 1){
			longestPath.add(p);
			p = pre[p];
		}
		
		List<Integer> ret = new ArrayList<>();
		int longSize = longestPath.size();
		
		if(longSize % 2 == 1){
			ret.add(longestPath.get(longSize / 2));
		}else{
			ret.add(longestPath.get(longSize / 2));
			ret.add(longestPath.get(longSize / 2 - 1));
		}
		
		return ret;        
    }
}