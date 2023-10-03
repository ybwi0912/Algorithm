package boj;

import java.util.Scanner;
import java.util.Stack;

public class B2504_괄호의값 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char[] arr = input.toCharArray();
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        char before = '0';

        int temp = 1;

        for(char c : arr){
            if(c=='('){
                temp *= 2;
                stack.add(c);
            }
            else if(c=='['){
                temp *= 3;
                stack.add(c);
            }
            else if(c==')'){
                if(stack.isEmpty() || stack.peek()!='('){
                    ans = 0;
                    break;
                }
                else if(before=='('){
                    ans += temp;
                }
                stack.pop();
                temp /= 2;
            }
            else if(c==']'){
                if(stack.isEmpty() || stack.peek()!='['){
                    ans = 0;
                    break;
                }
                else if(before=='['){
                    ans += temp;
                }
                stack.pop();
                temp /= 3;
            }
            before = c;
        }

        if(!stack.isEmpty()) ans = 0;
        System.out.println(ans);
    }
}
