package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2589_보물섬 {
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0}; // x, y, x, y
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] isVisited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken()); // y
        M = Integer.parseInt(st.nextToken()); // x

        map = new char[N][M];
        isVisited = new boolean[N][M];

        for(int n = 0; n<N; n++){
            String input = bf.readLine();
            for(int m=0; m<M; m++){
                char c = input.charAt(m);
                map[n][m] = c;
            }
        } // map 입력단

        int ans = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){ // 전체 노드 탐색
                if(map[i][j] == 'L'){ // 그런데 육지일 때만!
                    isVisited = new boolean[N][M]; // 방문 배열 초기화
                    int max = BFS(i, j); // (j, i) 좌표 돌린다
                    ans = Math.max(ans, max); // 최댓값 비교
                }
            }
        }

        System.out.println(ans);
    }
    static int BFS(int x, int y){
        Queue<point> queue = new LinkedList<>();
        int max = 0;
        isVisited[x][y] = true;
        queue.add(new point(y, x, 0));

        while(!queue.isEmpty()){
            point p = queue.poll();
            for(int d=0; d<4; d++){ // 입력으로 들어온 노드에 대해 사방탐색
                int newX = p.x + dx[d];
                int newY = p.y + dy[d];
                if(newX >= 0 && newX < M && newY>=0 && newY < N && !isVisited[newY][newX] && map[newY][newX] == 'L'){
                    // x, y가 범위 이내 + 방문되지 않은 노드일 때 + 육지일 때
                    isVisited[newY][newX] = true; // 방문!
                    queue.add(new point(newX, newY, p.cnt + 1)); // 전진
                    max = Math.max(max, p.cnt + 1);
                }
            }
        }
        return max;
    }

    public static class point{
        int x;
        int y;
        int cnt;

        public point(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
