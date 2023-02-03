package chapter3;

import java.util.Scanner;

public class n002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int scores[] = new int[n];
        for(int i=0; i<n; i++){
            scores[i] = sc.nextInt();
        }
        long sum = 0;
        long max = 0;
        for(int i : scores){
            sum += i;
            if(i>max) max = i;
        }

        System.out.println(sum*100/max/n);
    }
}
