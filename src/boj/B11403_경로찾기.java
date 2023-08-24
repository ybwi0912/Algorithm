package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11403_경로찾기 {
    static int N; // 정점의 개수
    static int[][] near; // 인접행렬
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(token.nextToken());
        near = new int[N][N];

        for(int i=0; i<N; i++){
            token = new StringTokenizer(bf.readLine());

            for(int j=0; j<N; j++)
                near[i][j] = Integer.parseInt(token.nextToken());
        }
        // input

        int num; // 임시로 쓸 변수

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(near[i][j]==1)
                    queue.add(j); // i에서 갈 수 있는 노드들을 큐에 추가

                while(!queue.isEmpty()){ // BFS를 돌리면서 i와 인접한 노드와 또 인접한 노드들을 체크한다
                    num = queue.poll();
                    search(i, num);
                }
            }
        }
        // operation

        for(int[] arr : near){
            for(int i : arr){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        // output
    }

    // BFS
    static void search(int now, int num){ // 현재 위치한 노드 now, now에 인접한 노드 num
        near[now][num] = 1; // 인접행렬에 반영
        for(int i=0; i<N; i++){
            if(near[num][i]==1 && near[now][i] != 1){
                // 현재 노드와의 인접행렬 값에 1이 들어가 있는 노드는 이미 검사를 끝낸 노드이기 때문에 조건문으로 걸러낸다. 조건을 안 주면 무한루프에 빠진다
                // 예: near[1][2]와 near[2][1]을 반복적으로 돌 수 있다
                queue.add(i); // now에 인접한 노드와 인접해 있는 노드를 큐에 추가한다
            }
        }
    }
}
