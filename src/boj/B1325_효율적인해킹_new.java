package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1325_효율적인해킹_new {
    static ArrayList<Integer>[] graph;
    static int N, M;
    static int[] count;
    static int max = 0;
    static boolean[] isVisited;

    static void DFS(int startV){
        count[startV]++;
        isVisited[startV] = true;
        for(int nextNode : graph[startV]) {
            //count[nextNode]++;

            if(!isVisited[nextNode]) DFS(nextNode);
        }
    }

    static void BFS(int startV) {
        isVisited[startV] = true;
        int cnt = 0;
        Queue<Integer> que = new ArrayDeque<>();
        que.add(startV);

        while (!que.isEmpty()) {
            int nowNode = que.poll();
            //cnt++
            for (int nextNode : graph[nowNode]) {
                if(!isVisited[nextNode])
                    que.add(nextNode);
                    //count[nextNode]++;
            }
            count[nowNode]++;
        }
        //count[startV] = cnt;
        //if(cnt>max) max = cnt;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine(), " ");

        int N = Integer.parseInt(token.nextToken()); // 컴퓨터의 수
        int M = Integer.parseInt(token.nextToken()); // 관계의 수

        graph = new ArrayList[N+1]; // padding

        for(int i=1; i<N+1; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            token = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(token.nextToken());
            int v = Integer.parseInt(token.nextToken());

            //graph[v].add(u);
            graph[u].add(v);
        }
        count = new int[N+1];
        for(int i=1; i<N+1; i++){
            isVisited = new boolean[N+1];
            BFS(i);
        }
        //System.out.println(Arrays.toString(count));
        for(int i : count){
            if(i>max) max = i;
        }
        for(int i=1; i<N+1; i++){
            if(count[i] == max) System.out.print(i + " ");
        }
    }
}
