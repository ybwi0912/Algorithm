package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1245_농장관리 {
    static int N, M;
    static int[][] farm;
    static boolean[][] isVisited;
    static int dx[] = {1, 1, 1, 0, 0, -1, -1, -1};
    static int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};
    static boolean a;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        farm = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i=0; i<N; i++){
            token = new StringTokenizer(bf.readLine());
            for(int j=0; j<M; j++){
                farm[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        int ans = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!isVisited[i][j]){
                    a = true;
                    search(i, j);
                    if(a==true) ans++;
                }
            }
        }

        System.out.println(ans);
    }

    static void search(int x, int y){
        isVisited[x][y] = true;
        for(int i=0; i<8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || nx>=N || ny<0 || ny>=M) continue;

            if(farm[nx][ny]>farm[x][y]) a = false;
            if(!isVisited[nx][ny] && farm[nx][ny]==farm[x][y]) search(nx, ny);
        }
    }
}
