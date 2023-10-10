package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16918_봄버맨 {
    public static void main(String[] args) throws IOException {
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());

        int R = Integer.parseInt(token.nextToken());
        int C = Integer.parseInt(token.nextToken());
        int N = Integer.parseInt(token.nextToken());

        int[][] board = new int[R][C];
        char[][] caseA = new char[R][C]; // 1초
        char[][] caseB = new char[R][C]; // 3초
        boolean[][] check;

        for(int i=0; i<R; i++){
            String s = bf.readLine();
            for(int j=0; j<C; j++){
                char c = s.charAt(j);
                caseA[i][j] = c;
                if(c=='.') board[i][j] = 0;
                else if(c=='O') board[i][j] = 3;
            }
        }
        // input

        if(N==1){
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(caseA[i][j]);
                }
                System.out.println();
            }
            return;
        }

        for(int n=2; n<=5; n++){ // 0초부터 N-1초까지, 첫 1초 동안은 아무것도 하지 않기 때문에 1부터 시작
            check = new boolean[R][C];

            // ① 폭탄이 설치되어 있지 않은 모든 칸에 폭탄을 설치한다
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    if(board[i][j]==0) board[i][j]=n+3;
                }
            }

            // ② 폭발의 영향권에 들어있는 칸을 체크한다
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    if(board[i][j] == n){
                        check[i][j] = true;
                        for(int k=0; k<4; k++){
                            int nr = i + dr[k];
                            int nc = j + dc[k];

                            if(nr<0 || nc < 0 || nr>=R || nc>=C) continue;
                            check[nr][nc] = true;
                        }
                    }
                }
            }

            // ③ 체크한 결과를 격자판 배열에 반영한다
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    if(check[i][j]) {
                        board[i][j] = 0;
                        if(n==3) caseB[i][j] = '.';
                        else if(n==5) caseA[i][j] = '.';
                    } else {
                        if(n==3) caseB[i][j] = 'O';
                        else if(n==5) caseA[i][j] = 'O';
                    }
                }
            }
        }
        // opeartion

        if(N%2==0){
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    System.out.print('O');
                }
                System.out.println();
            }
        }
        else if(N%4==1){
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(caseA[i][j]);
                }
                System.out.println();
            }
        }
        else if(N%4==3){
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(caseB[i][j]);
                }
                System.out.println();
            }
        }
        // output
    }
}
