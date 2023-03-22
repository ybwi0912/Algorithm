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
 * 강사님 풀이 ***************************************************
 * 완전 탐색을 생각 -> 사이즈를 확인한다 (N, M<=8이고 세 벽을 세우는 경우 경우의 수가 64*64*64로 크지 않기 때문에 완전 탐색을 돌려도 괜찮다)
 * 바이러스 발생 기능 : 다른 배열의 값을 2로 바꾼다
 * 바이러스 좌표를 탐색 : 안전지대를 카운트
 * *************************************************************
 * 꿀팁 ! 테스트가 쉬워보이는 기능부터 구현하자 | 짧은 단위로 끊어서 내가 제대로 코딩하고 있는지 확인하면서 코딩하는 게 좋다
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

    // 벽을 세우는 경우의 수 탐색
    static void dfs(int wallCnt){
        if(wallCnt == 3) { // 벽이 세 개가 설치된 경우 bfs 탐색 시작
            bfs();
            return;
        }

        // 순열 (A, B, C) -> ((1, 1), (1, 2), (1, 3), ...)
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==0){ // 중복 허용 X
                    map[i][j] = 1; // backtracking
                    dfs(wallCnt+1);
                    map[i][j]=0; // 돌아나옴
                }
            }
        }
    }

    static void bfs(){ // 바이러스를 발생시키는 함수
        Queue<Node> que = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 2)
                    que.add(new Node(i, j));
            }
        }

        int [][] cloneMap = new int[n][m];
        for(int i=0; i<n; i++){
            cloneMap[i] = map[i].clone(); // 깊은 복사 : 값을 별도의 메모리로 복사하는 것
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

    // 안전 지대 카운트
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
