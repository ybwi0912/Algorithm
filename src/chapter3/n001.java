package chapter3;

import java.util.Scanner;

public class n001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for(char i : cNum){
            sum += i-'0';
        }
        System.out.println(sum);
    }
}
