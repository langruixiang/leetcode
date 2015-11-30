public class Solution {
	private int findHIndex(int[] citations,int left,int right){
		if(right < left){
			return 0;
		}
		
		if(left == right){
			if(citations[left] >= citations.length - left){
				return citations.length - left;
			}
			
			return 0;
		}
		
		int mid = (left + right) / 2;
		
		if(citations[mid] == citations.length - mid){
			return citations.length - mid;
		}else if(citations[mid] > citations.length - mid){
			return Math.max(citations.length - mid, findHIndex(citations, left, mid - 1));
		}else{
			return findHIndex(citations, mid + 1, right);
		}
	}
	
    public int hIndex(int[] citations) {
    	if(citations == null || citations.length == 0){
    		return 0;
    	}
    	
    	return findHIndex(citations, 0, citations.length - 1);        
    }
}