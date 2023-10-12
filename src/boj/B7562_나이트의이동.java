package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7562_나이트의이동 {
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[][] board;
    static boolean[][] isVisited;
    static int L;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine()); // 테스트 케이스의 개수
        StringTokenizer token;

        for(int i=0; i<T; i++){
            L = Integer.parseInt(bf.readLine()); // 체스판의 한 변의 길이
            board = new int[L][L];
            isVisited = new boolean[L][L];

            token = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());

            token = new StringTokenizer(bf.readLine());
            int ex = Integer.parseInt(token.nextToken());
            int ey = Integer.parseInt(token.nextToken());

            bfs(x, y, ex, ey);

            System.out.println(board[ex][ey]);
        }
    }

    static void bfs(int x, int y, int ex, int ey){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while(!q.isEmpty()){
            int[] n = q.poll();

            if(n[0] == ex && n[1] == ey) break;

            for(int i=0; i<8; i++){
                int nx = n[0] + dx[i];
                int ny = n[1] + dy[i];

                if(nx>=0 && nx<L && ny>=0 && ny<L && board[nx][ny]==0) {
                    board[nx][ny] = board[n[0]][n[1]] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}
