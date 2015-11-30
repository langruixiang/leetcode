import java.util.Hashtable;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
	private Hashtable<UndirectedGraphNode,UndirectedGraphNode> ht = new Hashtable<UndirectedGraphNode,UndirectedGraphNode>();
	
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if(node == null){
    		return null;
    	}
    	
    	if(ht.containsKey(node)){
    		return ht.get(node);
    	}
    	
    	UndirectedGraphNode ret = new UndirectedGraphNode(node.label);
    	ht.put(node, ret);
    	for(int i = 0; i < node.neighbors.size(); i++){
    		ret.neighbors.add(cloneGraph(node.neighbors.get(i)));
    	}
    	
    	return ret;        
    }
}