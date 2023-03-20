package boj;

import java.util.Scanner;

public class B9663_N_Queen {
    static int N; // 체스판의 크기, 퀸의 개수
    static int num; // 경우의 수
    static int[][] board;
    static void chess(int turn){ // turn : 계층
        if(turn == N) {
            num++;
            return;
        }
        for(int i=0; i<N; i++){
            if(board[turn][i]==0){
                for(int j=0; j<N; j++) {
                    board[turn][j] = 1;
                    board[j][turn] = 1;
                    if (turn + j < N) board[turn + j][j] = 1;
                    if (turn - j >= 0) board[turn - j][j] = 1;
                }
                System.out.println(turn + "번째 말 " + i + "번쨰 칸에 놓음");
                chess(turn+1);
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 크기가 N x N인 체스판
        // 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수

        board = new int[N][N];



        chess(0);

        System.out.println(num);
    }
}
