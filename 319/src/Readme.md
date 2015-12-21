##LeetCode题目链接：[319. Bulb Switcher](https://leetcode.com/problems/bulb-switcher/)
> There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.</br>
Example:</br>
>
	Given n = 3.
	At first, the three bulbs are [off, off, off].
	After first round, the three bulbs are [on, on, on].
	After second round, the three bulbs are [on, off, on].
	After third round, the three bulbs are [on, off, off].
So you should return 1, because there is only one bulb is on.
##分析：
first round之后，所有灯泡处于on的状态，我们用1表示on，则状态是s = 11111111（n = 8）</br>
second round之后，相当于s = s ^ 01010101</br>
third round之后，相当于s = s ^ 00100100</br>
......</br>
于是，经过nth round之后 s = 11111111 ^ 01010101 ^ 00100100 ^ ...... ^ 00000001
我们仅仅考虑01010101 ^ 00100100 ^ ...... ^ 00000001部分，这部分0的个数即为最终处于on的灯泡的个数。每一位对应一个计数器，所有是2的倍数的位，计数器加一，3的倍数的位计数器加一...最终计数器值是偶数的位，值为0.于是有如下代码：</br>
**源码一：**

	public class Solution {
	    public int bulbSwitch(int n) {
	    	if(n <= 0){
	    		return 0;
	    	}
	    	
	    	if(n == 1){
	    		return 1;
	    	}
	    	
	    	int[] counter = new int[n];
	    	for(int i = 2; i <= n; i++){
	    		int delta = 1;
	    		int product = i * delta;
	    		while(product <= n){
	    			counter[product - 1]++;
	    			product = i * ++delta;
	    		}
	    	}
	    	
	    	int ret = 0;
	    	for(int i = 0; i < n; i++){
	    		if((counter[i] & 1) == 0){
	    			ret ++;
	    		}
	    	}
	    	
	    	return ret;        
	    }
	}
虽然源码中有双重循环，但是复杂度是O(n)的，提交之后，咦？TLE了！于是觉得结果肯定是有规律的，取n = 30打印了结果，结果如下：</br>

	0 1 1 0 1 1 1 1 0 1 1 1 1 1 1 0 1 1 1 1 1 1 1 1 0 1 1 1 1 1 
果然有规律：第1位为0，之后3位出现0，之后5位出现0，然后7,9......
于是有了如下代码：</br>
**源码二**：

	public class Solution {
	    public int bulbSwitch(int n) {
	    	if(n <= 0){
	    		return 0;
	    	}
	    	
	    	int ret = 1;
	    	int acc = 1;
	    	int delta = 3;
	    	while(acc <= n - delta){
	    		ret++;
	    		acc += delta;
	    		delta += 2;
	    	}
	    	return ret;        
	    }
	}
提交之后Accepted了，总感觉好像做笨了，再仔细一看，1<sup>2</sup>位是0，2<sup>2</sup>是0.....,原来，就是求n以内有几个完全平方数，于是有如下代码：</br>
**源码三：**
	
	public class Solution {
	    public int bulbSwitch(int n) {
	    	return (int)Math.sqrt(n);        
	    }
	}
其实，仔细想想就可以知道为什么只有完全平方数是亮着的，对于非完全平方数，其因子一定是成对存在着的，并且1一定是他的一个因子，因此，一定被翻转了奇数次，所以是灭着的；而所有的完全平方数，因为有平方根的存在，因子个数是基数的，又因为1也是他的一个因子，所以翻转了偶数次。于是，只有完全平方数是亮着的，非完全平方数是灭的。如果写代码之前就相当了这点，这道题就是一行代码的事。。。。。。
