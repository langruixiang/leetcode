import java.util.Hashtable;

class TrieNode {
    // Initialize your data structure here.
	private int count = 0;
	private char c = 0;
	private boolean isEnd = false;;
	private Hashtable<Character,TrieNode> sons = new Hashtable<Character,TrieNode>();
	
    public TrieNode() {
    }
    
    public TrieNode(char c){
    	this.c = c;
    	this.count = 1;
    }
    
    public void increaseCount(){
    	this.count++;
    }
    
    public void setEnd(){
    	this.isEnd = true;
    }
    
    public boolean isEnd(){
    	return this.isEnd;
    }
    
    public Hashtable<Character,TrieNode> getSons(){
    	return this.sons;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
    	if(search(word)){
    		return ;
    	}
    	
    	TrieNode iterator = root;
    	iterator.increaseCount();
    	
    	for(int i = 0; i < word.length(); i++){
    		char c = word.charAt(i);
    		
    		if(iterator.getSons().containsKey(c)){
    			iterator = iterator.getSons().get(c);
    			iterator.increaseCount();
    		}else{
    			TrieNode newNode = new TrieNode(c);
    			iterator.getSons().put(c, newNode);
    			iterator = newNode;
    		}
    	}
    	
    	iterator.setEnd();        
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	TrieNode iterator = root;
    	for(int i = 0; i < word.length(); i++){
    		char c = word.charAt(i);
    		
    		if(!iterator.getSons().containsKey(c)){
    			return false;
    		}else{
    			iterator = iterator.getSons().get(c);
    		}
    	}
    	
    	return iterator.isEnd();        
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	TrieNode iterator = root;
    	for(int i = 0; i < prefix.length(); i++){
    		char c = prefix.charAt(i);
    		
    		if(!iterator.getSons().containsKey(c)){
    			return false;
    		}else{
    			iterator = iterator.getSons().get(c);
    		}
    	}
    	
    	return true;   
        
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");