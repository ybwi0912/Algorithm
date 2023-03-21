package boj;

import java.util.Scanner;

public class B9663_NQueen2 {
    static int N; // 체스판의 크기, 퀸 개수
    static int[] selection; // 현재 선택한 요소
    static boolean[] isSelected; // 마킹 배열 - 선택했는지 체크
    static int arr[];
    static int count = 0;


    static void permutation(int n){ // n : 선택한 개수
        if(n==N) { // R개 선택 완료
            //for(int i=0; i<N; i++) System.out.print(arr[selection[i]]);
            //System.out.println();
            // 대각선 처리하는 조건식이 위치할 것
            int num[] = new int[N];
            for(int i=0; i<N-1; i++){
                num[i] = arr[selection[i]];
                /*int diff = Math.abs(arr[selection[i]]- arr[selection[i+1]]);
                if(diff<=1) return;*/

                /*if(Math.abs(arr[selection[i]] - arr[selection[i+1]]) <= 1) {
                    return;
                }*/

            }

            /*for(int i=0; i<N-1; i++){
                for(int j=i+1; j<N-1; j++){
                    System.out.println(i + " : " + num[i] + ", " + j + " : " + num[j]);
                    if(num[i] + 1 == num[j] || num[i] -1 == num[j]) return;
                }


            }*/

            for(int i=0; i<N; i++){
                for(int j=i-1; j>=0; j--){
                    if(Math.abs(num[i]-num[j]) == Math.abs(i-j)) return;

            }

//            for(int i=0; i<N; i++){
//                for(int j=i; j<N; j++){
//                    if(num[i]-j == num[num[i]])
//                        return;
//                }
//                for(int j=i-1; j>=0; j--){
//                    if(num[i]+j == num[num[i]]) return;
//                }
//            }

            System.out.print(count + "번째 경우 ");
            //for(int i=0; i<N; i++) System.out.print(arr[selection[i]]);
            System.out.println();
            count++;
            return;
        } // 종료

        for(int i=0; i<arr.length; i++) {
            if(isSelected[i]) continue; // 중복된 값을 뽑았을 경우 스킵

            isSelected[i] = true;
            selection[n] = i;
            permutation(n+1); // 여기서 check 함수를 돌리는 식으로 구현할 수 있다
            isSelected[i] = false; // 중복 허용 X (마킹 해제)

        } // 분기
    }}
}
