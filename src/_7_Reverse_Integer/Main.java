package _7_Reverse_Integer;

public class Main {

}

class Solution {
    public int reverse(int x) {
        int res = 1;
        if(x < 0){
            x = -x;
            res = -1;
        }

        long result = 0;
        while(x != 0){
            result = result * 10 + x % 10;
            x /= 10;
        }
        result *= res;
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            result = 0;
        }
        return (int)result;
    }
}
