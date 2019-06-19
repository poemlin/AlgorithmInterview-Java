package trueBrackets02;

import java.util.Scanner;

public class Truebrackets {
    public static boolean isTruebrackets(String s){
        if(s == null || s.equals("")){
            return false;
        }
        // string->chararray
        char[] ch = s.toCharArray();
        int flag = 0;

        for(int i = 0; i<ch.length; i++) {
            if (ch[i] == '(') {
                flag++;
            } else {
                flag--;
                if (flag < 0)
                    return false;
            }
        }
        // 判断返回的写法
        return flag == 0;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("please input the brackets set: ");
        String bra = scan.nextLine();
        boolean res =  isTruebrackets(bra);
        System.out.println(res);
    }
}
