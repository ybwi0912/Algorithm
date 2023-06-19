package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2023-06-16
 * Sorting Algorithm
 * */

public class B2750_수정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 수의 개수
        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        // input

        // bubbleSort(arr);
        selectionSort(arr);
        // operation

        for(int i : arr){
            System.out.println(i);
        }
        // output
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSort(int[] arr){
        int len = arr.length;
        for(int i=0; i<len-1; i++){
            for(int j=0; j<len-1-i; j++){
                if(arr[j]>arr[j+1])
                    swap(arr, j, j+1);
            }
        }
    }

    public static void selectionSort(int[] arr){
        int index = 0;
        int len = arr.length;
        while(index < len){
            int min = arr[index];
            int minIdx = index;
            for(int i=index; i<len; i++){
                if(arr[i]<min){
                    min = arr[i];
                    minIdx = i;
                }
            }
            swap(arr, minIdx, index);
            index++;
        }
    }
}
