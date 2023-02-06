package chapter3;

import java.util.Scanner;

public class n003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M;
        int i, j;

        N = sc.nextInt();
        M = sc.nextInt();

        int[] A = new int[N];
        int[] S = new int[N+1]; // n번째 수가 S[n-1]이 아니라 S[n]에 들어가도록 선언
        int[] ans = new int[M];

        A[0] = sc.nextInt();
        S[0] = 0;
        S[1] = A[0];

        for (int n=1; n<N; n++){
            A[n] = sc.nextInt();
            S[n+1] = S[n] + A[n]; // 합 배열
        }

        for (int n=0; n<M; n++){
            i=sc.nextInt();
            j=sc.nextInt();
            ans[n] = S[j] - S[i-1]; // 구간 합
        }
        for (int an : ans) {
            System.out.println(an);
        }
    }
}
