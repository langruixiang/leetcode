import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
    	if(beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0 || beginWord.length() != endWord.length()){
    		return 0;
    	}
    	
    	Queue<String> queue = new LinkedList<String>();
    	Hashtable<String,Integer> distance = new Hashtable<String,Integer>();
    	
    	queue.add(beginWord);
    	distance.put(beginWord, 1);
    	
    	while(!queue.isEmpty()){
    		String father = queue.poll();
    		StringBuilder iterator = new StringBuilder(father);
    		int iteratorDis = distance.get(father);
    		
    		for(int i = 0; i < iterator.length(); i++){
    			StringBuilder iteTmp= new StringBuilder(iterator); 
    			for(char j = 'a'; j < 'z'; j++){
    				iteTmp.setCharAt(i, j);
    				
    				String word = iteTmp.toString();
    				if(word.equals(endWord)){
    					return iteratorDis + 1;
    				}
    				
    				if(wordList.contains(word) && !distance.containsKey(word)){
    					queue.add(word);
    					distance.put(word, iteratorDis + 1);
    				}
    			}
    		}
    	}
    	
    	return 0;        
    }
}