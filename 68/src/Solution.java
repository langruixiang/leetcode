import java.util.ArrayList;
import java.util.List;

public class Solution {
	private List<String> ret = new ArrayList<String>();
	
	private StringBuilder createSpace(int num){
		StringBuilder tmp = new StringBuilder("");
		for(int i = 0; i < num; i++){
			tmp.append(" ");
		}
		
		return tmp;
	}
	
    public List<String> fullJustify(String[] words, int maxWidth) {
        if(words == null || words.length == 0 || maxWidth <= 0){
        	ret.add("");
        	return ret;
        }        
        
    	int index = 0;
        while(index < words.length){
        	List<StringBuilder> line = new ArrayList<StringBuilder>();
        	
        	int len = maxWidth;
        	int wordCounter = 0;
        	while(len - wordCounter >= words[index].length()){
        		StringBuilder tmp = new StringBuilder(words[index]);
        		
        		line.add(tmp);
        		wordCounter++;
        		
        		len -= words[index].length();
        		index++;
        		
        		if(index == words.length){
        			StringBuilder lastword = line.get(line.size() - 1);
        			lastword.append(createSpace(len - wordCounter + 1));
        			
        			StringBuilder lineBuffer = new StringBuilder("");
        			
        			for(int i = 0; i < line.size() - 1; i++){
        				lineBuffer.append(line.get(i) + " ");
        			}
        			
        			lineBuffer.append(line.get(line.size() - 1));
        			
        			ret.add(new String(lineBuffer));
        			
        			return ret;
        		}
        	}        	
        	
        	if(wordCounter == 1){
        		StringBuilder lastword = line.get(0);
    			lastword.append(createSpace(len));
    			
    			ret.add(new String(lastword));
        		
        	}else{        		
        		int meanSpace = len / (wordCounter - 1);
            	int extraNum = len % (wordCounter - 1);
            	
            	StringBuilder lineBuffer = new StringBuilder("");
            	
            	for(int i = 0; i < extraNum; i++){
            		lineBuffer.append(line.get(i)).append(createSpace(meanSpace + 1));
            	}
            	
            	for(int i = extraNum; i < wordCounter - 1; i++){
            		lineBuffer.append(line.get(i)).append(createSpace(meanSpace));
            	}
            	
            	lineBuffer.append(line.get(wordCounter - 1));
            	
            	ret.add(new String(lineBuffer)); 
        	}
        }
        
        return ret;
    }
}