import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {

	private int bfs(List<List<Integer>> edge,int root,int[] distance,int[] pre){
	    int ret = 0;
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
					ret = son;
				}
			}		
		}	
		
		return ret;
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
		
		int u = bfs(edge,0,dis,pre);
		
		int v = bfs(edge,u,dis,pre);
		
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