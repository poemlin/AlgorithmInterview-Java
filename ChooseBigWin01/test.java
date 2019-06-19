package ChooseBigWin01;

import java.util.Scanner;

public class test {
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

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("please input the array: ");
        String s = scan.nextLine();
        String[] s1 = s.split(" ");
        int[] arr = new int[s1.length];
        for(int i = 0; i<s1.length;i++){
            arr[i] = Integer.parseInt(s1[i]);
        }
        int res = win2(arr);
        System.out.println("win result is: "+res);

    }
}
