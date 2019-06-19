package LongBrackets03;

import java.util.Arrays;
import java.util.Scanner;

public class LongBrackets {
    public static int longB(String arr){
        char[] ch = arr.toCharArray();
        int[] dp = new int[ch.length];
        // 0位置为0
        dp[0] = 0;
        // 以左括号结尾的为0
        for(int i = 1; i<ch.length; i++){
            if(ch[i] == '(')
                dp[i] = 0;
        }
        // 分析以右括号结尾情况
        for(int i = 1; i<ch.length; i++){
            if(ch[i] == ')'){

                int pre = i-dp[i-1]-1;

                if(pre>=0 && ch[pre] == '('){
                    dp[i] = dp[i-1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
                else
                    dp[i] = 0;
            }
        }

        Arrays.sort(dp);
        return dp[dp.length-1];

    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("please input the brackets set: ");
        String bra = scan.nextLine();
        int res = longB(bra);

        System.out.println(res);
    }


}
