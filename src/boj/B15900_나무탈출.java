package boj;

/*
* 2023-09-07
* BOJ 15900번: 나무 탈출
* 트리를 그렸을 때, 모든 리프 노드의 depth의 합이 홀수이면 성원이가 이기고(Yes), 합이 짝수이면 형석이가 이긴다(No).
* tree 내의 각 ArrayList들이 트리의 각 노드들. 방향이 없는 그래프이기 때문에 양쪽 노드에 서로를 추가해준 다음에 DFS로 루트 노드부터 전체 노드를 방문한다
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B15900_나무탈출 {
    static List<ArrayList<Integer>> tree = new ArrayList<>();
    static boolean[] isVisited; // 각 노드의 방문 여부 체크하기 위한 배열
    static int sum=0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(token.nextToken()); // 트리의 정점의 개수

        isVisited = new boolean[N+1];

        for(int i=0; i<=N; i++)
            tree.add(new ArrayList<>());


        for(int i=0; i<N-1; i++){
            token = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
            // 방향이 없는 그래프이기 때문에 양쪽에 추가해준다
        }
        // input

        dfs(1, 0);
        // operation

        if(sum%2!=0) System.out.println("Yes");
        else System.out.println("No");
        // output
    }

    static void dfs(int vertex, int depth){
        isVisited[vertex] = true; // 해당 정점 방문 처리
        for(int next: tree.get(vertex)){ // 해당 정점에서 방문할 수 있는 모든 정점들에 대해서
            if(!isVisited[next]){ // 다음 정점에 방문하지 않았다면
                dfs(next, depth+1);
            }
        }

        if(tree.get(vertex).size()==1 && vertex != 1){
            sum += depth;
        }
    }
}
