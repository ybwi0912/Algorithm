package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B3109_빵집 {
    static int R, C;
    static int[][] map;
    static int count = 0;
    static boolean[][] isVisited;
    static int[] dy = {1, 1, 1};
    static int[] dx = {0, 1, -1}; // 오른쪽, 오른쪽 위, 오른쪽 아래

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        isVisited = new boolean[R][C];
        map = new int[R][C];
        for(int i=0; i<R; i++){
            String str = bf.readLine();
            for(int j=0; j<C; j++){
                if(str.charAt(j) == '.') map[i][j] = 0;
                else if(str.charAt(j) == 'x') {
                    map[i][j] = 1;
                    isVisited[i][j] = true; // 여기 고칠수도
                }
            }
        }
        System.out.println(Arrays.deepToString(map));
        // 입력 잘 넣었으니까 행이랑 열 손대지마!!!!

        // 구현부 ///////////////////////////////////////

        for(int i=0; i<C; i++) { // O
            if (map[0][i] == 0) {
                System.out.println("map[0]["+i+"]에서 walk() 실행");
                walk(0, i); // 첫 열 - 출발
            // 고치지 말 것
            }
        }

        // 최종 출력
        System.out.println(count);
    }

    static void walk(int x, int y){ // 끝행까지 잘 도착했는지 y == R로 판단한다
        Queue<Point> que = new LinkedList<>();
        // 오른쪽 하단 이동을 최우선적으로 봐야 될 듯
        int cnt = 0;
        que.add(new Point(x, y));

        // clone이 필요없지 않나?

        boolean[][] clone = new boolean[R][C];
        for(int i=0; i<R; i++){
            clone[i] = isVisited[i].clone();
        }

        while(!que.isEmpty()){
            Point now = que.poll();

            int a = now.x;
            int b = now.y;
            if(a == R-1) {
                count++;
                for(int i=0; i<R; i++){
                    isVisited[i] = clone[i].clone();
                }
                return;
            }

            for(int i=0; i<3; i++){
                int nx = a + dx[i];
                int ny = b + dy[i];
                System.out.println(nx + ", " + ny);
                if(!checkValid(nx, ny)) continue;
                if(clone[nx][ny] != true){
                    que.add(now);
                    clone[nx][ny] = true;
                    break;
                } // 해당 경로가 아닐 때 다시 되돌려놓고 싶은데
            }
        }
    }

    // 밖으로 벗어나지 않나 확인
    static boolean checkValid(int x, int y){
        if(x<0 || x>=R || y<0 || y>=C ) return false;
        else return true;
    }

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
