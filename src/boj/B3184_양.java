package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3184_양 {
    static int R, C;
    static char[][] field;
    static boolean[][] isVisited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int s=0, w=0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());

        field = new char[R][C];
        isVisited = new boolean[R][C];

        for(int i=0; i<R; i++){
            field[i] = bf.readLine().toCharArray();
        }
        // input

        int sheeps=0, wolves=0;

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                s = 0;
                w = 0;

                if(!isVisited[i][j] && field[i][j] != '#') search(i, j);

                if(s>w) sheeps += s;
                else wolves += w;
            }
        }
        // operation

        System.out.println(sheeps + " " + wolves);
        // output
    }

    static void search(int r, int c){
        isVisited[r][c] = true;

        if(field[r][c]=='v') w++;
        if(field[r][c]=='o') s++;

        for(int i=0; i<4; i++){
            int nr = r + dx[i];
            int nc = c + dy[i];

            if(nr<0 || nr>=R || nc<0 || nc>=C || isVisited[nr][nc] || field[nr][nc]=='#') continue;

            search(nr, nc);
        }
    }
}
