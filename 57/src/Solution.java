import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
	class IntervalComparator implements Comparator<Interval>{

		@Override
		public int compare(Interval o1, Interval o2) {
			// TODO Auto-generated method stub
			return o1.start - o2.start;
		}
		
	}
	
    public List<Interval> merge(List<Interval> intervals) {
    	if(intervals == null){
    		return null;
    	}
    	
    	if(intervals.size() == 1){
    		return intervals;
    	}
    	
    	Collections.sort(intervals, new IntervalComparator());
    	
    	int i = 0;
    	while( i + 1 < intervals.size()){
    		if(intervals.get(i + 1).start >= intervals.get(i).start && 
    		   intervals.get(i + 1).start <= intervals.get(i).end ){
    			if(intervals.get(i + 1).end > intervals.get(i).end){
    				int begin  = intervals.get(i).start;
    				int end = intervals.get(i + 1).end;
    				
    				intervals.remove(i);
    				intervals.remove(i);
    				
    				intervals.add(i, new Interval(begin,end));
    			}else {
    				intervals.remove(i + 1);
    			}
    		}else{
    			i++;
    		}
    	}
        
    	return intervals;
    }
	
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	if(intervals == null || newInterval == null){
    		return null;
    	}
    	
    	intervals.add(new Interval(newInterval.start, newInterval.end));
    	merge(intervals);
    	return intervals;        
    }
}