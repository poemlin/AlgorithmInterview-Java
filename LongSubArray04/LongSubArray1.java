package LongSubArray04;

import java.util.Scanner;

public class LongSubArray1 {

    public static int[] longsub(int[] arr, int k){
        int l = 0;
        int r = 0;
        int lastl = 0;
        int lastr = 0;
        int Max = 0;
        int[] res = new int[3];
        while(r<arr.length){
            if(sumsub(arr, l, r)<k && r<arr.length){
                r++;
            }
            else if(sumsub(arr, l, r) == k){
                int Ma = Math.max(Max, (r-l+1));
                if(Ma!=Max){
                    lastl = l;
                    lastr = r;
                }
                Max = Ma;

                r++;
            }
            else{
                l++;
            }

        }

        res[0] = lastl;
        res[1] = lastr;
        res[2] = Max;
        return res;
    }

    public static int sumsub(int[] arr, int i, int j){
        int sum = 0;
        for(int m = i; m<=j; m++){
            sum += arr[m];
        }
        return sum;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("please input the array: ");
        String s = scan.nextLine();
        System.out.print("please input the k: ");
        int k = scan.nextInt();
        String[] s1 = s.split(" ");
        int[] arr = new int[s1.length];
        for(int i = 0; i<s1.length;i++){
            arr[i] = Integer.parseInt(s1[i]);
        }

        System.out.println(longsub(arr,k)[2]);
        for(int i = longsub(arr, k)[0]; i<=longsub(arr, k)[1]; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
