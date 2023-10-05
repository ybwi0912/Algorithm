package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 23-10-05
* BOJ 1189번: 컴백홈
* */

public class B1189_컴백홈 {
    static int R, C, K;
    static char[][] map;
    static boolean[][] isvisited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        map = new char[R][C];
        isvisited = new boolean[R][C];

        for(int i=0; i<R; i++){
            String st = bf.readLine();
            for(int j=0; j<C; j++) map[i][j] = st.charAt(j);
        }

        isvisited[R-1][0] = true;
        search(R-1, 0, 1);

        System.out.println(count);
    }

    static void search(int r, int c, int len){
        if(r == 0 && c == C-1){
            if(len==K) count++;
            return;
        }

        for(int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr<0 || nc<0 || nr>=R || nc>=C) continue;

            if(map[nr][nc]=='T' || isvisited[nr][nc]) continue;

            isvisited[nr][nc] = true;
            search(nr, nc, len+1);
            isvisited[nr][nc] = false;
        }
    }
}
