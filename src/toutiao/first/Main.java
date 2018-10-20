package toutiao.first;

import java.util.Scanner;

/**
 * 头条第三批笔试，据说比前两次来说很简单
 * LeetCode原题
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        //动态规划，用来记录对应长度的字符串的最长子串的长度
        int[] maxValue = new int[s.length()];
        //输入字符串长度为0，直接输出0后返回
        if(s.length() == 0){
            System.out.println(0);
            return ;
        }
        //初始化
        maxValue[0] = 1;
        //记录最长子串的起始下表
        int index = 0;
        int max = 1;
        for(int i = 1; i < maxValue.length; i++){
            //记录s.charAt(i)在当前字串中的下标
            int indexof = s.substring(index, i).indexOf(s.charAt(i));
            if(indexof == -1){
                maxValue[i] = i - index + 1 > maxValue[i - 1] ? i - index + 1 : maxValue[i - 1] + 1;
                max = max < maxValue[i] ? maxValue[i] : max;
            }
            else{
                index = index + indexof + 1;//关键点，如果包含重复的字符，从哪里从新开始计数
                maxValue[i] = 1;
            }
        }
        System.out.println(max);
    }
}