package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1012_유기농배추 {
    static int M, N, K; // 배추밭의 가로 길이, 세로 길이, 배추가 있는 위치의 개수
    static boolean[][] farm;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for(int i=0; i<T; i++) {
            cnt = 0;

            StringTokenizer token = new StringTokenizer(bf.readLine());
            M = Integer.parseInt(token.nextToken());
            N = Integer.parseInt(token.nextToken());
            K = Integer.parseInt(token.nextToken());

            farm = new boolean[M][N];
            for(int j=0; j<K; j++){
                token = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(token.nextToken());
                int y = Integer.parseInt(token.nextToken());
                farm[x][y] = true;
            }
            // input

            for(int x=0; x<M; x++){
                for(int y=0; y<N; y++){
                    if(farm[x][y] == true){
                        search(x, y);
                        cnt++;
                    }
                }
            }
            // operation

            System.out.println(cnt);
            // output
        }
    }

    static void search(int x, int y){
        farm[x][y] = false;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < M && ny >= 0 && ny < N){
                if(farm[nx][ny] == true){
                    search(nx, ny);
                }
            }
        }
    }
}
