package chapter3;

import java.util.Arrays;
import java.util.Scanner;

public class n008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
        }
        int count = 0;
        Arrays.sort(A);

        for(int k=0; k<N; k++){
            int start_index = 0;
            int end_index = k;
            long find = A[k];
            while(start_index < end_index){
                if(A[start_index]+A[end_index] == find){
                    if((start_index!=k) && (end_index!=k)){
                        count++;
                        break;
                    } else if(start_index == k){
                        start_index++;
                    } else if(end_index == k){
                        end_index--;
                    }
                }
                else if(A[start_index]+A[end_index] < find){
                    start_index++;
                }
                else end_index--;
            }
        }
        System.out.println(count);
    }
}
