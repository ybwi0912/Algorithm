package boj;

import java.util.Scanner;

/**
 * 2023-06-19
 * Selection Sorting
 * */

public class B1427_소트인사이드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int[] arr = new int[input.length()];

        for(int i=0; i<input.length(); i++){
            arr[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }
        // input

        selectionSort(arr);
        // operation

        for(int i : arr){
            System.out.print(i);
        }
        // output
    }

    public static void selectionSort(int[] arr){
        int index = 0;
        int len = arr.length;

        while(index < len){
            int max = arr[index];
            int maxIdx = index;

            for(int i = index; i<len; i++){
                if(arr[i]>max){
                    max = arr[i];
                    maxIdx = i;
                }
            }
            swap(arr, index, maxIdx);

            index++;
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
