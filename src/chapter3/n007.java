package chapter3;

import java.util.Arrays;
import java.util.Scanner;

public class n007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int start_index = 0;
        int end_index = N-1;
        int count = 0;
        int[] A = new int[N];

        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);

        while(start_index < end_index){
            if (A[start_index] + A[end_index] < M) {
                start_index++;
            }
            else if (A[start_index] + A[end_index] > M){
                end_index--;
            }
            else{
                start_index++;
                end_index--;
                count++;
            }
        }
        System.out.println(count);
    }
}
