package ChooseBigWin01;

import java.util.Arrays;

public class ChooseBigWin {
    /*
    win1: 递归
     */
    public static int win1(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }

        return Math.max(f(arr, 0, arr.length-1), s(arr, 0, arr.length-1));
    }
    // f:先手最大收益
    public static int f(int[] arr, int i, int j){
        if(i == j)
            return arr[i];

        return Math.max(arr[i]+s(arr, i+1, j), arr[j]+s(arr, i, j-1));
    }
    // s:后手最大收益
    public static int s(int[] arr, int i, int j){
        if(i == j)
            return 0;
        return Math.min(f(arr, i+1, j), f(arr, i, j-1));
    }

    /*
    win2:根据依赖关系建立动态规划表
     */

    public static int win2(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }

        // 建立两张动态规划表
        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];

        // 建表：从对角线顺序每个点开始竖直向上
        for(int j = 0; j<arr.length; ++j){
            f[j][j] = arr[j];
            s[j][j] = 0;
            for(int i = j-1; i>=0; --i){
                f[i][j] = Math.max(arr[i]+s[i+1][j], arr[j]+s[i][j-1]);
                s[i][j] = Math.min(f[i+1][j], f[i][j-1]);
            }
        }

        return Math.max(f[0][arr.length-1], s[0][arr.length-1]);
    }

    /*
    todo: 仅先手递归
     */



    /*
    test case
     */
    public static int[] generateRandomArray(){
        // 定义一个随机数组，数组大小0-20
        int[] res = new int[(int) (Math.random() * 20) + 1];
        for(int i = 0; i<res.length; i++){
            res[i] = (int) (Math.random() * 20);
        }
        return res;
    }

    public static void main(String[] args){
        int testTimes = 5;
        for(int i = 0; i<testTimes; i++){
            int[] arr = generateRandomArray();
            System.out.println(Arrays.toString(arr));
            System.out.println(win1(arr));
            System.out.println(win2(arr));
        }
    }

}

