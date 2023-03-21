package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 2023 - 03 - 21
 * 전상희
 * N x M 연구소에서 벽 세 개를 설치했을 때 얻을 수 있는 안전 영역 크기의 최댓값을 구하시오
 * 조건 : N<=8, M<=8
 * 풀이 ********************************************************
 * DFS 방식 - 빈칸인지 확인하고 벽을 세운다
 * BFS 방식 - 바이러스를 퍼트린다
 * 안전 영역의 최댓값을 계속 구하고 최종으로 구해진 찐 최댓값을 출력한다
 * */
public class B14502_연구소 {
    static final int dx[] = {0, 0, 1, -1};
    static final int dy[] = {1, -1, 0, 0};
    static int map[][];
    static int n, m;
    static int maxSafe = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken()); // 지도의 세로 크기
        m = Integer.parseInt(st.nextToken()); // 지도의 가로 크기

        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //System.out.println(Arrays.deepToString(map));
        dfs(0);
        System.out.println(maxSafe);

    }

    static void dfs(int wallCnt){
        if(wallCnt == 3) { // 벽이 세 개가 설치된 경우 bfs 탐색 시작
            bfs();
            return;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==0){
                    map[i][j] = 1;
                    dfs(wallCnt+1);
                    map[i][j]=0; // 돌아나옴
                }
            }
        }
    }

    static void bfs(){
        Queue<Node> que = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 2)
                    que.add(new Node(i, j));
            }
        }

        int [][] cloneMap = new int[n][m];
        for(int i=0; i<n; i++){
            cloneMap[i] = map[i].clone();
        }

        // BFS 탐색 시작
        while(!que.isEmpty()){
            Node now = que.poll();
            int x = now.x;
            int y = now.y;

            for(int k=0; k<4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];

                // 빈칸일 경우에만 바이러스를 퍼트린다
                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(cloneMap[nx][ny] == 0){
                        que.add(new Node(nx, ny));
                        cloneMap[nx][ny] = 2;
                    }
                }
            }
        }
        findSafe(cloneMap);
    }

    static void findSafe(int[][] cloneMap){
        int safe = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(cloneMap[i][j] == 0) safe++;
            }
        }
        if(maxSafe < safe) maxSafe = safe;
    }

    static class Node {
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
