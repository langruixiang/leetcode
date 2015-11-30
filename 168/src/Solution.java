public class Solution {
    public String convertToTitle(int n) {
        StringBuilder ret = new StringBuilder("");
        char a = 'A';
        int index;
        
        n--;
        while(n >= 26){
            index = n % 26;
            char tmp = (char) (a + index);
            ret.insert(0,tmp);
            n /= 26;
            n--;
        }
        
        index = n;
        char tmp = (char) (a + index);
        ret.insert(0,tmp);
        
        return ret.toString();
    }
}