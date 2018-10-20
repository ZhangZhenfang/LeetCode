package _9_Palindrome_Number;

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)return false;
        int n = x;
        int tmp = 0;
        while(x > 0){
            tmp = tmp * 10 + (x % 10);
            x /= 10;
        }
        if(tmp == n)return true;
        else return false;
    }
}
