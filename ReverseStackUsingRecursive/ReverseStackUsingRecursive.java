package ReverseStackUsingRecursive;


import java.util.Stack;
/*
反转一个栈，我们只需要获得栈底的一个元素，再把剩余的栈反转，再把获得的栈底元素入栈即可
涉及两个主要函数：反转一个栈，获得最后一个元素
 */
public class ReverseStackUsingRecursive {
    public static void  reverse(Stack<Integer> stack){
        if(stack.isEmpty())
            return;

        int i = getAndRemoveLast(stack);
        reverse(stack);
        stack.push(i);
    }

    public static int getAndRemoveLast(Stack<Integer> stack){
        int first = stack.pop();

        if(stack.isEmpty())
            return first;
        else{
            int last = getAndRemoveLast(stack);
            stack.push(first);
            return last;
        }
    }

    public static void  main(String[] args){
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        reverse(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

}
