package zhihu.second;

import java.util.Scanner;

/**
 * 二分查找
 *
 */
public class Main{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //数组长度
        int n = in.nextInt();
        //目标值
        int tar = in.nextInt();

        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }

        int index = binarySearch(a, tar);
        System.out.println(index);
    }

    /**
     * 二分查找
     * @param arr 数组
     * @param tar 目标值
     * @return 目标值在数组arr中的下标，如果找不到目标值，返回-1，如果存在多个连续的目标值，返回最后一个匹配的位置
     *
     */
    public static int binarySearch(int[] arr, int tar){
        //二分查找的几个重要的指针，start end mid
        int start = 0, end = arr.length - 1, mid;
        while(start < end){
            mid = start + (end - start) / 2;
            if(arr[mid] < tar){
                start = mid + 1;
            }
            else if(arr[mid] > tar){
                end = mid;
            }
            else if(arr[mid] == tar){
                if(mid < arr.length - 1){
                    if(arr[mid + 1] == tar){
                        start = mid + 1;
                    }
                    else{
                        return mid;
                    }
                }
                else{
                    return mid;
                }
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}

