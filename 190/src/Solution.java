public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ret = 0;
        int bit;
        for(int i = 0; i < 32; i++){
            bit = n & 1;
            n >>= 1;
        
            ret <<= 1;
            ret = ret | bit;               
        }
        
        return ret;
    }
}