import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] height) {  
        if (height == null || height.length == 0) return 0;  
          
        int maxArea = 0;  
        Stack<Integer> stackHeight = new Stack<Integer>();  
        Stack<Integer> stackIndex = new Stack<Integer>();  
          
        for (int i = 0; i < height.length; i++) {  
            //case 1  
            if (stackHeight.isEmpty() || height[i] > stackHeight.peek()) {  
                stackHeight.push(height[i]);  
                stackIndex.push(i);  
            } else if (height[i] < stackHeight.peek()) {  
                // case 3  
                int lastIndex = 0;  
                while (stackHeight.isEmpty() == false && height[i] < stackHeight.peek()) {  
                    lastIndex = stackIndex.pop();  
                    int tempArea = stackHeight.pop() * (i - lastIndex);  
                    if (maxArea < tempArea) {  
                        maxArea = tempArea;  
                    }  
                }  
                stackHeight.push(height[i]);  
                stackIndex.push(lastIndex);  
            }  
        }  
          
        while(stackHeight.isEmpty() == false) {  
            int tempArea = stackHeight.pop() * (height.length - stackIndex.pop());  
            if (tempArea > maxArea) {  
                maxArea = tempArea;  
            }  
        }  
        return maxArea;  
    }  
}
