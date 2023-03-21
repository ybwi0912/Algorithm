package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 23. 03. 21
 * 전상희
 * 백준 1325번 
 * DFS로 구현했는데 시간초과가 뜬다.. 시간 제한은 5초나 되는데 왜 안 될까?
 * BFS로 구현했는데  .. 시간 초과 또 뜸
 * */
public class B1325_효율적인해킹 {
    static ArrayList<Integer>[] graph;
    static int N, M;
    static int[] count;
    static boolean[] isVisited;
    static int max = 0;

    static void BFS(int startV){
        int cnt = 0;
        Queue<Integer> que = new ArrayDeque<>();
        isVisited[startV]=true;
        que.add(startV);

        while(!que.isEmpty()){
            int nowNode = que.poll();
            cnt++;
            for(int nextNode : graph[nowNode]){
                if(!isVisited[nextNode]) {
                    isVisited[nextNode] = true;
                    que.add(nextNode);
                }
            }
        }

        count[startV] = cnt;
        if(cnt>max) max = cnt;
//      위 코드로 바꿨더니 시간 초과가 안 떴다
//        if (cnt >= max) {
//            max = cnt;
//            count[startV] = cnt;
//        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine(), " ");

        N = Integer.parseInt(token.nextToken()); // 컴퓨터의 수
        M = Integer.parseInt(token.nextToken()); // 관계의 수

        graph = new ArrayList[N+1]; // padding

        for(int i=1; i<N+1; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            token = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(token.nextToken());
            int v = Integer.parseInt(token.nextToken());

            graph[v].add(u);
        }
        count = new int[N+1];

        for(int i=1; i<N+1; i++){
            isVisited = new boolean[N+1];
            BFS(i);
        }

        for(int i=1; i<N+1; i++){
            if(count[i] == max) System.out.print(i + " ");
        }
    }
}
