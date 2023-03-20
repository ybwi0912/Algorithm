package DO_IT_chapter3;

import java.util.Scanner;

public class n004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] A = new int[N][N];
        int[][] S = new int[N+1][N+1];
        int[] ans = new int[M];
        int[] q = new int[4];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                A[i][j] = sc.nextInt(); // 2차원 배열 입력받는다
                S[i+1][j+1] = A[i][j]; // 합 배열에 2차원 배열을 깔아놓음
            }
        }

        for(int i=2; i<N+1; i++){
            S[1][i] += S[1][i-1];
            S[i][1] += S[i-1][1];
        }

        for(int i=2; i<N+1; i++){
            for(int j=2; j<N+1; j++){
                S[i][j] += S[i-1][j] + S[i][j-1] -S[i-1][j-1];
            }
        }

//        for(int i=0;i<N+1;i++){
//            for(int j=0;j<N+1;j++){
//                System.out.println(S[i][j]);
//            }
//            System.out.println( );
//        }

        for(int i=0; i<M; i++){
            for(int j=0;j<4;j++){
                q[j] = sc.nextInt();
            }

            ans[i] = S[q[2]][q[3]] - S[q[0]-1][q[3]] -S[q[2]][q[1]-1] + S[q[0]-1][q[1]-1];
        }

        for (int an : ans) {
            System.out.println(an);
        }
    }
}
