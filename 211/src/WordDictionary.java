import java.util.HashMap;
import java.util.Map;

class TrieNode {
	public boolean isEnd = false;;
	public char c;
	public Map<Character,TrieNode> sons = new HashMap<Character,TrieNode>();
	
	public TrieNode(char c){
		this.c = c;
	}
	
	public TrieNode(){
		
	}
}

public class WordDictionary {
	TrieNode root = new TrieNode();

	private boolean searchHelper(TrieNode root,String word,int begin){
		if(begin == word.length()){
			return root.isEnd;
		}
		
		char c = word.charAt(begin);
		
		if(c == '.'){
			for(Map.Entry<Character,TrieNode> entry : root.sons.entrySet()){
				if(searchHelper(entry.getValue(), word, begin + 1)){
					return true;
				}					
			}
			
			return false;			
		}else{
			if(root.sons.containsKey(c)){
				return searchHelper(root.sons.get(c),word,begin + 1);
			}else{
				return false;
			}
		}
		
	}
	
    // Adds a word into the data structure.
    public void addWord(String word) {
    	TrieNode iterator = root;
    	
    	for(int i = 0; i < word.length(); i++){
    		char c = word.charAt(i);
    		if(iterator.sons.containsKey(c)){
    			iterator = iterator.sons.get(c);
    		}else{
    			TrieNode tmp = new TrieNode(c);
    			iterator.sons.put(c, tmp);
    			iterator = tmp;
    		}
    	}
    	
    	iterator.isEnd = true;        
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {    	
    	return searchHelper(root, word, 0);        
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");