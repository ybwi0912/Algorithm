package boj;

import java.util.*;

public class B11399_ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] nArr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        // input

        for(int i=1; i<N; i++){
            int idx = i;
            int value = arr[i];
            for(int j=i-1; j>=0; j--){
                if(arr[j] < arr[i]){
                    idx = j+1;
                    break;
                }
                if(j==0)
                    idx=0;
            }

            for(int j=i; j>idx; j--)
                arr[j] = arr[j-1];
            arr[idx] = value;
        }

        nArr[0] = arr[0];
        for(int i=1; i<N; i++)
            nArr[i] = nArr[i-1] + arr[i];

        int sum=0;
        for(int i=0; i<N; i++)
            sum = sum + nArr[i];

        System.out.println(sum);
    }
}
